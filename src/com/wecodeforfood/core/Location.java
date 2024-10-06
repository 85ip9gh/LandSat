package com.wecodeforfood.core;

/**
 * The {@code Location} class represents a geographic location defined
 * by its latitude and longitude coordinates
 *
 * @author WeCodeForFood (Mac)
 * @since   1.0
 */
public class Location {
    //Instance variables
    private final double latitude;
    private final double longitude;

    // CONSTRUCTORS
    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Location(double latitude, double longitude, int radius) {
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
