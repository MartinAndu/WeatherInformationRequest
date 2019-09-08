package com.challenge.Services;

import com.challenge.DTOs.WeatherReportDTO;
import com.challenge.Helpers.GeometricRequest;
import com.challenge.Model.Enums.Weather;
import com.challenge.Model.Enums.Allignment;
import com.challenge.Model.Report.WeatherReport;
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

		WeatherReport weatherReport = new WeatherReport();

		LOGGER.info("Planets orbiting around the sun");

		for (int day = 0; day < amountOfDays; day++) {
			// Gets the weather on this day and then
			// updates the report with this information.
			Weather weather = weatherCondition.get(GeometricRequest.getGeometricResult(solarSystem, day));
			weatherReport.setStrategy(weather);
			weatherReport.updateReport(day);
		}

		LOGGER.info("Persisting data to database using H2");
		weatherReport.saveInfoToDatabase();
	}

}