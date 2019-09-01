package com.challenge.Services;


import com.challenge.Model.Position;
import org.springframework.stereotype.Service;

@Service
public class PlanetsAllignment  {
	
	PlanetsAllignment() {}


	public static boolean arePointsColinear(Position position1, Position position2, Position position3) {

		double slopeA,slopeB;

		/*
			Formula to determine whether three points are collinear comparing
			the slopes formed with the following points:

			y2 - y1 / x2 - x1  ==  y3 - y2 / x3 - x2 

			hence

			(y2 - y1) * (x3 - x2) - (y3 - y2) * (x2 - x1) == 0

			We are assuming that we'll always have three points.
		*/
		slopeA = (position2.getCoordinateY() - position1.getCoordinateY()) * ( position3.getCoordinateX() - position2.getCoordinateX());
		slopeB = (position3.getCoordinateY() - position2.getCoordinateY()) * ( position2.getCoordinateX() - position1.getCoordinateX());

		return Math.abs(slopeA - slopeB) <= 1.2e-12;
	}

}