package com.KosherBacon.BikeMobileTest;

/**
 * Created by jkahn on 3/12/15.
 */
public class Bike {

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

}
