package com.challenge.Model.Report;

import com.challenge.DTOs.WeatherReportDTO;
import com.challenge.Model.Enums.Weather;

public class OptimalWeatherStrategy implements WeatherReportStrategy {
    @Override
    public void calculateWeatherPeriod(WeatherReportDTO weatherReportDTO) {
        if (!weatherReportDTO.getLastWeather().equals(Weather.OPTIMAL)) {
            weatherReportDTO.updatePeriodAmount(Weather.OPTIMAL);
        }
        weatherReportDTO.updateForecast(Weather.OPTIMAL);
    }

    @Override
    public Weather getType() {
        return Weather.OPTIMAL;
    }

    @Override
    public String getDescriptionType() {
        return Weather.OPTIMAL.name();
    }
}
