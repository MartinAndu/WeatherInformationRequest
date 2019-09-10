package com.challenge.forecastRunner;

import com.challenge.model.enums.MotionRotationalDirection;
import com.challenge.model.Planet;
import com.challenge.model.SolarSystem;
import com.challenge.services.WeatherInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ApplicationRunner {

    @Value("${forecast.amount.days}")
    private Integer AMOUNT_OF_DAYS;


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
