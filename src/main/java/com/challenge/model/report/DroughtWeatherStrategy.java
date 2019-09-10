package com.challenge.model.report;

import com.challenge.model.enums.Weather;

public class DroughtWeatherStrategy implements WeatherReportStrategy {

    @Override
    public void calculateWeatherPeriod(ReportResults reportResults) {
        if (!reportResults.getLastWeather().equals(Weather.DROUGHT)) {
            reportResults.updatePeriodAmount(Weather.DROUGHT);
        }
        reportResults.updateForecast(Weather.DROUGHT);
        reportResults.setLastWeather(Weather.DROUGHT);
    }

    @Override
    public Weather getType() {
        return Weather.DROUGHT;
    }

    @Override
    public String getDescriptionType() {
        return Weather.DROUGHT.name();
    }
}
