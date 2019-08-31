package com.challenge.Services;


import com.challenge.Model.Position;
import org.springframework.stereotype.Service;

@Service
public class PlanetsAllignment implements GeometricCalculator {
	
	PlanetsAllignment() {}


	public static boolean arePointsColinear(Position vulcanos, Position ferengis, Position besaoides) {

		double slopeA,slopeB;

		/*
			Formula to determine wether three points are colinear comparing
			the slopes formed with the following points:

			y2 - y1 / x2 - x1  ==  y3 - y2 / x3 - x2 

			hence

			(y2 - y1) * (x3 - x2) - (y3 - y2) * (x2 - x1)

			We are assuming that we'll always have three points.
		*/
		slopeA = (ferengis.getCoordinateY() - vulcanos.getCoordinateY()) * ( besaoides.getCoordinateX() - ferengis.getCoordinateX()) ;
		slopeB = (besaoides.getCoordinateY() - ferengis.getCoordinateY()) * ( ferengis.getCoordinateX() - vulcanos.getCoordinateX()) ;

		return slopeA - slopeB <= 1.2e-12;
	}

}