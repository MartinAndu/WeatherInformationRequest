package com.challenge.Model.Report;

import com.challenge.DTOs.WeatherReportDTO;
import com.challenge.Model.Enums.Weather;

public class RegularWeatherStrategy implements WeatherReportStrategy {

    @Override
    public void calculateWeatherPeriod(WeatherReportDTO weatherReportDTO) {
        weatherReportDTO.updateForecast(Weather.NO_INFORMATION);
    }

    @Override
    public Weather getType() {
        return Weather.NO_INFORMATION;
    }

    @Override
    public String getDescriptionType() {
        return Weather.NO_INFORMATION.name();
    }
}
