
package com.challenge.Services;

import com.challenge.Model.Enums.Allignment;

import java.util.List;
import java.util.stream.Collectors;

import com.challenge.Model.Enums.MotionRotationalDirection;
import com.challenge.Model.Planet;
import com.challenge.Model.Position;
import org.springframework.stereotype.Service;


@Service
public class GeometricRequest {

	public static Allignment getGeometricResult(List<Planet> planets, int day) {
		GeometricEvaluator geometricEvaluator = new LineEvaluator();

		return geometricEvaluator.evaluate(planets, day);
	}
	
}