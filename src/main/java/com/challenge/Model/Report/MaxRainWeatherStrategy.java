package com.challenge.Model.Report;

import com.challenge.DTOs.WeatherReportDTO;
import com.challenge.Model.Enums.Weather;

public class MaxRainWeatherStrategy implements WeatherReportStrategy {

    @Override
    public void calculateWeatherPeriod(WeatherReportDTO weatherReportDTO) {
        weatherReportDTO.updatePeriodAmount(Weather.MAX_RAIN);
        weatherReportDTO.updateForecast(Weather.MAX_RAIN);
    }

    @Override
    public Weather getType() {
        return Weather.MAX_RAIN;
    }

    @Override
    public String getDescriptionType() {
        return Weather.MAX_RAIN.name();
    }
}
