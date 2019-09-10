package com.challenge.Services.impl;

import com.challenge.Exceptions.Messages;
import com.challenge.Exceptions.types.DayNumberException;
import com.challenge.Exceptions.validators.DayValidator;
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
    public ForecastResponse getWeatherByDay(int day) {
        if (!DayValidator.ValidateDay(day)) throw new DayNumberException(Messages.DAY_NUMBER_EXCEPTION);
        return  ForecastConverter.entityToResponse(forecastRepository.findByDay(day));
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
