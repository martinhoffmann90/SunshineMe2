package com.example.android.sunshine.app;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        ArrayAdapter<String> mForecastAdapter;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);


            ArrayList fakeData = new ArrayList<String>();
            fakeData.add("Montag - Sonne - 6 / 18");
            fakeData.add("Dienstag - Nebel - 4 / 12");
            fakeData.add("Mittwoch - Wolken - 4 / 9");
            fakeData.add("Donnerstag - Regen - 0 / 4");
            fakeData.add("Freitag - Sonne - 2 / 6");
            fakeData.add("Samstag - Schnee - -4 / 0");
            fakeData.add("Sonntag - Sturm - 5 / 12");

            //Array Adapter erstellen
             mForecastAdapter = new ArrayAdapter<String>(
                     getActivity(),                         //Current Context
                     R.layout.list_item_forecast,           // Layout ID
                     R.id.list_item_forecast_textview,      // ID of Textview to populate
                     fakeData);                             // Data

            ListView listView = (ListView) rootView.findViewById(R.id.listview_forecast);
            listView.setAdapter(mForecastAdapter);

            return rootView;
        }
    }
}
