package com.challenge.services;

import com.challenge.Model.Enums.MotionRotationalDirection;
import com.challenge.Model.Planet;
import com.challenge.Model.SolarSystem;
import com.challenge.Helpers.PlanetsAllignment;
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
public class PlanetsReportingOptimalTest {

    @Autowired
    protected SolarSystem solarSystem;

    @Before
    public void setup() {
        solarSystem.setPlanets(new ArrayList<>());
    }

    @Test
    public void PlanetsAlignedWithMajorAngleChanged() {
        solarSystem.addPlanet(new Planet("Ferengi", 500, MotionRotationalDirection.CLOCKWISE, 90.00,5.0));
        solarSystem.addPlanet(new Planet("Betasoide", 2000, MotionRotationalDirection.COUNTERCLOCKWISE, 90.00,270.0));
        solarSystem.addPlanet(new Planet("Vulcano", 1000, MotionRotationalDirection.CLOCKWISE, 90.00,5.0));

        assertTrue(PlanetsAllignment.planetAllignmentTransition(solarSystem, 2));
    }

    @Test
    public void PlanetsAlignedWithMediumAngleChanged() {
        solarSystem.addPlanet(new Planet("Ferengi", 500, MotionRotationalDirection.CLOCKWISE, 90.00,5.0));
        solarSystem.addPlanet(new Planet("Betasoide", 2000, MotionRotationalDirection.COUNTERCLOCKWISE, 90.00,180.0));
        solarSystem.addPlanet(new Planet("Vulcano", 1000, MotionRotationalDirection.CLOCKWISE, 90.00,5.0));

        assertTrue(PlanetsAllignment.planetAllignmentTransition(solarSystem, 2));
    }


    @Test
    public void PlanetsAlignedWithMinorAngleChanged() {
        solarSystem.addPlanet(new Planet("Ferengi", 500, MotionRotationalDirection.CLOCKWISE, 90.00,1.0));
        solarSystem.addPlanet(new Planet("Vulcano", 1000, MotionRotationalDirection.CLOCKWISE, 90.00,6.0));
        solarSystem.addPlanet(new Planet("Betasoide", 2000, MotionRotationalDirection.CLOCKWISE, 90.00,1.0));

        assertTrue(PlanetsAllignment.planetAllignmentTransition (solarSystem, 73));
    }

    @Test
    public void PlanetsAlignedAfterManyRevolutionsAngleChanged() {
        solarSystem.addPlanet(new Planet("Ferengi", 500, MotionRotationalDirection.CLOCKWISE, 90.00,1.0));
        solarSystem.addPlanet(new Planet("Betasoide", 2000, MotionRotationalDirection.CLOCKWISE, 90.00,3.0));
        solarSystem.addPlanet(new Planet("Vulcano", 1000, MotionRotationalDirection.COUNTERCLOCKWISE, 90.00,5.0));

        assertTrue(PlanetsAllignment.planetAllignmentTransition(solarSystem, 541));
    }


}
