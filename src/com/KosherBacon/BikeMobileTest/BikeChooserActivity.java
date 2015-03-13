package com.KosherBacon.BikeMobileTest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;

/**
 * Created by jkahn on 3/12/15.
 */
public class BikeChooserActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bike_selector);

        final ListView bikeList = (ListView) findViewById(R.id.bikeList);

        Bike[] bikes = new Bike[100];
        for (int i = 0; i < 100; i++) {
            bikes[i] = new Bike();
            bikes[i].setName("Roadster");
            bikes[i].setManufacturer("Schwinn");
        }
        BikeArrayAdapter bikeAdapter = new BikeArrayAdapter(getApplicationContext(), R.layout.bike_selector_row, bikes);
        bikeList.setAdapter(bikeAdapter);
        bikeList.setOnItemClickListener(bikeAdapter.bikeListClick);
    }

}
