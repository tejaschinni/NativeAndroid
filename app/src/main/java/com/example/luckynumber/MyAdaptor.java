package com.example.luckynumber;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdaptor extends BaseAdapter {

    private Context context;
    private  String[] items;

    public MyAdaptor(Context context,String[] items) {
        this.items = items;
        this.context = context;
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int position) {
        return items[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView ==  null){
            // ConverView is a recycle view that you can reuse to improve performace of your list
        convertView = LayoutInflater.from(context).inflate(R.layout.my_list_view,parent,false);
        holder = new ViewHolder();
        holder.textView = convertView.findViewById(R.id.textView2);
        convertView.setTag(holder);
        }else{
            //reusing
            holder = (ViewHolder) convertView.getTag();

        }

        holder.textView.setText(items[position]);

        return convertView;
    }

    static class ViewHolder{
        TextView textView;
    }
}
