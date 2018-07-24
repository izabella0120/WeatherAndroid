package com.example.izabe.myweatherapp.TaskFragments;


import com.example.izabe.myweatherapp.Api.ApiEvents;
import com.example.izabe.myweatherapp.Enum.EApiType;
import com.example.izabe.myweatherapp.Interfaces.OnWeatherInterface;
import com.example.izabe.myweatherapp.Models.Example;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by izabe on 04.07.2018.
 */

public class TaskFragmentsWeather {

    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5";
    private static final String BASE_KEY = "&appid=b642b494740b9fd2698b26f7bd2aa9d4";
    private static final String IMG_URL = "http://openweathermap.org/img/w/";

    public String  get_URL(String city){

        StringBuilder temptext=new StringBuilder();
        temptext.append("weather?q="+ city + BASE_KEY);
//        Uri.Builder my_URL = new Uri.Builder();
//        my_URL.appendPath("weather").appendQueryParameter("q",city);
        //String test = my_URL.toString();
        return temptext.toString();
    }



    public void start(final String city) {
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(600, TimeUnit.SECONDS)
                .connectTimeout(600, TimeUnit.SECONDS)
                .build();



        final Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .addConverterFactory(JacksonConverterFactory.create())
                .client(okHttpClient)
                .build();



        final OnWeatherInterface onWeatherInterface = retrofit.create(OnWeatherInterface.class);

        onWeatherInterface.loadChanges(get_URL(city)).enqueue(new Callback<Example>(){
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                if(response.body() != null){
                    Example example = new Example();
                    example = response.body();
                    EventBus.getDefault().post(new ApiEvents(EApiType.WEATHER ,response.body()));

                }



            }//odp z serwera








            @Override
            public void onFailure(Call<Example> call, Throwable t) {

            }
             });

    }
//    Retrofit retrofit = new Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create(gson))
//            .build();
}
