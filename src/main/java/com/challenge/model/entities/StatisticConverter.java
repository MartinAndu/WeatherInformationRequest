package com.challenge.model.entities;

import com.challenge.model.report.ReportResults;

public class StatisticConverter {

    public static Statistic dtoToEntity(ReportResults reportResults) {
        Statistic statistic = new Statistic();
        statistic.setPeriodAmount(reportResults.getPeriodAmount());
        statistic.setMaxRainDays(reportResults.getMaxRainDays());

        return statistic;
    }
}
