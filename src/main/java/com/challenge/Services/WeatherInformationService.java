package com.challenge.Services;

import com.challenge.Model.Enums.Weather;
import com.challenge.Model.Enums.Allignment;
import com.challenge.Model.Planet;
import com.challenge.Model.SolarSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WeatherInformationService {

	private Map<Allignment, Weather> weatherCondition;

	@Autowired
	public WeatherInformationService() {
		this.weatherCondition = new HashMap<>();
		weatherCondition.put(Allignment.NO_ALLIGNMENT, Weather.NO_INFORMATION);
		weatherCondition.put(Allignment.PLANETS_ALLIGNED, Weather.OPTIMAL);
		weatherCondition.put(Allignment.PLANETS_ALLIGNED_WITH_SUN, Weather.DROUGHNESS);
		weatherCondition.put(Allignment.PLANETS_FORMING_TRIANGLE_WITH_SUN, Weather.RAIN);
		weatherCondition.put(Allignment.PLANETS_FORMING_TRIANGLE_WITH_SUN_MAX_PERIMETER, Weather.MAX_RAIN);
	}

	public void orbitAroundTheSun(SolarSystem solarSystem, int amountOfDays) {
		for (int day = 0; day < amountOfDays; day++) {
			System.out.println(getWeatherOnDay(solarSystem, day) + "," + day);
		}
	}

	private Weather getWeatherOnDay(SolarSystem solarSystem, int day) {
		return weatherCondition.get(GeometricRequest.getGeometricResult(solarSystem, day));
	}

}