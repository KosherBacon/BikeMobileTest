package com.KosherBacon.BikeMobileTest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
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

        TextView model = (TextView) findViewById(R.id.model);
        TextView manufacturer = (TextView) findViewById(R.id.manufacturer);
        TextView description = (TextView) findViewById(R.id.description);

        ImageView icon = (ImageView) findViewById(R.id.iconView);

        model.setText(this.bike.getModel());
        manufacturer.setText(this.bike.getManufacturer());
        description.setText(this.bike.getDescription());

        icon.setImageResource(this.bike.getIcon());

    }

}
