package com.example.izabe.myweatherapp.Details;

import com.example.izabe.myweatherapp.Api.ApiEvents;
import com.example.izabe.myweatherapp.Enum.EApiType;

/**
 * Created by izabe on 17.07.2018.
 */

public class WeatherDetails {

    public ApiEvents apiEvents;
    public EApiType apiType;

    public EApiType getApiType() {
        return apiType;
    }
}
