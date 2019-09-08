package com.challenge.DTOs;

import com.challenge.Model.Enums.Weather;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeatherReportDTO {

    private Weather lastWeather;

    private Map<Weather, Integer> periodAmount;

    private List<Weather> forecast;


    private int day;

    public WeatherReportDTO() {
        this.periodAmount = new HashMap<>();
        // Initializes periodAmount dictionary by setting each key with a zero value.
        periodAmount.put(Weather.DROUGHNESS, 0);

        this.forecast = new ArrayList<>();

        // The last weather as soon as the application is up and running , should be a regular weather.
        this.lastWeather = Weather.NO_INFORMATION;
    }

    public void setLastWeather(Weather lastWeather) {
        this.lastWeather = lastWeather;
    }

    public Weather getLastWeather() {
        return lastWeather;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getDay() {
        return day;
    }

    public void updatePeriodAmount(Weather weather) {
        this.periodAmount.merge(weather,1, Integer::sum);
    }

    public void updateForecast(Weather weather) {
        // Adds a new weather. The day can be retrieved
        // using forecast indexes
        forecast.add(weather);
    }

    public Map<Weather, Integer> getPeriodAmount() {
        return periodAmount;
    }

    public List<Weather> getForecast() {
        return forecast;
    }
}
