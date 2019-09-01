package com.challenge.Services;

import com.challenge.Model.Enums.Allignment;
import com.challenge.Model.Planet;

import java.util.List;

public class TriangleEvaluator extends GeometricEvaluator {
    @Override
    public Allignment evaluate(List<Planet> planets, int day) {



        return this.evaluateNext(planets, day);
    }
}
