package com.example.izabe.myweatherapp.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.izabe.myweatherapp.R;

import java.util.List;

/**
 * Created by izabe on 10.07.2018.
 */

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.MyViewHolder>{
    EditText wpisz_miasto;
    TextView article_tittle;


    List<ListItem> listItems;
    private Context context;

    public WeatherAdapter(List<ListItem> listItems) {
        this.listItems = listItems;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.article_layout, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        ListItem listItem = listItems.get(position);

        holder.mTittle.setText(listItem.getCity_name());
        holder.mContent.setText(listItem.getTemperature());

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView mTittle;
        public TextView mContent;
        public MyViewHolder(View itemView){
            super(itemView);
            wpisz_miasto.getText();
            mTittle = (TextView) itemView.findViewById(R.id.city_title);
            mContent = (TextView) itemView.findViewById((R.id.current_temperature_field));

        }


    }



}
