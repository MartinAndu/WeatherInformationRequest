package com.challenge.Evaluator;

import com.challenge.Model.Enums.Allignment;
import com.challenge.Model.SolarSystem;
import com.challenge.Helpers.PlanetsAllignment;

public class AngleChangeEvaluator extends GeometricEvaluator {


    @Override
    public Allignment evaluate(SolarSystem solarSystem, int day) {

        if (PlanetsAllignment.planetAllignmentTransition(solarSystem, day)) {
            return Allignment.PLANETS_ALLIGNED;
        }

        return this.evaluateNext(solarSystem, day);
    }
}
