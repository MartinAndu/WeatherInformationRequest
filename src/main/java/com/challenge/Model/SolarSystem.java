package com.challenge.Model;

import com.challenge.Services.WeatherInformationService;
import com.challenge.Model.Enums.Weather;
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

	public void setPlanets(List<Planet> planets) {
		this.planets = planets;
	}

	public List<Planet> getPlanets() {
		return this.planets;
	}

}