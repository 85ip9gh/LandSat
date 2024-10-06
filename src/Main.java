import com.wecodeforfood.core.Landsat;
import com.wecodeforfood.core.Location;
import com.wecodeforfood.ui.LandsatSwingApp;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LandsatSwingApp landsatApp = new LandsatSwingApp(); // Create an instance

            // Create a SwingWorker to wait for form submission
            SwingWorker<Void, Void> worker = new SwingWorker<>() {
                @Override
                protected Void doInBackground() throws Exception {
                    // Wait until the form is submitted
                    while (!landsatApp.isSubmitted()) {
                        Thread.sleep(100); // Check every 100ms
                    }
                    return null;
                }

                @Override
                protected void done() {
                    // Get submitted values
                    double latitude = landsatApp.getLatitude();
                    double longitude = landsatApp.getLongitude();
                    int cloudCoverage = landsatApp.getCloudCoverage();
                    String phoneNumber = landsatApp.getPhoneNumber();

                    Location location = new Location(latitude, longitude);

                    // Handle the submitted values
                    System.out.println("Received Values: Latitude: " + latitude + ", Longitude: " + longitude + ", Cloud Coverage: " + cloudCoverage + "%" + ", Phone Number: " + phoneNumber);
                }
            };

            worker.execute(); // Start the SwingWorker
        });
    }
}