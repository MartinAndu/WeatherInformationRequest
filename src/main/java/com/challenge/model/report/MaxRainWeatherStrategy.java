package com.challenge.model.report;

import com.challenge.model.enums.Weather;

public class MaxRainWeatherStrategy implements WeatherReportStrategy {

    @Override
    public void calculateWeatherPeriod(ReportResults reportResults) {
        reportResults.updateMaxRainDay();
        reportResults.updateForecast(Weather.MAX_RAIN);
        reportResults.setLastWeather(Weather.MAX_RAIN);
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
