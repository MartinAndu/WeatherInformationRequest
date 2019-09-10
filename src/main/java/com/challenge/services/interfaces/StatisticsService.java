package com.challenge.services.interfaces;


import com.challenge.model.report.ReportResults;
import com.challenge.model.response.StatisticResponse;


public interface StatisticsService {
    StatisticResponse getStatistics();
    void saveStatistics(ReportResults reportResults);
}
