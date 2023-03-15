package com.challenge.evaluator;

import com.challenge.model.enums.Allignment;
import com.challenge.model.Position;
import com.challenge.model.SolarSystem;
import com.challenge.helpers.PlanetsTriangle;

import java.util.List;

public class TriangleEvaluator extends GeometricEvaluator {
    @Override
    public Allignment evaluate(SolarSystem solarSystem, int day) {

        List<Position> currentPositions =  solarSystem.getPositionOnDay(day);

        if (PlanetsTriangle.isSunInsideATriangle(currentPositions)) {
            List<Position> previousPositions = solarSystem.getPositionOnDay(day - 1);
            List<Position> nextPositions = solarSystem.getPositionOnDay(day + 1);

            // There's a peak in every rain season . To reach that limit, We need to compare the perimeter among
            // the previous day and the next day.
            Double currentArea = PlanetsTriangle.calculatePerimeter(currentPositions);
            if (currentArea > PlanetsTriangle.calculatePerimeter(previousPositions) && currentArea > PlanetsTriangle.calculatePerimeter(nextPositions)) {
                return Allignment.PLANETS_FORMING_TRIANGLE_WITH_SUN_MAX_PERIMETER;
            }
            return Allignment.PLANETS_FORMING_TRIANGLE_WITH_SUN;
        }

        return this.evaluateNext(solarSystem, day);
    }
}
