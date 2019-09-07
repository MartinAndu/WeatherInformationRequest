package com.challenge.GeometricTests;

import com.challenge.Model.Enums.Allignment;
import com.challenge.Model.Enums.MotionRotationalDirection;
import com.challenge.Model.Enums.Weather;
import com.challenge.Model.Planet;
import com.challenge.Model.Position;
import com.challenge.Model.SolarSystem;
import com.challenge.Services.Evaluator.GeometricEvaluator;
import com.challenge.Services.Evaluator.LineEvaluator;
import com.challenge.Services.GeometricRequest;
import com.challenge.Services.PlanetsAllignment;
import com.challenge.Services.WeatherInformationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlanetsAllignmentTest {

    @Autowired
    protected SolarSystem solarSystem;

    @Before
    public void setup() {
        solarSystem.setPlanets(new ArrayList<>());
        solarSystem.addPlanet(new Planet("Ferengi", 500, MotionRotationalDirection.CLOCKWISE, 90.00,1.0));
        solarSystem.addPlanet(new Planet("Betasoide", 2000, MotionRotationalDirection.CLOCKWISE, 90.00,1.0));
        solarSystem.addPlanet(new Planet("Vulcano", 1000, MotionRotationalDirection.COUNTERCLOCKWISE, 90.00,1.0));
    }

    @Test
    public void PlanetsAlignedInitialTest() {
        assertEquals(Allignment.PLANETS_ALLIGNED_WITH_SUN, GeometricRequest.getGeometricResult(solarSystem, 0));
    }

    @Test
    public void PlanetsAlignedTestIntersectionExcludingSun() {
        assertEquals(Allignment.PLANETS_ALLIGNED_WITH_SUN, GeometricRequest.getGeometricResult(solarSystem, 180));
    }

//    @Test
//    public void PlanetsAlignedWithoutSunClockwiseTest() {
//        solarSystem.setPlanets(new ArrayList<>());
//        solarSystem.addPlanet(new Planet("Ferengi", 500, MotionRotationalDirection.CLOCKWISE, 90.00,1.0));
//        solarSystem.addPlanet(new Planet("Betasoide", 2000, MotionRotationalDirection.CLOCKWISE, 90.00,3.0));
//        solarSystem.addPlanet(new Planet("Vulcano", 1000, MotionRotationalDirection.COUNTERCLOCKWISE, 90.00,5.0));
//
//        assertEquals(Allignment.PLANETS_ALLIGNED, GeometricRequest.getGeometricResult(solarSystem, 117));
//    }

    @Test
    public void PlanetsAlignedWithoutSunCounterClockwiseTest() {
        solarSystem.setPlanets(new ArrayList<>());
        solarSystem.addPlanet(new Planet("Ferengi", 500, MotionRotationalDirection.CLOCKWISE, 90.00,270.0));
        solarSystem.addPlanet(new Planet("Vulcano", 1000, MotionRotationalDirection.COUNTERCLOCKWISE, 90.00,5.0));
        solarSystem.addPlanet(new Planet("Betasoide", 2000, MotionRotationalDirection.CLOCKWISE, 90.00,270.0));

        assertEquals(Allignment.PLANETS_ALLIGNED, GeometricRequest.getGeometricResult(solarSystem, 2));
    }


}
