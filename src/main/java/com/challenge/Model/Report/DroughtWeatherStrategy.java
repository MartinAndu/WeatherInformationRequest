package com.challenge.Model.Report;

import com.challenge.Model.Enums.Weather;

public class DroughtWeatherStrategy implements WeatherReportStrategy {

    @Override
    public void calculateWeatherPeriod(ReportResults reportResults) {
        if (!reportResults.getLastWeather().equals(Weather.DROUGHNESS)) {
            reportResults.updatePeriodAmount(Weather.DROUGHNESS);
        }
        reportResults.updateForecast(Weather.DROUGHNESS);
        reportResults.setLastWeather(Weather.DROUGHNESS);
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
