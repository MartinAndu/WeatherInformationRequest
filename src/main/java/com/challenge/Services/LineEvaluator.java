package com.challenge.Services;


import com.challenge.Model.Enums.Allignment;
import com.challenge.Model.Planet;
import com.challenge.Model.Position;

import java.util.List;
import java.util.stream.Collectors;

public class LineEvaluator extends GeometricEvaluator {

    @Override
    public Allignment evaluate(List<Planet> planets, int day) {

        // I assume I'm getting three planets as a parameter

        // Getting positions from each planet.
        List<Position> positions = planets.stream().map(x -> x.getPosition(day)).collect(Collectors.toList());

        if (PlanetsAllignment.arePointsColinear(positions.get(0), positions.get(1), positions.get(2))) {
            // At this point, I've already proved that the points are colinear
            // If these points are already colinear, I just need to check out
            // if any of these are colinear with the sun itself as a position.

            // Sun position
            Position centerPosition = new Position(0.00, 0.00);

            if (PlanetsAllignment.arePointsColinear(centerPosition, positions.get(0), positions.get(1))) {
                return Allignment.PLANETS_ALLIGNED_WITH_SUN;
            }
            return Allignment.PLANETS_ALLIGNED;
        }

        return  this.evaluateNext(planets, day);
    }
}

