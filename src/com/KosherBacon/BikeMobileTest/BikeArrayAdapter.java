package com.KosherBacon.BikeMobileTest;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.text.DecimalFormat;

/**
 * Created by jkahn on 3/13/15.
 */
public class BikeArrayAdapter extends ArrayAdapter<Bike> {

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
        final BikeHolder holder;

        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new BikeHolder();
            holder.imgIcon = (ImageView) row.findViewById(R.id.bikeListIcon);
            holder.name = (TextView) row.findViewById(R.id.bikeListName);
            holder.manufacturer = (TextView) row.findViewById(R.id.bikeListManufacturer);
            holder.price = (TextView) row.findViewById(R.id.bikePrice);

            row.setTag(holder);
        } else {
            holder = (BikeHolder) row.getTag();
        }

        Bike bike = data[position];
        holder.imgIcon.setImageResource(bike.getIcon());
        holder.name.setText(bike.getModel());
        holder.manufacturer.setText(bike.getManufacturer());
        /*
        Ensure that the price can only have two decimal places
         */
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        holder.price.setText("$" + decimalFormat.format(bike.getPrice()));

        return row;
    }

    static class BikeHolder {
        ImageView imgIcon;
        TextView name;
        TextView manufacturer;
        TextView price;
    }

    public ListView.OnItemClickListener bikeListClick = new ListView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Intent intent = new Intent(context, BikeDetailsActivity.class);
            intent.putExtra("bike", data[i]);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    };

}
