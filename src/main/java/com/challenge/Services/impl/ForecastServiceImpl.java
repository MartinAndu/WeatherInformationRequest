package com.challenge.Services.impl;

import com.challenge.Model.Report.ReportResults;
import com.challenge.Model.Entities.Forecast;
import com.challenge.Model.Entities.ForecastConverter;
import com.challenge.Model.Response.ForecastResponse;
import com.challenge.Repository.ForecastRepository;
import com.challenge.Services.interfaces.ForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ForecastServiceImpl implements ForecastService {

    @Autowired
    private ForecastRepository forecastRepository;

    @Override
    public Forecast getWeatherByDay(int day) {
        return forecastRepository.findByDay(day);
    }

    @Override
    public void saveForecast(ReportResults reportResults) {
        forecastRepository.save(ForecastConverter.dtoToEntity(reportResults));
    }

    @Override
    public List<ForecastResponse> getFullReport() {
        return forecastRepository.findAll().stream().map(ForecastConverter::entityToResponse).collect(Collectors.toList());
    }
}
