package com.challenge.Services;

import com.challenge.Model.Enums.Allignment;
import com.challenge.Model.Planet;
import com.challenge.Model.Position;

import java.util.List;
import java.util.stream.Collectors;

public class TriangleEvaluator extends GeometricEvaluator {
    @Override
    public Allignment evaluate(List<Planet> planets, int day) {

        List<Position> currentPositions = planets.stream().map(x -> x.getPosition(day)).collect(Collectors.toList());

        if (PlanetsTriangle.isSunInsideATriangle(currentPositions.get(0), currentPositions.get(1), currentPositions.get(2))) {
            List<Position> previousPositions = planets.stream().map(x -> x.getPosition(day-1)).collect(Collectors.toList());
            List<Position> nextPositions = planets.stream().map(x -> x.getPosition(day+1)).collect(Collectors.toList());

            // There's a peak in every rainy season . To reach that limit, We've got to compare the perimeter among
            // the previous day and the next day.
            Double currentArea = PlanetsTriangle.calculateArea(currentPositions);
            if (currentArea > PlanetsTriangle.calculateArea(previousPositions) && currentArea > PlanetsTriangle.calculateArea(nextPositions)) {
                return Allignment.PLANETS_FORMING_TRIANGLE_WITH_SUN_MAX_PERIMETER;
            }
            return Allignment.PLANETS_FORMING_TRIANGLE_WITH_SUN;
        }

        return this.evaluateNext(planets, day);
    }
}
