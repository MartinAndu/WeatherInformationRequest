package com.challenge.Model.Report;

import com.challenge.Model.Enums.Weather;


public interface WeatherReportStrategy {

    public abstract void calculateWeatherPeriod(ReportResults reportResults);

    public abstract Weather getType();

    public abstract String getDescriptionType();

}
