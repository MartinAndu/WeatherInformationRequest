package com.challenge.Services.interfaces;

import com.challenge.Model.Entities.Forecast;
import com.challenge.Model.Response.ForecastResponse;
import com.challenge.Model.Report.ReportResults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StatisticsService {

}

@Service
public interface ForecastService {
    Forecast getWeatherByDay(int day);
    void saveForecast(ReportResults reportResults);
    List<ForecastResponse> getFullReport();
}
