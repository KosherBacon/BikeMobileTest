package com.KosherBacon.BikeMobileTest;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jkahn on 3/12/15.
 */
public class Bike implements Parcelable {

    /*
    The specific name of the bike
     */
    private String model;

    /*
    A brief description of the bike
     */
    private String description;

    /*
    The manufacturer of the bike
     */
    private String manufacturer;

    /*
    The price of the individual bike
     */
    private double price;

    /*
    An image to use as the icon of the bike
     */
    private int icon;

    /*
    Create a bike object with default values
     */
    public Bike() {
        this.model = "Bike";
        this.description = "Description";
        this.manufacturer = "Manufacturer";
        this.price = 0D;
    }

    public Bike(Parcel in) {
        readFromParcel(in);
    }

    public String getModel() {
        return this.model;
    }

    public String getDescription() {
        return this.description;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public int getIcon() {
        return this.icon;
    }

    public double getPrice() {
        return this.price;
    }

    /*
    Returns a boolean for whether of not it was able to update the name of the bike (empty strings are not okay)
     */
    public boolean setModel(String model) {
        if (model.isEmpty()) {
            return false;
        }
        this.model = model;
        return true;
    }

    /*
    Returns a boolean for whether of not it was able to update the description of the bike (empty strings are not okay)
    */
    public boolean setDescription(String description) {
        if (description.isEmpty()) {
            return false;
        }
        this.description = description;
        return true;
    }

    public boolean setManufacturer(String manufacturer) {
        if (manufacturer.isEmpty()) {
            return false;
        }
        this.manufacturer = manufacturer;
        return true;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    /*
    Checks to make sure that the price is a positive number
     */
    public boolean setPrice(double price) {
        /*
        Usually not suggested to use this kind of operator on a double, but I'm only checking for zero-ness
         */
        if (price <= 0D) {
            return false;
        }
        this.price = price;
        return true;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.model);
        dest.writeString(this.manufacturer);
        dest.writeString(this.description);
        dest.writeInt(this.icon);
    }

    private void readFromParcel(Parcel in) {
        this.model = in.readString();
        this.manufacturer = in.readString();
        this.description = in.readString();
        this.icon = in.readInt();
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Bike createFromParcel(Parcel in) {
            return new Bike(in);
        }

        public Bike[] newArray(int size) {
            return new Bike[size];
        }
    };

}
