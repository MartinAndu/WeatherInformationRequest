package com.challenge.Model.Report;

import com.challenge.Model.Enums.Weather;
import com.challenge.Services.interfaces.ForecastService;
import com.challenge.Services.interfaces.StatisticsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class WeatherReport {

    public final Logger LOGGER = LoggerFactory.getLogger(WeatherReportStrategy.class);

    private Map<Weather, WeatherReportStrategy> strategyStrategyDictionary;

    private ReportResults reportResults;

    private WeatherReportStrategy weatherReportStrategy;

    @Autowired
    private ForecastService foreCastService;

    @Autowired
    private StatisticsService statisticsService;


    public WeatherReport() {
        strategyStrategyDictionary = new HashMap<>();
        strategyStrategyDictionary.put(Weather.DROUGHNESS, new DroughtWeatherStrategy());
        strategyStrategyDictionary.put(Weather.RAIN, new RainWeatherStrategy());
        strategyStrategyDictionary.put(Weather.MAX_RAIN, new MaxRainWeatherStrategy());
        strategyStrategyDictionary.put(Weather.OPTIMAL, new OptimalWeatherStrategy());
        strategyStrategyDictionary.put(Weather.NO_INFORMATION, new RegularWeatherStrategy());

        reportResults = new ReportResults();
    }


    public void setStrategy(Weather weather) {
        this.weatherReportStrategy = strategyStrategyDictionary.get(weather);
    }

    public void updateReport(int day) {
        reportResults.setDay(day);
        weatherReportStrategy.calculateWeatherPeriod(reportResults);
        saveWeather();
        LOGGER.info("Forecast System detects {} by day {}", reportResults.getLastWeather() , reportResults.getDay());
    }

    private void saveWeather() {
        foreCastService.saveForecast(reportResults);
    }

    public void saveInfoToDatabase() {
        Map<Weather, Integer> periodAmount = reportResults.getPeriodAmount();
        periodAmount.forEach( (key, value) -> LOGGER.info("The amount of period of {} is {}",key, value));

        LOGGER.info("Days with max rain are {}", reportResults.getMaxRainDays());

        // Saves reports on the database.
        statisticsService.saveStatistics(reportResults);
    }

}
