package com.challenge.model.report;

import com.challenge.model.enums.Weather;

import java.util.*;

public class ReportResults {

    private Weather lastWeather;

    private Map<Weather, Integer> periodAmount;

    private List<Integer> maxRainDays;

    private List<Weather> forecast;

    private int day;

    public ReportResults() {
        this.periodAmount = new HashMap<>();
        this.maxRainDays = new ArrayList<>();
        this.forecast = new ArrayList<>();

        // The last weather as soon as the application is up and running , should be a regular weather.
        this.lastWeather = Weather.NO_INFORMATION;
    }

    public List<Integer> getMaxRainDays() {
        return maxRainDays;
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

    public void updateMaxRainDay() {
        this.maxRainDays.add(this.day);
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
