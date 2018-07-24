package com.example.izabe.myweatherapp.Adapter;

/**
 * Created by izabe on 12.07.2018.
 */

public class ListItem {

    private String city_name;
    private Double temperature;

    public ListItem(String city_name, Double temperature) {
        this.city_name = city_name;
        this.temperature = temperature;
    }

    public String getCity_name() {
        return city_name;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }
}
