package com.KosherBacon.BikeMobileTest;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

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

        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            actionBar.setTitle(this.bike.getModel() + " - $" + decimalFormat.format(this.bike.getPrice()));
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.details_actionbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish();
                return true;
            case R.id.addToCart:
                Toast.makeText(getBaseContext(), "Added item to cart!", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
