package com.KosherBacon.BikeMobileTest;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jkahn on 3/12/15.
 */
public class Bike implements Parcelable {

    /*
    The specific name of the bike
     */
    private String name;

    /*
    A brief description of the bike
     */
    private String description;

    /*
    The manufacturer of the bike
     */
    private String manufacturer;

    /*
    An image to use as the icon of the bike
     */
    private Bitmap icon;

    /*
    Create a bike object with default values
     */
    public Bike() {
        this.name = "Bike";
        this.description = "Description";
        this.manufacturer = "Manufacturer";
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public Bitmap getIcon() {
        return this.icon;
    }

    /*
    Returns a boolean for whether of not it was able to update the name of the bike (empty strings are not okay)
     */
    public boolean setName(String name) {
        if (name.isEmpty()) {
            return false;
        }
        this.name = name;
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
        if (name.isEmpty()) {
            return false;
        }
        this.manufacturer = manufacturer;
        return true;
    }

    public void setIcon(Bitmap icon) {
        this.icon = icon;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.manufacturer);
        dest.writeString(this.description);
        dest.writeParcelable(this.icon, flags);
    }
}
