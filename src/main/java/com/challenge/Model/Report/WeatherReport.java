package com.challenge.Model.Report;

import com.challenge.DTOs.WeatherReportDTO;
import com.challenge.Model.Enums.Weather;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class WeatherReport {

    public final Logger LOGGER = LoggerFactory.getLogger(WeatherReportStrategy.class);

    private Map<Weather, WeatherReportStrategy> strategyStrategyDictionary;

    private WeatherReportDTO weatherReportDTO;

    @Autowired
    WeatherReportStrategy weatherReportStrategy;

    public WeatherReport() {
        strategyStrategyDictionary = new HashMap<>();
        strategyStrategyDictionary.put(Weather.DROUGHNESS, new DroughtWeatherStrategy());
        strategyStrategyDictionary.put(Weather.RAIN, new RainWeatherStrategy());
        strategyStrategyDictionary.put(Weather.MAX_RAIN, new MaxRainWeatherStrategy());
        strategyStrategyDictionary.put(Weather.OPTIMAL, new OptimalWeatherStrategy());
        strategyStrategyDictionary.put(Weather.NO_INFORMATION, new RegularWeatherStrategy());

        weatherReportDTO = new WeatherReportDTO();
    }


    public void setStrategy(Weather weather) {
        this.weatherReportStrategy = strategyStrategyDictionary.get(weather);
    }

    public void updateReport(int day) {
        weatherReportDTO.setDay(day);
        weatherReportStrategy.calculateWeatherPeriod(weatherReportDTO);
        weatherReportDTO.setLastWeather(weatherReportStrategy.getType());

        LOGGER.info("Forecast System detects {} by day {}", weatherReportStrategy.getType() , weatherReportDTO.getDay());
    }

    public void saveInfoToDatabase() {
        // Saves reports on the database.
        List<Weather> forecast = weatherReportDTO.getForecast();
        Map<Weather, Integer> periodAmount = weatherReportDTO.getPeriodAmount();
//
//        IntStream.range(0, forecast.size()).forEach(
//           day -> {
//               System.out.println(forecast.get(day) + ", " + day);
//           }
//        );

        periodAmount.forEach( (key, value) -> LOGGER.info("The amount of {} is {}",key, value));
    }

}
