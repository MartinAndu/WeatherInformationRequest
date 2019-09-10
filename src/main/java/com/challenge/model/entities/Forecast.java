package com.challenge.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "forecast")
@Entity
public class Forecast {

    @Id
    @GeneratedValue
    private int id;

    public Forecast() {}

    private int day;

    private String weather;

    public int getId() {
        return id;
    }

    public int getDay() {
        return day;
    }

    public String getWeather() {
        return weather;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }
}
