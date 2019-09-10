package com.challenge.geometricTests;

import com.challenge.model.enums.Allignment;
import com.challenge.model.enums.MotionRotationalDirection;
import com.challenge.model.Planet;
import com.challenge.model.SolarSystem;
import com.challenge.helpers.GeometricRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlanetsReportingDroughtTest {

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


}
