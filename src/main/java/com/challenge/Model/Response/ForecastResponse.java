package com.challenge.Model.Response;

public class ForecastResponse {

    private int day;
    private String description;

    public ForecastResponse(int day, String description) {
        this.day = day;
        this.description = description;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
