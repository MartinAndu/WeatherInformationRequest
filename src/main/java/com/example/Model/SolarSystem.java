package com.example.Model;

import com.example.Model.Enums.Weather;
import com.example.Services.WeatherInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SolarSystem {

	private List<Planet> planets;

	@Autowired
	public SolarSystem(List<Planet> planets) {
		this.planets = planets;
	}

	public void addPlanet(Planet planet) {
		this.planets.add(planet);
	}

	public List<Planet> getPlanets() {
		return this.planets;
	}

	public Weather getWeatherOnDay(int day) {
		WeatherInformationService weather = new WeatherInformationService(planets);

		return weather.getWeatherOnDay(day);
	}
}