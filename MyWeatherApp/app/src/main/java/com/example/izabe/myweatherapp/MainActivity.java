package com.example.izabe.myweatherapp;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.izabe.myweatherapp.Adapter.ListItem;
import com.example.izabe.myweatherapp.Adapter.WeatherAdapter;
import com.example.izabe.myweatherapp.Api.ApiEvents;
import com.example.izabe.myweatherapp.Enum.EApiType;
import com.example.izabe.myweatherapp.Fragments.WeatherFragment;
import com.example.izabe.myweatherapp.Models.Example;
import com.example.izabe.myweatherapp.TaskFragments.TaskFragmentsWeather;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public MainActivity() {
    }

    public String city_name;
    public String temperature;


    Typeface weatherFont;

    Button button;
    EditText wpisz_miasto;
    TextView city_title;
    TextView current_temperature_field;
    TextView weather_icon;
    LinearLayout list_item;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    TaskFragmentsWeather taskFragmentsWeather;
    private List<ListItem> listItems;

    public MainActivity(String city_name, String temperature) {
        this.city_name = city_name;
        this.temperature = temperature;
    }


    public String getTemperature() {

        return temperature;
    }

//    public void text_m(View view){
//        city_title.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View v){
//                Main2Activity main2Activity = new Main2Activity(MainActivity.this, .class )
//            }
//
//        });
//
//    }


    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        wpisz_miasto = (EditText) findViewById(R.id.wpisz_miasto);
        city_name=wpisz_miasto.getText().toString();
        city_title = (TextView) findViewById(R.id.city_title);
        current_temperature_field = (TextView) findViewById(R.id.current_temperature_field);
        weather_icon = (TextView) findViewById(R.id.weather_icon) ;
        list_item = (LinearLayout) findViewById(R.id.list_item) ;

        //weather_icon.setTypeface(weatherFont);
        listItems = new ArrayList<>();

        adapter=new WeatherAdapter(getApplicationContext(),listItems);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        //dodac recyclerView.divider

        WeatherFragment weatherFragment = new WeatherFragment();









        //loadRecyclerViewData();


        EventBus.getDefault().register(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(taskFragmentsWeather!=null)
                    taskFragmentsWeather.start(wpisz_miasto.getText().toString());
                else
                {
                    taskFragmentsWeather=new TaskFragmentsWeather();
                    taskFragmentsWeather.start(wpisz_miasto.getText().toString());
                }
                wpisz_miasto.setText("");



            }
        });



        if(findViewById(R.id.list_item) != null){
            if(savedInstanceState != null){
                return;
            }

            WeatherFragment weatherFragment1 = new WeatherFragment();
            weatherFragment1.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,weatherFragment1).commit();
        }









}

    public void onClickItem(View view){



    }



    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onApiEvents(ApiEvents apiEvents) {
        if( apiEvents.apiType == EApiType.WEATHER){

            Example apiType = apiEvents.weather;

            String nameOfTheCity=apiEvents.weather.getName();
            Double temperatureInKelvins=apiEvents.weather.getMain().getTemp();
            KalvinsToCel(temperatureInKelvins);
            String description = apiEvents.weather.getWeather().get(0).getMain();



            ListItem weather = new ListItem(nameOfTheCity, KalvinsToCel(temperatureInKelvins), description);
            listItems.add(weather);
            adapter=new WeatherAdapter(getApplicationContext(),listItems);
            recyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();




        }
    }



    public double KalvinsToCel(double inKelvins){

        double tempInCelsius=inKelvins-273;
        return tempInCelsius;

    }

//    public void changeFragment(){
//        getFragmentManager().beginTransaction().replace(R.id.list_item, new WeatherFragment().addToBackStack(null).commit();
//    }







    }

