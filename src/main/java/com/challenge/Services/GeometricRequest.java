
package com.challenge.Services;

import com.challenge.Model.Enums.Allignment;

import java.util.List;

import com.challenge.Model.Planet;
import com.challenge.Model.SolarSystem;
import com.challenge.Services.Evaluator.AngleChangeEvaluator;
import com.challenge.Services.Evaluator.GeometricEvaluator;
import com.challenge.Services.Evaluator.LineEvaluator;
import com.challenge.Services.Evaluator.TriangleEvaluator;
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