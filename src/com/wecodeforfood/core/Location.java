package com.wecodeforfood.core;

/**
 * The {@code Location} class represents a geographic location defined
 * by its latitude and longitude coordinates.
 *
 * <p>This class provides getter methods to access the latitude and longitude
 * values of a location. The latitude and longitude values are stored as
 * immutable instance variables, meaning they cannot be modified after
 * the object is created.</p>
 *
 *
 * @author WeCodeForFood (Mac)
 * @since   1.0
 */
public class Location {

    // Instance Variables
    private final double latitude;
    private final double  longitude;

    // CONSTRUCTORS
    public Location(double latitude, double longitude){
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // GETTERS
    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
