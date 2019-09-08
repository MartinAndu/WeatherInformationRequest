package com.challenge.Model.Report;

import com.challenge.DTOs.WeatherReportDTO;
import com.challenge.Model.Enums.Weather;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public interface WeatherReportStrategy {

    public abstract void calculateWeatherPeriod(WeatherReportDTO weatherReportDTO);

    public abstract Weather getType();

    public abstract String getDescriptionType();

}
