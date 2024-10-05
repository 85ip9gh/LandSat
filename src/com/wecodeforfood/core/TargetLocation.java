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
    private int radius = 10;

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
}
