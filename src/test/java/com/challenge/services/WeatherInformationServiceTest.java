package com.challenge.services;

import com.challenge.Model.Enums.Allignment;
import com.challenge.Model.Enums.MotionRotationalDirection;
import com.challenge.Model.Enums.Weather;
import com.challenge.Model.Planet;
import com.challenge.Model.SolarSystem;
import com.challenge.Services.GeometricRequest;
import com.challenge.Services.WeatherInformationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherInformationServiceTest {

    @Autowired
    protected SolarSystem solarSystem;

    @Before
    public void setup() {
        solarSystem.addPlanet(new Planet("Ferengi", 500, MotionRotationalDirection.CLOCKWISE, 90,1));
        solarSystem.addPlanet(new Planet("Betasoide", 2000, MotionRotationalDirection.CLOCKWISE, 90,3));
        solarSystem.addPlanet(new Planet("Vulcano", 1000, MotionRotationalDirection.COUNTERCLOCKWISE, 90,5));
    }

    @Test
    public void PlanetsAllignedWithTest() {
        assertEquals(GeometricRequest.getGeometricResult(solarSystem.getPlanets(), 0), Allignment.PLANETS_ALLIGNED_WITH_SUN);
    }

    @Test
    public void PlanetsAllignedWithoutSunTest() {
        assertEquals(GeometricRequest.getGeometricResult(solarSystem.getPlanets(), 17), Allignment.PLANETS_ALLIGNED);
    }

    @Test
    public void PlanetsAllignedTestIntersectionExcludingSun() {
        assertEquals(GeometricRequest.getGeometricResult(solarSystem.getPlanets(), 180), Weather.DROUGHNESS);
    }


}
