package com.challenge.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SolarSystem {

	private List<Planet> planets;

	@Autowired
	public SolarSystem() {
		this.planets = new ArrayList<Planet>();
	}

	public void addPlanet(Planet planet) {
		this.planets.add(planet);
	}

	public void setPlanets(List<Planet> planets) {
		this.planets = planets;
	}

	public List<Position> getPositionOnDay(int day) {
		return planets.stream().map(x -> x.getPosition(day)).collect(Collectors.toList());
	}

}