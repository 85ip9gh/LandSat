import com.wecodeforfood.core.Landsat;
import com.wecodeforfood.core.Location;
import com.wecodeforfood.ui.LandsatSwingApp;

public class Main {
    public static void main(String[] args) {
        LandsatSwingApp landsatApp = new LandsatSwingApp(); // Create an instance

        if (landsatApp.isSubmitted()){
            // Get submitted values
            double latitude = landsatApp.getLatitude();
            double longitude = landsatApp.getLongitude();
            int cloudCoverage = landsatApp.getCloudCoverage();

            Location location = new Location(latitude, longitude);

            // Handle the submitted values
            System.out.println("Received Values: Latitude: " + latitude + ", Longitude: " + longitude + ", Cloud Coverage: " + cloudCoverage + "%");
        }
    }
}
