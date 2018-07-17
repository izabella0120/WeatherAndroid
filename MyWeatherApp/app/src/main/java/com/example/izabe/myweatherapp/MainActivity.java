package com.example.izabe.myweatherapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;

import com.example.izabe.myweatherapp.Adapter.ListItem;
import com.example.izabe.myweatherapp.Adapter.WeatherAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText wpisz_miasto;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private List<ListItem> listItems;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        wpisz_miasto = (EditText) findViewById(R.id.wpisz_miasto);
        wpisz_miasto.getText();

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems = new ArrayList<>();

        for(int i =0; i<=10; i++){
            ListItem listItem = new ListItem(

            );

            listItems.add(listItem);
        }

        adapter = new WeatherAdapter(listItems, this);

        recyclerView.setAdapter(adapter);

    }
}
