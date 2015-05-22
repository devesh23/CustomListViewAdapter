package com.devesh.customlistviewadapter;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity {

    ListView listView;
    // Array variable for Food items, their description and their rates.
    int[] Food_Posters={R.drawable.chicken_gravy,R.drawable.chicken_gravy,
            R.drawable.chicken_gravy,R.drawable.chicken_gravy,
            R.drawable.chicken_gravy,R.drawable.chicken_gravy,
            R.drawable.chicken_gravy,R.drawable.chicken_gravy
    };
    String[] Foodnames;
    String[] FoodPrice;
    FoodAdapter adapter;//Custom Adapter to help with relative layout. It helps in uploading data.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.List_View);
        Foodnames=getResources().getStringArray(R.array.FoodItems);
        FoodPrice=getResources().getStringArray(R.array.Rates);
        adapter=new FoodAdapter(getApplicationContext(),R.layout.rowlayout);//"RowLayout is the custom layout created. It is defined as Relative layout.
        //Helps with multiple things in app and their placing
        listView.setAdapter(adapter);//setting adapter of class foodadapter to listview to help with adding data.
        int i=0;
        for (String titles:Foodnames)   {
            DataProvider dataProvider=new DataProvider(Food_Posters[i],titles,FoodPrice[i]);//Data Provider is a class which provides data to listview.
            adapter.add(dataProvider);
            i++;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
