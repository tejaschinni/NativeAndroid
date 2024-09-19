package com.example.luckynumber;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyCustomPlanetAdapter extends ArrayAdapter<Planet> {
    private ArrayList<Planet> planetslist;
    Context context;

    public MyCustomPlanetAdapter(ArrayList<Planet> planetslist, Context context1) {
        super(context1, R.layout.items_list_planet,planetslist);
        this.planetslist = planetslist;
        this.context = context1;
    }

    private static class MyViewHolder{
        TextView planetName;
        TextView moonCount;
        ImageView image;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Planet planet = getItem(position);

        MyViewHolder viewHolder;
        final View result;

        if(convertView == null){
            viewHolder = new MyViewHolder();
            LayoutInflater inf = LayoutInflater.from(getContext());
            convertView = inf.inflate(R.layout.items_list_planet,parent,false);

            viewHolder.planetName = (TextView) convertView.findViewById(R.id.titleview);
            viewHolder.moonCount = (TextView) convertView.findViewById(R.id.subtitleview);
            viewHolder.image = (ImageView) convertView.findViewById(R.id.imageView);

            result = convertView;
            convertView.setTag(viewHolder);

        }else{
            viewHolder = (MyViewHolder) convertView.getTag();
            result = convertView;
        }

        viewHolder.planetName.setText(planet.getPlanetName());
        viewHolder.moonCount.setText(planet.getMoonCount());
        viewHolder.image.setImageResource(planet.getPlanetImage());

        return  result;
    }
}
