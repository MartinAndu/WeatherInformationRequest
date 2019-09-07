package com.challenge.Services.Evaluator;


import com.challenge.Model.Enums.Allignment;
import com.challenge.Model.Planet;
import com.challenge.Model.Position;
import com.challenge.Model.SolarSystem;
import com.challenge.Services.Evaluator.GeometricEvaluator;
import com.challenge.Services.PlanetsAllignment;

import java.util.List;
import java.util.stream.Collectors;

public class LineEvaluator extends GeometricEvaluator {

    @Override
    public Allignment evaluate(SolarSystem solarSystem, int day) {

        // I assume I'm getting three planets as a parameter

        // Getting positions from each planet.
        List<Position> positions = solarSystem.getPositionOnDay(day);

        if (PlanetsAllignment.arePointsColinear(positions)) {
            // At this point, I've already proved that the points are colinear
            // If these points are already colinear, I just need to check out
            // if any of these are colinear with the sun itself as a position.

            // Sun position
            Position centerPosition = new Position(0.00, 0.00);
            positions.set(0, centerPosition);
            if (PlanetsAllignment.arePointsColinear(positions)) {
                return Allignment.PLANETS_ALLIGNED_WITH_SUN;
            }
            return Allignment.PLANETS_ALLIGNED;
        }

        return  this.evaluateNext(solarSystem, day);
    }
}

