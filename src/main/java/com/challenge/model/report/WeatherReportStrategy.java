package com.challenge.model.report;

import com.challenge.model.enums.Weather;


public interface WeatherReportStrategy {

    public abstract void calculateWeatherPeriod(ReportResults reportResults);

    public abstract Weather getType();

    public abstract String getDescriptionType();

}
