package com.challenge.services.interfaces;


import com.challenge.model.report.ReportResults;
import com.challenge.model.response.ForecastResponse;

import java.util.List;


public interface ForecastService {
    ForecastResponse getWeatherByDay(int day);
    void saveForecast(ReportResults reportResults);
    List<ForecastResponse> getFullReport();
}
