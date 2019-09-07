package com.challenge.Services;


import com.challenge.Model.Position;
import com.challenge.Model.SolarSystem;
import org.springframework.stereotype.Service;

import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class PlanetsAllignment  {
	
	PlanetsAllignment() {}


	public static boolean arePointsColinear(List<Position> positions) {


		Line2D line = new Line2D.Double(positions.get(0).getCoordinateX(),
				positions.get(0).getCoordinateY(),
				positions.get(1).getCoordinateX(),
				positions.get(1).getCoordinateY());

		double distance = line.ptLineDist(positions.get(2).getCoordinateX(),
				positions.get(2).getCoordinateY());

		return Math.abs(distance) <=  1.2e-5;
//
//		/*
//			double slopeA,slopeB;
//			Formula to determine whether three points are collinear comparing
//			the slopes formed with the following points:
//
//			y3 - y2 / x3 - x2 == y2 - y1 / x2 - x1
//
//			hence
//
//			(y2 - y1) * (x3 - x2) - (y3 - y2) * (x2 - x1) == 0
//
//			We are assuming that we'll always have three points.
//		*/
//		slopeA = Math.round((position2.getCoordinateY() - position1.getCoordinateY()) * ( position3.getCoordinateX() - position2.getCoordinateX()));
//		slopeB = Math.round((position3.getCoordinateY() - position2.getCoordinateY()) * ( position2.getCoordinateX() - position1.getCoordinateX()));
//
//		// TODO : change equation and use a const for 1.2e-5
//		return Math.abs(BigDecimal.valueOf(slopeA).subtract(BigDecimal.valueOf(slopeB)).doubleValue()) <= 1.2e-5;
////		return Math.abs(BigDecimal.valueOf(slopeA).subtract(BigDecimal.valueOf(slopeB)).doubleValue()) <= 1.2e-5;
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
		return (previousFinalAngle  >= 0 && currentFinalAngle <= 0) || ( previousFinalAngle <= 0 && currentFinalAngle >= 0);
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