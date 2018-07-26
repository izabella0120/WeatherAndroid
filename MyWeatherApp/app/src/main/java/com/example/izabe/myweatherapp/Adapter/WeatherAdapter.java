package com.example.izabe.myweatherapp.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.izabe.myweatherapp.R;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by izabe on 10.07.2018.
 */

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.MyViewHolder> {


    List<ListItem> listItems;
    Typeface font;

    public WeatherAdapter(Context context, List<ListItem> listItems) {

        this.listItems = listItems;
        font = Typeface.createFromAsset(context.getAssets(), "weathericons-regular-webfont.ttf");

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
        DecimalFormat df2 = new DecimalFormat(".#");
        holder.mContent.setText(df2.format(listItem.getTemperature()).toString());
        holder.icon.setTypeface(font);
        holder.icon.setText(R.string.weather_sunny);

        String description=listItem.getDescription();

        if (description.equals("Clear")) {
            holder.icon.setText(R.string.weather_sunny);
        }
        if (description.equals("Clouds")) {
            holder.icon.setText(R.string.weather_cloudy);
        }
        if (description.equals("Rain")) {
            holder.icon.setText((R.string.weather_rainy));
        }
        if (description.equals("Snow")) {
            holder.icon.setText(R.string.weather_snowy);
        }
    }


    @Override
    public int getItemCount() {
        return listItems.size();
    }







    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTittle;
        public TextView mContent;
        public TextView icon;

        public MyViewHolder(View itemView) {
            super(itemView);
            icon = (TextView) itemView.findViewById(R.id.weather_icon);
            mTittle = (TextView) itemView.findViewById(R.id.city_title);
            mContent = (TextView) itemView.findViewById((R.id.current_temperature_field));

        }


    }
}





