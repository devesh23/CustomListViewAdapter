package com.devesh.customlistviewadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


//Creating a custom adapter class for relative placement of object in listview.
public class FoodAdapter extends ArrayAdapter {

    List list=new ArrayList();
    public FoodAdapter(Context context, int resource) {
        super(context, resource);
    }
    @Override
    public void add(Object object)
    {
        super.add(object);
        list.add(object);//helps to add element to list
    }

    @Override
    public int getCount() {
        return this.list.size();//returns list size
    }

    @Override
    public Object getItem(int position) {
        return this.list.get(position);//returns list's position
    }
    //A simple class to group together different values
    static class DataHandler{
        ImageView food_poster;
        TextView  chick;
        TextView  pri;
    }
    //Overriding getview function.
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        row=convertView;
        DataHandler handler;

        if(convertView==null)
        {
            LayoutInflater inflater=(LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=inflater.inflate(R.layout.rowlayout,parent,false);
            handler=new DataHandler();
            handler.food_poster=(ImageView)row.findViewById(R.id.FoodPoster);
            handler.chick=(TextView)row.findViewById(R.id.Text_View);
            handler.pri=(TextView)row.findViewById(R.id.Text_View2);
            row.setTag(handler);
        }
        else
            handler = (DataHandler) row.getTag();
        DataProvider dataProvider;
        dataProvider=(DataProvider)this.getItem(position);
        handler.food_poster.setImageResource(dataProvider.getFood_poster_resource());
        handler.chick.setText(dataProvider.getFoodName());
        handler.pri.setText(dataProvider.getPrice());


        return row;
    }
}
