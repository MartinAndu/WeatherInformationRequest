package com.challenge.forecastRunner;

import com.challenge.Model.Enums.MotionRotationalDirection;
import com.challenge.Model.Planet;
import com.challenge.Model.SolarSystem;
import com.challenge.Services.WeatherInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Component
public class ApplicationRunner {

    final private static Integer AMOUNT_OF_DAYS = 360000;


    private WeatherInformationService weatherInformationService;

    @Autowired
    private SolarSystem solarSystem;

    @Autowired
    ApplicationRunner(WeatherInformationService weatherInformationService) {
        this.weatherInformationService = weatherInformationService;
    }

    @PostConstruct
    private void init() {
        solarSystem.addPlanet(new Planet("Ferengi", 500, MotionRotationalDirection.CLOCKWISE, 90.00,1.0));
        solarSystem.addPlanet(new Planet("Betasoide", 2000, MotionRotationalDirection.CLOCKWISE, 90.00,3.0));
        solarSystem.addPlanet(new Planet("Vulcano", 1000, MotionRotationalDirection.COUNTERCLOCKWISE, 90.00,5.0));

        weatherInformationService.orbitAroundTheSun(solarSystem, AMOUNT_OF_DAYS);
    }
}
