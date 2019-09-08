
package com.challenge.Helpers;

import com.challenge.Model.Enums.Allignment;

import com.challenge.Model.SolarSystem;
import com.challenge.Evaluator.AngleChangeEvaluator;
import com.challenge.Evaluator.GeometricEvaluator;
import com.challenge.Evaluator.LineEvaluator;
import com.challenge.Evaluator.TriangleEvaluator;
import org.springframework.stereotype.Service;


@Service
public class GeometricRequest {

	public static Allignment getGeometricResult(SolarSystem solarSystem, int day) {
		GeometricEvaluator geometricEvaluator = new LineEvaluator();
		geometricEvaluator.linkWith(new TriangleEvaluator())
						  .linkWith(new AngleChangeEvaluator());

		return geometricEvaluator.evaluate(solarSystem, day);
	}
	
}