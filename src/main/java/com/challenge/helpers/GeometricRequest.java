
package com.challenge.helpers;

import com.challenge.model.enums.Allignment;

import com.challenge.model.SolarSystem;
import com.challenge.evaluator.AngleChangeEvaluator;
import com.challenge.evaluator.GeometricEvaluator;
import com.challenge.evaluator.LineEvaluator;
import com.challenge.evaluator.TriangleEvaluator;
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