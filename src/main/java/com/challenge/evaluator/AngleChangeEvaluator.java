package com.challenge.evaluator;

import com.challenge.model.enums.Allignment;
import com.challenge.model.SolarSystem;
import com.challenge.helpers.PlanetsAllignment;

public class AngleChangeEvaluator extends GeometricEvaluator {


    @Override
    public Allignment evaluate(SolarSystem solarSystem, int day) {

        if (PlanetsAllignment.planetAllignmentTransition(solarSystem, day)) {
            return Allignment.PLANETS_ALLIGNED;
        }

        return this.evaluateNext(solarSystem, day);
    }
}
