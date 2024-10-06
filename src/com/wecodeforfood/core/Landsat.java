package com.wecodeforfood.core;

import com.wecodeforfood.util.SatelliteTracker;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

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
     *This method utilizes the {@link SatelliteTracker} class to retrieve
     * the satellite's data from the N2YO API. It updates the internal state
     * based on the latest tracking information.
     *
     * @param targetLocation The reference location for fetching satellite data.
     * @author Bhabin Chudal, Sushmita Oli
     */
    public static Object[] fetchSatelliteData(Location targetLocation) {
        String response = SatelliteTracker.getData(
                NORAD_ID,
                targetLocation.getLatitude(),
                targetLocation.getLongitude(),
                0,
                2
        );
        String[] responseArray = response.split(",");

        double satLattitude = Double.parseDouble(responseArray[11].split(":")[1]);
        double satLongitude = Double.parseDouble(responseArray[12].split(":")[1]);
        String unixtimeStamp = responseArray[18].split(":")[1].split("}")[0].trim();

        Long longUnixTimeStamp = Long.parseLong(unixtimeStamp);
        String stringUTCTime =  Landsat.convertUnixToUTC(longUnixTimeStamp);

        return new Object[]{satLattitude, satLongitude, stringUTCTime};
    }

    /**
     * Converts the given Unix timestamp, typically used in Landsat data, to a formatted UTC date-time string.
     *
     * This method takes a Unix timestamp as input, converts it to an `Instant` object, and then formats
     * it to a string representing the corresponding date and time in UTC.
     *
     * @param unixTimestamp the Unix timestamp to be converted, representing the number of seconds.
     * @return a `String` representing the date and time in UTC format.
     * @author Bhabin Chudal, Sushmita Oli
     */
    private static String convertUnixToUTC(long unixTimestamp) {
            // Create an Instant from the Unix timestamp
            Instant instant = Instant.ofEpochSecond(unixTimestamp);

            // Format the Instant to a UTC string
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                    .withZone(ZoneOffset.UTC);
            return formatter.format(instant);
        }

}
