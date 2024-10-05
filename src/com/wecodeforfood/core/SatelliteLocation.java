package com.wecodeforfood.core;

import com.wecodeforfood.util.Vector;

/**
 * The {@code SatelliteLocation} class represents a geographic location defined
 * by its latitude and longitude coordinates and it's velocity.
 *
 * @author WeCodeForFood (Mac)
 * @since   1.0
 */
public class SatelliteLocation {
    // Instance Variables
    private final double latitude;
    private final double  longitude;
    private Vector velocity;

    // CONSTRUCTORS
    public SatelliteLocation(double latitude, double longitude){
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

    public Vector getVelocity() {
        return velocity;
    }
}
