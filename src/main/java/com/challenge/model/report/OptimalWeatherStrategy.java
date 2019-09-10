package com.challenge.model.report;

import com.challenge.model.enums.Weather;

public class OptimalWeatherStrategy implements WeatherReportStrategy {
    @Override
    public void calculateWeatherPeriod(ReportResults reportResults) {
        if (!reportResults.getLastWeather().equals(Weather.OPTIMAL)) {
            reportResults.updatePeriodAmount(Weather.OPTIMAL);
        }
        reportResults.updateForecast(Weather.OPTIMAL);
        reportResults.setLastWeather(Weather.OPTIMAL);
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
