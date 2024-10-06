package com.wecodeforfood.core;

import com.wecodeforfood.util.SatelliteTracker;

/**
 * The {@code Landsat} class is a utility class designed to assist with tracking
 * the LANDSAT satellite and fetching data about its position.
 *
 * <p> This class provides methods to calculate the time until the satellite
 * reaches a specified target location, display relevant data, and send
 * notifications when the satellite is near a target location.
 * </p>
 *
 * <p>This class is primarily a helper and cannot be instantiated. Instead, it
 * provides static methods for users to interact with the LANDSAT satellite.
 * </p>
 *
 * @author WeCodeForFood
 * @since   1.0
 */
public class Landsat {
    private static final int NORAD_ID = 49260;

    // Private constructor to prevent instantiation
    private Landsat() {}

    /**
     * Displays a 3x3 grid of data related to the satellite’s current position,
     * taking into account factors like cloud coverage.
     */
    public static void displayData() {
    }

    /**
     * Sends a notification when the satellite is within a specified range
     * of the target location.
     */
    public static void sendNotification() {
    }

    /**
     * Fetches the current position data for the LANDSAT satellite using the
     * specified target location as a reference.
     *
     * <p>This method utilizes the {@link SatelliteTracker} class to retrieve
     * the satellite's data from the N2YO API. It updates the internal state
     * based on the latest tracking information.
     * </p>
     *
     * @param targetLocation The reference location for fetching satellite data.
     */
    public static void fetchSatelliteData(Location targetLocation) {
        String response = SatelliteTracker.getData(
                NORAD_ID,
                targetLocation.getLatitude(),
                targetLocation.getLongitude(),
                0,
                2
        );
        //Parse Data
    }
}
