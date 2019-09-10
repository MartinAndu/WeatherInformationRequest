package com.challenge.model.response;

import com.challenge.model.enums.Weather;

import java.util.List;
import java.util.Map;

public class StatisticResponse {

    private List<Integer> maxRainDays;

    private Map<Weather, Integer> periodAmount;

    public List<Integer> getMaxRainDays() {
        return maxRainDays;
    }

    public void setMaxRainDays(List<Integer> maxRainDays) {
        this.maxRainDays = maxRainDays;
    }

    public Map<Weather, Integer> getPeriodAmount() {
        return periodAmount;
    }

    public void setPeriodAmount(Map<Weather, Integer> periodAmount) {
        this.periodAmount = periodAmount;
    }
}
