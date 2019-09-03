package com.challenge.Services;


import com.challenge.Model.Position;
import com.challenge.Model.SolarSystem;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PlanetsAllignment  {
	
	PlanetsAllignment() {}


	public static boolean arePointsColinear(Position position1, Position position2, Position position3) {

		double slopeA,slopeB;

		/*
			Formula to determine whether three points are collinear comparing
			the slopes formed with the following points:

			y3 - y2 / x3 - x2 == y2 - y1 / x2 - x1

			hence

			(y2 - y1) * (x3 - x2) - (y3 - y2) * (x2 - x1) == 0

			We are assuming that we'll always have three points.
		*/
		slopeA = (position3.getCoordinateY() - position2.getCoordinateY()) * ( position2.getCoordinateX() - position1.getCoordinateX());
		slopeB = (position2.getCoordinateY() - position1.getCoordinateY()) * ( position3.getCoordinateX() - position2.getCoordinateX());

		// TODO : change equation and use a const for 1.2e-5
		return Math.abs(BigDecimal.valueOf(slopeA).subtract(BigDecimal.valueOf(slopeB)).doubleValue()) <= 1.2e-5;
	}

	public static boolean planetAllignmentTransition(SolarSystem solarSystem, int day) {
		/*
			A temporal allignment could take place while planets are orbitings.
			A possible workaround to detect that transition it by comparing
			slopes signature formed by planets at the current day vs slopes signature
			formed by planets at the previous day
		 */
		double previousSlopeA, previousSlopeB, currentSlopeA, currentSlopeB;
		List<Position> currentPosition = solarSystem.getPositionOnDay(day);
		List<Position> previousPosition = solarSystem.getPositionOnDay(day - 1);

		currentSlopeA = (currentPosition.get(2).getCoordinateY() - currentPosition.get(1).getCoordinateY()) / ( currentPosition.get(2).getCoordinateX() - currentPosition.get(1).getCoordinateX());
		currentSlopeB = (currentPosition.get(1).getCoordinateY() - currentPosition.get(0).getCoordinateY()) / ( currentPosition.get(1).getCoordinateX() - currentPosition.get(0).getCoordinateX());

		previousSlopeA = (previousPosition.get(2).getCoordinateY() - previousPosition.get(1).getCoordinateY()) / ( previousPosition.get(2).getCoordinateX() - previousPosition.get(1).getCoordinateX());
		previousSlopeB = (previousPosition.get(1).getCoordinateY() - previousPosition.get(0).getCoordinateY()) / ( previousPosition.get(1).getCoordinateX() - previousPosition.get(0).getCoordinateX());

		// Previous slopeA > 0 , current slopeA < 0
		// Previous slopeA < 0, current slopeA > 0
		//  Previous slopeB > 0 , current slopeB < 0
		// Previous slopeB < 0, current slopeB > 0
		return (((previousSlopeA > 0 && currentSlopeA < 0) || (previousSlopeA < 0 && currentSlopeA > 0)
		) && ((previousSlopeB > 0 && currentSlopeB < 0) || (previousSlopeB < 0 && currentSlopeB > 0)
		));
	}

}