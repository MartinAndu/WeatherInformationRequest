package com.challenge.services;

import com.challenge.Model.Enums.Allignment;
import com.challenge.Model.Enums.MotionRotationalDirection;
import com.challenge.Model.Planet;
import com.challenge.Model.SolarSystem;
import com.challenge.Services.GeometricRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlanetsTriangleTest {

    @Autowired
    protected SolarSystem solarSystem;

    @Before
    public void setup() {
        solarSystem.setPlanets(new ArrayList<>());
        solarSystem.addPlanet(new Planet("Ferengi", 500, MotionRotationalDirection.CLOCKWISE, 90.00,1.0));
        solarSystem.addPlanet(new Planet("Betasoide", 2000, MotionRotationalDirection.CLOCKWISE, 90.00,3.0));
        solarSystem.addPlanet(new Planet("Vulcano", 1000, MotionRotationalDirection.COUNTERCLOCKWISE, 90.00,5.0));
    }

    @Test
    public void PlanetsAllignedWithTestNormalRain() {
        assertEquals(Allignment.PLANETS_FORMING_TRIANGLE_WITH_SUN, GeometricRequest.getGeometricResult(solarSystem, 3580));
    }

    @Test
    public void PlanetsAllignedWithTest() {
        assertEquals(Allignment.PLANETS_FORMING_TRIANGLE_WITH_SUN_MAX_PERIMETER, GeometricRequest.getGeometricResult(solarSystem, 3577));
    }

    @Test
    public void PlanetsAllignedWithMaxPerimeterTest() {
        assertEquals(Allignment.PLANETS_FORMING_TRIANGLE_WITH_SUN_MAX_PERIMETER, GeometricRequest.getGeometricResult(solarSystem, 2992));
    }
}
