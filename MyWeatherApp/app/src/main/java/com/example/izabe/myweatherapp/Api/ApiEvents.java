package com.example.izabe.myweatherapp.Api;

import com.example.izabe.myweatherapp.Enum.EApiType;
import com.example.izabe.myweatherapp.Models.Example;

/**
 * Created by izabe on 17.07.2018.
 */

public class ApiEvents {

    public ApiEvents apiEvents;
    public EApiType apiType;
    public Example weather;


    /**
     *
     * @param apiType
     * @param weather
     */
    public  ApiEvents(EApiType apiType, Example weather)
    {
        this.apiType=apiType;
        this.weather=weather;
    }







}
