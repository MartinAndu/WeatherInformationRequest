package com.challenge.Helpers;


import com.challenge.Model.Position;
import com.challenge.Model.SolarSystem;
import com.challenge.Services.WeatherInformationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class PlanetsAllignment  {

    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherInformationService.class);

    private static final Double DECIMAL_THRESHOLD = 1.2e-5;

    PlanetsAllignment() {}


	public static boolean arePointsColinear(List<Position> positions) {


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
			slopes signature formed by planets at the current day vs slopes signature
			formed by planets at the previous day
		 */
		List<Position> currentPositions = solarSystem.getPositionOnDay(day);
		List<Position> previousPositions = solarSystem.getPositionOnDay(day - 1);


		Double currentFinalAngle = calculateTotalAngle(currentPositions);
		Double previousFinalAngle = calculateTotalAngle(previousPositions);

//		return currentFinalAngle < previousFinalAngle;
		return (previousFinalAngle  > DECIMAL_THRESHOLD && currentFinalAngle < DECIMAL_THRESHOLD) || ( previousFinalAngle < DECIMAL_THRESHOLD && currentFinalAngle > DECIMAL_THRESHOLD) && !arePointsColinear(previousPositions);
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