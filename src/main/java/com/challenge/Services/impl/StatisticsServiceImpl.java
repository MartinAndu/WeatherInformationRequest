package com.challenge.Services.impl;

import com.challenge.Model.Entities.ForecastConverter;
import com.challenge.Model.Entities.Statistic;
import com.challenge.Model.Entities.StatisticConverter;
import com.challenge.Model.Report.ReportResults;
import com.challenge.Model.Response.StatisticResponse;
import com.challenge.Repository.StatisticsRepository;
import com.challenge.Services.interfaces.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    private StatisticsRepository statisticsRepository;

    @Override
    public StatisticResponse getStatistics() {
        Statistic statisticEntity = statisticsRepository.findTopByOrderByIdDesc();
        StatisticResponse statisticResponse = new StatisticResponse();
        statisticResponse.setPeriodAmount(statisticEntity.getPeriodAmount());
        statisticResponse.setMaxRainDays(statisticEntity.getMaxRainDays());
        return statisticResponse;
    }

    @Override
    public void saveStatistics(ReportResults reportResults) {
        statisticsRepository.save(StatisticConverter.dtoToEntity(reportResults));
    }
}
