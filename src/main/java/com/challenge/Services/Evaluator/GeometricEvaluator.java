package com.challenge.Services.Evaluator;

import com.challenge.Model.Enums.Allignment;
import com.challenge.Model.Planet;
import com.challenge.Model.SolarSystem;

import java.util.List;

/*
    Chain of responsibility class used to evaluate every geometric shape
    formed by the planets
 */
public abstract class GeometricEvaluator {

    private GeometricEvaluator nextEvaluator;

    /*
        Builds chains of Evaluator objects
     */
    public GeometricEvaluator linkWith(GeometricEvaluator nextEvaluator) {
        this.nextEvaluator = nextEvaluator;
        return nextEvaluator;
    }

    /*
        Returns type of geometric result
     */
    public abstract Allignment evaluate(SolarSystem solarSystem, int day);

    /*
        Evaluates next object of the chain
    */
    protected Allignment evaluateNext(SolarSystem solarSystem, int day) {
        if (this.nextEvaluator == null) {
            return Allignment.NO_ALLIGNMENT;
        }
        return nextEvaluator.evaluate(solarSystem, day);
    }

}
