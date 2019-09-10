package com.challenge.evaluator;


import com.challenge.model.enums.Allignment;
import com.challenge.model.Position;
import com.challenge.model.SolarSystem;
import com.challenge.helpers.PlanetsAllignment;

import java.util.List;

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

