package com.caqtus.sunshine;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class ForecastFragment extends Fragment {

    public ForecastFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    private ArrayAdapter<String> mForecastAdapter;
    FetchWeatherTask fetchWeatherTask = new FetchWeatherTask();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_main, container, false);



        String[] forecastArray = {
                                    "Today - Sunny - 7/13",
                                    "Tomorrow - not sunny - 4/12",
                                    "Wed - cloudy - 12/2",
                                    "Dickday - dicky - db/qp"
        };


        //Creating ArrayList from String Array
        List<String> weekForecast = new ArrayList<>(Arrays.asList(forecastArray));

        //
        mForecastAdapter = new ArrayAdapter<>(getActivity(),
                R.layout.list_item_forecast,R.id.list_item_forecast_textview,weekForecast);

        ListView forecastList = (ListView) rootView.findViewById(R.id.listview_forecast);
        forecastList.setAdapter(mForecastAdapter);







        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
        inflater.inflate(R.menu.forecastfragment, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_refresh){

            fetchWeatherTask.execute("Tbilisi");


        }
        return super.onOptionsItemSelected(item);

    }
}

