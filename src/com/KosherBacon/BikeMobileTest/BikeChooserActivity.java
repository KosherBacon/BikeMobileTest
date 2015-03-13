package com.KosherBacon.BikeMobileTest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import net._01001111.text.LoremIpsum;

/**
 * Created by jkahn on 3/12/15.
 */
public class BikeChooserActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bike_selector);

        final ListView bikeList = (ListView) findViewById(R.id.bikeList);

        LoremIpsum lorem = new LoremIpsum();

        Bike[] bikes = new Bike[100];
        for (int i = 0; i < 100; i++) {
            bikes[i] = new Bike();
            bikes[i].setName("Roadster");
            bikes[i].setManufacturer("Schwinn");
            bikes[i].setDescription(lorem.paragraphs(2, true));
        }
        BikeArrayAdapter bikeAdapter = new BikeArrayAdapter(getApplicationContext(), R.layout.bike_selector_row, bikes);
        bikeList.setAdapter(bikeAdapter);
        bikeList.setOnItemClickListener(bikeAdapter.bikeListClick);
    }

}
