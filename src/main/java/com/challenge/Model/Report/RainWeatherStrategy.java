package com.challenge.Model.Report;

import com.challenge.DTOs.WeatherReportDTO;
import com.challenge.Model.Enums.Weather;

public class RainWeatherStrategy implements WeatherReportStrategy {
    @Override
    public void calculateWeatherPeriod(WeatherReportDTO weatherReportDTO) {
        if (!weatherReportDTO.getLastWeather().equals(Weather.RAIN) && !weatherReportDTO.getLastWeather().equals(Weather.MAX_RAIN)) {
            weatherReportDTO.updatePeriodAmount(Weather.RAIN);
        }
        weatherReportDTO.updateForecast(Weather.RAIN);

    }

    @Override
    public Weather getType() {
        return Weather.RAIN;
    }

    @Override
    public String getDescriptionType() {
        return Weather.RAIN.name();
    }
}
