package com.challenge.services;

import com.challenge.exceptions.types.PlanetsOutOfBoundsException;
import com.challenge.helpers.GeometricRequest;
import com.challenge.model.consts.Consts;
import com.challenge.model.enums.Weather;
import com.challenge.model.enums.Allignment;
import com.challenge.model.report.WeatherReport;
import com.challenge.model.SolarSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

@Service
public class WeatherInformationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(WeatherInformationService.class);

	private final Map<Allignment, Weather> weatherCondition;

	@Autowired
	private WeatherReport weatherReport;


	public WeatherInformationService() {
		this.weatherCondition = new HashMap<>();
		weatherCondition.put(Allignment.NO_ALLIGNMENT, Weather.NO_INFORMATION);
		weatherCondition.put(Allignment.PLANETS_ALLIGNED, Weather.OPTIMAL);
		weatherCondition.put(Allignment.PLANETS_ALLIGNED_WITH_SUN, Weather.DROUGHT);
		weatherCondition.put(Allignment.PLANETS_FORMING_TRIANGLE_WITH_SUN, Weather.RAIN);
		weatherCondition.put(Allignment.PLANETS_FORMING_TRIANGLE_WITH_SUN_MAX_PERIMETER, Weather.MAX_RAIN);
	}

	public void orbitAroundTheSun(SolarSystem solarSystem, int amountOfDays) {
		LOGGER.info("Planets orbiting around the sun");

		try {
			for (int day = 0; day < amountOfDays; day++) {
				// Gets the weather on this day and then
				// updates the report with this information.
				Weather weather = weatherCondition.get(GeometricRequest.getGeometricResult(solarSystem, day));
				weatherReport.setStrategy(weather);
				weatherReport.updateReport(day);
			}

			LOGGER.info("Persisting data to database using H2");
			weatherReport.saveInfoToDatabase();


		} catch (PlanetsOutOfBoundsException planetsException) {
			LOGGER.error("Error getting weather condition: {}" , planetsException.getMessage());
		}
	}

}