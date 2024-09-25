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

public class MyCustomAdapterGrid extends ArrayAdapter<GridShape> {

    private ArrayList<GridShape> shapeArrayList;
    Context context;

    public MyCustomAdapterGrid(ArrayList<GridShape> shapeArrayList, Context context) {
        super(context, R.layout.grid_items_layout,shapeArrayList);
        this.shapeArrayList = shapeArrayList;
        this.context = context;
    }

    //view holder
    private static class MyViewHolderGrid{
        TextView shapeName;
        ImageView shapeImage;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
      GridShape shape = getItem(position);
      MyViewHolderGrid myViewHolderGrid;
      if(convertView == null){
          myViewHolderGrid = new MyViewHolderGrid();
          LayoutInflater inflater = LayoutInflater.from(getContext());

          convertView = inflater.inflate(R.layout.grid_items_layout,parent,false);

          myViewHolderGrid.shapeName = (TextView) convertView.findViewById(R.id.gridItmeText);
          myViewHolderGrid.shapeImage = (ImageView) convertView.findViewById(R.id.griditemImage);

          convertView.setTag(myViewHolderGrid);

      }else{
          myViewHolderGrid = (MyViewHolderGrid) convertView.getTag();
      }
      myViewHolderGrid.shapeImage.setImageResource(shape.getShapeImage());
      myViewHolderGrid.shapeName.setText(shape.getShapeName());

      return  convertView;
    }
}
