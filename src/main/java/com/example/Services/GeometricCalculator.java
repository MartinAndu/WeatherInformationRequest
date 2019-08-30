
package com.example.Services;

import com.example.Model.Enums.Allignment;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.Model.Enums.MotionRotationalDirection;
import com.example.Model.Planet;
import com.example.Model.Position;
import org.springframework.stereotype.Service;


@Service
public interface GeometricCalculator {

	public static Allignment getGeometricResult(List<Planet> planets, int day) {

		// I assume I'm getting three planets as a parameter

		// Getting positions from each planet.
		List<Position> positions = planets.stream().map( x -> x.getPosition(day)).collect(Collectors.toList());

		if (PlanetsAllignment.arePointsColinear(positions.get(0), positions.get(1), positions.get(2))) {
			// At this point, I've already proved that the points are colinear
			// If these points are already colinear, I just need to check out
			// if any of these are colinear with the sun itself as a planet

			Planet Sun = new Planet("Sun",0, MotionRotationalDirection.CLOCKWISE, 90, 0);
			if (PlanetsAllignment.arePointsColinear(Sun.getPosition(0), positions.get(0), positions.get(1))) {
				return Allignment.PLANETS_ALLIGNED_WITH_SUN;
			}
			return Allignment.PLANETS_ALLIGNED;
		}

		return  Allignment.NO_ALLIGNMENT;
	}
	
}