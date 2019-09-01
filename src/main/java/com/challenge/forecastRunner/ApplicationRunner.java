package com.challenge.forecastRunner;

import com.challenge.Services.WeatherInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ApplicationRunner {

    final private static int AMOUNT_OF_DAYS = 360000;


    private WeatherInformationService weatherInformationService;

    @Autowired
    ApplicationRunner(WeatherInformationService weatherInformationService) {
        this.weatherInformationService = weatherInformationService;
    }

    @PostConstruct
    private void init() {
//        weatherInformationService.orbitAroundTheSun(AMOUNT_OF_DAYS);
    }
}
