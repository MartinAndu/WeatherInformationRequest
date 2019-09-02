package com.challenge.Services;

import com.challenge.Model.Enums.Weather;
import com.challenge.Model.Enums.Allignment;
import com.challenge.Model.Planet;
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
		this.weatherCondition = new HashMap<Allignment, Weather>();
		weatherCondition.put(Allignment.NO_ALLIGNMENT, Weather.NO_INFORMATION);
		weatherCondition.put(Allignment.PLANETS_ALLIGNED, Weather.OPTIMAL);
		weatherCondition.put(Allignment.PLANETS_ALLIGNED_WITH_SUN, Weather.DROUGHNESS);
		weatherCondition.put(Allignment.PLANETS_FORMING_TRIANGLE_WITH_SUN, Weather.RAIN);
		weatherCondition.put(Allignment.PLANETS_FORMING_TRIANGLE_WITH_SUN_MAX_PERIMETER, Weather.MAX_RAIN);
	}

	public void orbitAroundTheSun(List<Planet> planets, int amountOfDays) {
		for (int day = 0; day < amountOfDays; day++) {
			System.out.println(getWeatherOnDay(planets, day) + "," + day);
		}
	}

	private Weather getWeatherOnDay(List<Planet> planets, int day) {
		return weatherCondition.get(GeometricRequest.getGeometricResult(planets, day));
	}

}