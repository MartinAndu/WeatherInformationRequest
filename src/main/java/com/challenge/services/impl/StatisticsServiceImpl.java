package com.challenge.services.impl;

import com.challenge.model.entities.Statistic;
import com.challenge.model.entities.StatisticConverter;
import com.challenge.model.report.ReportResults;
import com.challenge.model.response.StatisticResponse;
import com.challenge.repository.StatisticsRepository;
import com.challenge.services.interfaces.StatisticsService;
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
