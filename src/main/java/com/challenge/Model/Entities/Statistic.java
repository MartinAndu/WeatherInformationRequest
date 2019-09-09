package com.challenge.Model.Entities;

import com.challenge.Model.Enums.Weather;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Table(name = "statistic")
@Entity
public class Statistic {

    @Id
    @GeneratedValue
    private int id;
    
    @ElementCollection
    private List<Integer> maxRainDays;

    @ElementCollection
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
