package com.challenge.helpers;


import com.challenge.exceptions.Messages;
import com.challenge.exceptions.types.PlanetsOutOfBoundsException;
import com.challenge.exceptions.validators.PositionValidator;
import com.challenge.model.Position;
import com.challenge.model.SolarSystem;
import com.challenge.services.WeatherInformationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.awt.geom.Line2D;
import java.util.List;

@Service
public class PlanetsAllignment  {

    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherInformationService.class);

    private static final Double DECIMAL_THRESHOLD = 1.2e-5;

	public static boolean arePointsColinear(List<Position> positions) {
		if (!PositionValidator.ValidatePositionsSize(positions)) throw new PlanetsOutOfBoundsException(Messages.OUT_OF_BOUNDS_PLANETS);

		Line2D line = new Line2D.Double(positions.get(0).getCoordinateX(),
				positions.get(0).getCoordinateY(),
				positions.get(1).getCoordinateX(),
				positions.get(1).getCoordinateY());

		double distance = line.ptLineDist(positions.get(2).getCoordinateX(),
				positions.get(2).getCoordinateY());

		return Math.abs(distance) <=  DECIMAL_THRESHOLD;
	}

	public static boolean planetAllignmentTransition(SolarSystem solarSystem, int day) {
		/*
			A temporal allignment could take place while planets are orbitings.
			A possible workaround to detect that transition is by comparing
			angle signature formed by planets at the current day against angle signature
			formed by planets at the previous day
		 */
		List<Position> currentPositions = solarSystem.getPositionOnDay(day);

		if (!PositionValidator.ValidatePositionsSize(currentPositions)) throw new PlanetsOutOfBoundsException(Messages.OUT_OF_BOUNDS_PLANETS);

		List<Position> previousPositions = solarSystem.getPositionOnDay(day - 1);


		Double currentFinalAngle = calculateTotalAngle(currentPositions);
		Double previousFinalAngle = calculateTotalAngle(previousPositions);

		return (previousFinalAngle  > DECIMAL_THRESHOLD && currentFinalAngle < DECIMAL_THRESHOLD)
				|| ( previousFinalAngle < DECIMAL_THRESHOLD && currentFinalAngle > DECIMAL_THRESHOLD)
				&& !arePointsColinear(previousPositions);
	}

	private static Double calculateTotalAngle(List<Position> position) {
		Double angle1 = calculatePartialAngle(position.get(0).getCoordinateX(), position.get(1).getCoordinateX(), position.get(0).getCoordinateY(), position.get(1).getCoordinateY());
		Double angle2 = calculatePartialAngle(position.get(1).getCoordinateX(), position.get(2).getCoordinateX(), position.get(1).getCoordinateY(), position.get(2).getCoordinateY());
		return Math.abs(angle1) - Math.abs(angle2);
	}

	private static Double calculatePartialAngle(Double x1, Double x2, Double y1, Double y2) {
		return Math.atan2(y1 - y2, x1 - x2);
	}

}