package com.challenge.Services.interfaces;

import com.challenge.Model.Entities.Forecast;
import com.challenge.Model.Entities.Statistic;
import com.challenge.Model.Response.ForecastResponse;
import com.challenge.Model.Report.ReportResults;
import com.challenge.Model.Response.StatisticResponse;
import org.springframework.stereotype.Service;


@Service
public interface StatisticsService {
    StatisticResponse getStatistics();
    void saveStatistics(ReportResults reportResults);
}
