package com.challenge.services.impl;

import com.challenge.exceptions.Messages;
import com.challenge.exceptions.types.DayNumberException;
import com.challenge.exceptions.validators.DayValidator;
import com.challenge.model.report.ReportResults;
import com.challenge.model.entities.ForecastConverter;
import com.challenge.model.response.ForecastResponse;
import com.challenge.repository.ForecastRepository;
import com.challenge.services.interfaces.ForecastService;
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
