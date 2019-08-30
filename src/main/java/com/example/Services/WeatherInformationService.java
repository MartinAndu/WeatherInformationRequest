package com.example.Services;

import com.example.Model.Enums.Weather;
import com.example.Model.Enums.Allignment;
import com.example.Model.Planet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WeatherInformationService {

	private List<Planet> planets;

	private Map<Allignment, Weather> weatherCondition;

	@Autowired
	public WeatherInformationService(List<Planet> planets) {
		this.planets = planets;
		this.weatherCondition = new HashMap<Allignment, Weather>();
		weatherCondition.put(Allignment.NO_ALLIGNMENT, Weather.NO_INFORMATION);
		weatherCondition.put(Allignment.PLANETS_ALLIGNED, Weather.DROUGHNESS);
		weatherCondition.put(Allignment.PLANETS_ALLIGNED_WITH_SUN, Weather.OPTIMAL);
		weatherCondition.put(Allignment.PLANETS_FORMING_TRIANGLE_WITH_SUN, Weather.RAINY);

	}

	public Weather getWeatherOnDay(int day) {
		return weatherCondition.get(GeometricCalculator.getGeometricResult(planets, day));
	}

}