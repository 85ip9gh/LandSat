package com.wecodeforfood.util;

/**
 * The {@code Trackable} interface allows a class to be tracked and to update
 * its coordinates using the {@code track} method.
 *
 * <p>Classes that implement this interface can provide specific
 * implementations for tracking their own coordinates, which will be used to
 * track and update the location of the LANDSAT satellite.
 * </p>
 *
 * @author WeCodeForFood (Mac)
 * @since 1.0
 */
public interface Trackable {

    // Implement code to track and update the location of an object
    public void track();
}
