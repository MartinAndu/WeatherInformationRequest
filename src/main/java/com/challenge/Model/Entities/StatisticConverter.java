package com.challenge.Model.Entities;

import com.challenge.Model.Report.ReportResults;
import com.challenge.Model.Response.ForecastResponse;

public class StatisticConverter {

    public static Statistic dtoToEntity(ReportResults reportResults) {
        Statistic statistic = new Statistic();
        statistic.setPeriodAmount(reportResults.getPeriodAmount());
        statistic.setMaxRainDays(reportResults.getMaxRainDays());

        return statistic;
    }
}
