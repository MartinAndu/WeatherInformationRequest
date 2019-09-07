package com.challenge.Services;

import com.challenge.Model.Enums.Weather;
import com.challenge.Model.Enums.Allignment;
import com.challenge.Model.SolarSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

@Service
public class WeatherInformationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(WeatherInformationService.class);

	private Map<Allignment, Weather> weatherCondition;

	private Weather lastSeasonWeather;

	@Autowired
	public WeatherInformationService() {
		this.weatherCondition = new HashMap<>();
		this.lastSeasonWeather = Weather.NO_INFORMATION;
		weatherCondition.put(Allignment.NO_ALLIGNMENT, Weather.NO_INFORMATION);
		weatherCondition.put(Allignment.PLANETS_ALLIGNED, Weather.OPTIMAL);
		weatherCondition.put(Allignment.PLANETS_ALLIGNED_WITH_SUN, Weather.DROUGHNESS);
		weatherCondition.put(Allignment.PLANETS_FORMING_TRIANGLE_WITH_SUN, Weather.RAIN);
		weatherCondition.put(Allignment.PLANETS_FORMING_TRIANGLE_WITH_SUN_MAX_PERIMETER, Weather.MAX_RAIN);
	}

	public void orbitAroundTheSun(SolarSystem solarSystem, int amountOfDays) {

		// TODO: use a constant for rotation limit
		for (int day = 0; day < 4000; day++) {
//			LOGGER.info("Clima para día: " + day);
//			LOGGER.info("Tipo de Clima es : " + getWeatherOnDay(solarSystem, day));
			System.out.println(getWeatherOnDay(solarSystem, day) + "," + day);
		}
	}

	private Weather getWeatherOnDay(SolarSystem solarSystem, int day) {
		Weather weatherReported = weatherCondition.get(GeometricRequest.getGeometricResult(solarSystem, day));
		// In case there was no result, the weather season should be remain the same
		// until a new weather forecast is published

		// TODO: improve this code
/*		if ( day > 0 && weatherReported.equals(Weather.NO_INFORMATION)) {
			weatherReported = this.lastSeasonWeather;
		} else {
			this.lastSeasonWeather = weatherReported;
		}*/

		return weatherReported;
	}

}