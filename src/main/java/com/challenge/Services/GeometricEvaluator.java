package com.challenge.Services;

import com.challenge.Model.Enums.Allignment;
import com.challenge.Model.Planet;

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
    public abstract Allignment evaluate(List<Planet> planets, int day);

    /*
        Evaluates next object of the chain
    */
    protected Allignment evaluateNext(List<Planet> planets, int day) {
        if (this.nextEvaluator == null) {
            return Allignment.NO_ALLIGNMENT;
        }
        return nextEvaluator.evaluate(planets, day);
    }

}
