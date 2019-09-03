package com.challenge.Services.Evaluator;

import com.challenge.Model.Enums.Allignment;
import com.challenge.Model.Planet;
import com.challenge.Model.Position;
import com.challenge.Model.SolarSystem;
import com.challenge.Services.Evaluator.GeometricEvaluator;
import com.challenge.Services.PlanetsTriangle;

import java.util.List;
import java.util.stream.Collectors;

public class TriangleEvaluator extends GeometricEvaluator {
    @Override
    public Allignment evaluate(SolarSystem solarSystem, int day) {

        List<Position> currentPositions =  solarSystem.getPositionOnDay(day);

        if (PlanetsTriangle.isSunInsideATriangle(currentPositions.get(0), currentPositions.get(1), currentPositions.get(2))) {
            List<Position> previousPositions = solarSystem.getPositionOnDay(day - 1);
            List<Position> nextPositions = solarSystem.getPositionOnDay(day + 1);

            // There's a peak in every rainy season . To reach that limit, We've got to compare the perimeter among
            // the previous day and the next day.
            Double currentArea = PlanetsTriangle.calculateArea(currentPositions);
            if (currentArea > PlanetsTriangle.calculateArea(previousPositions) && currentArea > PlanetsTriangle.calculateArea(nextPositions)) {
                return Allignment.PLANETS_FORMING_TRIANGLE_WITH_SUN_MAX_PERIMETER;
            }
            return Allignment.PLANETS_FORMING_TRIANGLE_WITH_SUN;
        }

        return this.evaluateNext(solarSystem, day);
    }
}
