package com.challenge.Services.interfaces;


import com.challenge.Model.Report.ReportResults;
import com.challenge.Model.Response.StatisticResponse;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


public interface StatisticsService {
    StatisticResponse getStatistics();
    void saveStatistics(ReportResults reportResults);
}
