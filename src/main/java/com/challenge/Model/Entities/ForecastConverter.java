package com.challenge.Model.Entities;

import com.challenge.Model.Report.ReportResults;
import com.challenge.Model.Response.ForecastResponse;

public class ForecastConverter {

    public static Forecast dtoToEntity(ReportResults reportResults) {
        Forecast forecast = new Forecast();
        forecast.setDay(reportResults.getDay());
        forecast.setWeather(reportResults.getLastWeather().name());
        return forecast;
    }

    public static ForecastResponse entityToResponse(Forecast forecast) {
        ForecastResponse forecastResponse = new ForecastResponse(forecast.getDay(), forecast.getWeather());
        return forecastResponse;
    }

}
