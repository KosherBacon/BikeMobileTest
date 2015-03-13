package com.KosherBacon.BikeMobileTest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by jkahn on 3/13/15.
 */
public class BikeDetailsActivity extends Activity {

    Bike bike;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
        Read in the bike details passed by BikeChooserActivity
         */
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.bike = extras.getParcelable("bike");
        } else {
            Toast.makeText(getBaseContext(), "ERROR: Didn't receive bike details!", Toast.LENGTH_SHORT).show();
            finish();
        }

        setContentView(R.layout.bike_details);

    }

}
