package com.KosherBacon.BikeMobileTest;

import android.app.Activity;
import android.graphics.BitmapFactory;
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

        Bike[] bikes = new Bike[20];
        for (int i = 0; i < 20; i++) {
            bikes[i] = new Bike();
            bikes[i].setModel("Roadster");
            bikes[i].setManufacturer("Schwinn");
            bikes[i].setDescription(lorem.paragraphs((int) (Math.random() * 3 + 1), true));
            bikes[i].setIcon(R.drawable.bike);
            bikes[i].setPrice(Math.random() * 1000);
        }
        BikeArrayAdapter bikeAdapter = new BikeArrayAdapter(getApplicationContext(), R.layout.bike_selector_row, bikes);
        bikeList.setAdapter(bikeAdapter);
        bikeList.setOnItemClickListener(bikeAdapter.bikeListClick);
    }

}
