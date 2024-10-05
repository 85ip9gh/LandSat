package com.wecodeforfood.core;

/**
 * The {@code TargetLocation} class represents a geographic location defined
 * by its latitude, longitude and also has a radius (10 km)
 *
 * <p>This class extends the {@link Location} class, adding the ability
 * to define a search area around the specified location using a radius.
 *</p>
 *
 * @author WeCodeForFood (Mac)
 * @since   1.0
 *
 * @see com.wecodeforfood.core.Location
 */
public class TargetLocation extends Location{
    private int radius = 15;

    // CONSTRUCTORS
    public TargetLocation(double latitude, double longitude) {
        super(latitude, longitude);
    }

    public TargetLocation(double latitude, double longitude, int radius) {
        super(latitude, longitude);
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
    public boolean isWithinRadius(Location location) {
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
    public double getDistanceTo(Location location) {
        // Calculate the distance using the haversine formula or a similar approach.
        double dLat = Math.toRadians(location.getLatitude() - this.getLatitude());
        double dLon = Math.toRadians(location.getLongitude() - this.getLongitude());

        double lat1 = Math.toRadians(this.getLatitude());
        double lat2 = Math.toRadians(location.getLatitude());

        double a = Math.pow(Math.sin(dLat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dLon / 2), 2);
        double rad = 6371; // Earth's radius in kilometers
        double c = 2 * Math.asin(Math.sqrt(a));

        return rad * c;
    }
}
