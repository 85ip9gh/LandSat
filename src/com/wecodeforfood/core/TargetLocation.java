package com.wecodeforfood.core;

/**
 * The {@code TargetLocation} class represents a geographic location defined
 * by its latitude, longitude and also has a radius (15 km).
 *
 * @author WeCodeForFood (Mac)
 * @since   1.0
 */
public class TargetLocation {
    //Instance variables
    private final double latitude;
    private final double longitude;
    private int radius = 15;

    // CONSTRUCTORS
    public TargetLocation(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public TargetLocation(double latitude, double longitude, int radius) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
    }

    // GETTERS AND SETTERS
    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    /**
     * Checks if a given location is within this target location's radius.
     *
     * @param location The location to check.
     * @return {@code true} if the location is within the radius, {@code false}
     * otherwise.
     */
    public boolean isWithinRadius(SatelliteLocation location) {
        // Use haversine formula or simple approximation to calculate the distance
        // between this target location and the other location, and check if
        // it's within the radius.
        double distance = getDistanceTo(location);
        return distance <= this.radius;
    }

    /**
     * Calculates the distance between this target location and another location.
     *
     * @param location The other location to calculate the distance to.
     * @return The distance in kilometers.
     */
    public double getDistanceTo(SatelliteLocation location) {
        // Calculate the distance using the haversine formula
        double dLat = Math.toRadians(location.getLatitude() - latitude);
        double dLon = Math.toRadians(location.getLongitude() - longitude);

        double lat1 = Math.toRadians(this.latitude);
        double lat2 = Math.toRadians(location.getLatitude());

        double a = Math.pow(Math.sin(dLat / 2), 2)
                        + Math.cos(lat1)
                        * Math.cos(lat2)
                        * Math.pow(Math.sin(dLon / 2), 2);
        double rad = 6371; // Earth's radius in kilometers
        double c = 2 * Math.asin(Math.sqrt(a));

        return rad * c;
    }

    // GETTERS
    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
