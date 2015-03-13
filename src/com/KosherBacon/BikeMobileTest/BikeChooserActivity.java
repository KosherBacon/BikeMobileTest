package com.KosherBacon.BikeMobileTest;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

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
    }

    private class BikeArrayAdapter extends ArrayAdapter<Bike> {

        Context context;
        int layoutResourceId;
        Bike[] data;

        public BikeArrayAdapter(Context context, int layoutResourceId, Bike[] data) {
            super(context, layoutResourceId, data);
            this.context = context;
            this.layoutResourceId = layoutResourceId;
            this.data = data;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            BikeHolder holder;

            if (row == null) {
                LayoutInflater inflater = ((Activity) context).getLayoutInflater();
                row = inflater.inflate(layoutResourceId, parent, false);

                holder = new BikeHolder();
                holder.imgIcon = (ImageView)row.findViewById(R.id.bikeListIcon);
                holder.name = (TextView)row.findViewById(R.id.bikeListName);
                holder.manufacturer = (TextView)row.findViewById(R.id.bikeListManufacturer);

                row.setTag(holder);
            } else {
                holder = (BikeHolder) row.getTag();
            }

            Bike bike = data[position];
            holder.imgIcon.setImageBitmap(bike.getIcon());
            holder.name.setText(bike.getName());
            holder.manufacturer.setText(bike.getManufacturer());

            return row;
        }

        class BikeHolder {
            ImageView imgIcon;
            TextView name;
            TextView manufacturer;
        }

    }

}
