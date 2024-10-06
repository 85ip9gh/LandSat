package com.wecodeforfood.util;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * The {@code SatelliteTracker} class provides a method to retrieve
 * Two-Line Element (TLE) data for a given satellite using the NORAD ID.
 * This class uses the N2YO API to fetch TLE data via HTTP requests.
 *
 * <p>The class has a single public static method
 * {@link #getData(int, double, double, double, int)} that takes
 * a NORAD ID as a parameter, makes an HTTP GET request to the N2YO API, and
 * returns the TLE data as a JSON string.
 *
 * @author WeCodeForFood (Mac)
 * @since   1.0
 */
public class SatelliteTracker {
    private static final String API_KEY = "API_KEY";
    private static final String BASE_URL = "https://api.n2yo.com/rest/v1/satellite/positions/";

    public static String getData(int noradId, double observerLat,
                                 double observerLng, double observerAlt, int seconds) {
        try {
            String urlString = BASE_URL + noradId + "/" + observerLat + "/" + observerLng + "/" + observerAlt + "/" + seconds + "/&apiKey=" + API_KEY;
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlString))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();

        } catch (Exception e) {
            System.out.println(e + e.getMessage());
        }
        return null;
    }
}
