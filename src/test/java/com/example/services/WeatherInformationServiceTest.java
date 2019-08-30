package com.example.services;

import com.example.Model.Enums.MotionRotationalDirection;
import com.example.Model.Enums.Weather;
import com.example.Model.Planet;
import com.example.Model.SolarSystem;
import com.example.Services.WeatherInformationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherInformationServiceTest {

    @Autowired
    protected SolarSystem solarSystem;

    @Autowired
    private WeatherInformationService weatherInformationService;


    @Before
    public void setup() {
        solarSystem.addPlanet(new Planet("Pluton", 5000, MotionRotationalDirection.CLOCKWISE, 90,1));
        solarSystem.addPlanet(new Planet("Betasoide", 2000, MotionRotationalDirection.CLOCKWISE, 90,3));
        solarSystem.addPlanet(new Planet("Vulcano", 1000, MotionRotationalDirection.COUNTERCLOCKWISE, 90,1));

        weatherInformationService = new WeatherInformationService(solarSystem.getPlanets());
    }


    @Test
    public void PlanetsAllignedTest() {
        assertEquals(weatherInformationService.getWeatherOnDay(0), Weather.OPTIMAL);
    }

}
