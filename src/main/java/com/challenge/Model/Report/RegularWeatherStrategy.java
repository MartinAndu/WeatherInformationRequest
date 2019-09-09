package com.challenge.Model.Report;

import com.challenge.Model.Enums.Weather;

public class RegularWeatherStrategy implements WeatherReportStrategy {

    @Override
    public void calculateWeatherPeriod(ReportResults reportResults) {
        // When no information about the weather is shown, the planets
        // keeps their previous weather until a new one comes up.
        reportResults.updateForecast(reportResults.getLastWeather());
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
