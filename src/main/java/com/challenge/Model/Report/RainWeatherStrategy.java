package com.challenge.Model.Report;

import com.challenge.Model.Enums.Weather;

public class RainWeatherStrategy implements WeatherReportStrategy {
    @Override
    public void calculateWeatherPeriod(ReportResults reportResults) {
        if (!reportResults.getLastWeather().equals(Weather.RAIN) && !reportResults.getLastWeather().equals(Weather.MAX_RAIN)) {
            reportResults.updatePeriodAmount(Weather.RAIN);
        }
        reportResults.updateForecast(Weather.RAIN);
        reportResults.setLastWeather(Weather.RAIN);
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
