package com.example.izabe.myweatherapp.Interfaces;

import com.example.izabe.myweatherapp.Models.Example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by izabe on 04.07.2018.
 */

public interface OnWeatherInterface {
//    @GET("data/2.5/{city}")
//    Call<Example> loadChanges(@Url("city") String city);

    @GET
    Call<Example> loadChanges(@Url String city);
}
