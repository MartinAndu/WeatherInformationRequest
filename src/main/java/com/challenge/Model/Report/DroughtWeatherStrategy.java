package com.challenge.Model.Report;

import com.challenge.DTOs.WeatherReportDTO;
import com.challenge.Model.Enums.Weather;

public class DroughtWeatherStrategy implements WeatherReportStrategy {

    @Override
    public void calculateWeatherPeriod(WeatherReportDTO weatherReportDTO) {
        if (!weatherReportDTO.getLastWeather().equals(Weather.DROUGHNESS)) {
            weatherReportDTO.updatePeriodAmount(Weather.DROUGHNESS);
        }
        weatherReportDTO.updateForecast(Weather.DROUGHNESS);
    }

    @Override
    public Weather getType() {
        return Weather.DROUGHNESS;
    }

    @Override
    public String getDescriptionType() {
        return Weather.DROUGHNESS.name();
    }
}
