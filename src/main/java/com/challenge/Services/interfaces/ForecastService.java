package com.challenge.Services.interfaces;


import com.challenge.Model.Report.ReportResults;
import com.challenge.Model.Entities.Forecast;
import com.challenge.Model.Response.ForecastResponse;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ForecastService {
    ForecastResponse getWeatherByDay(int day);
    void saveForecast(ReportResults reportResults);
    List<ForecastResponse> getFullReport();
}
