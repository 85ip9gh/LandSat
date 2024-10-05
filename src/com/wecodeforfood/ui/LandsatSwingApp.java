package com.wecodeforfood.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LandsatSwingApp {
    private double latitude;
    private double longitude;
    private int cloudCoverage;
    private boolean isSubmitted = false; // Flag to indicate submission

    public LandsatSwingApp() {
        JFrame frame = new JFrame("Landsat Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new GridBagLayout());

        // Set the frame to be non-resizable
        frame.setResizable(false);

        // Create panel
        JPanel panel = new JPanel();
        panel.setBackground(new Color(173, 216, 230)); // Light blue background color
        frame.add(panel);
        placeComponents(panel);

        // Set frame visibility
        frame.setVisible(true);
        frame.setLocationRelativeTo(null); // Center the window on the screen
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Latitude label and text field
        JLabel latLabel = new JLabel("Latitude:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.5; // Scale with the window size
        panel.add(latLabel, gbc);

        JTextField latField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(latField, gbc);

        // Longitude label and text field
        JLabel longLabel = new JLabel("Longitude:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(longLabel, gbc);

        JTextField longField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(longField, gbc);

        // Cloud coverage label and text field
        JLabel cloudLabel = new JLabel("Cloud Coverage (%):");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(cloudLabel, gbc);

        JTextField cloudField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(cloudField, gbc);

        // Submit button
        JButton submitButton = new JButton("Submit and Track");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2; // Span across two columns
        panel.add(submitButton, gbc);

        // Button click event
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Parse latitude and longitude as doubles
                    latitude = Double.parseDouble(latField.getText());
                    longitude = Double.parseDouble(longField.getText());

                    // Parse cloud coverage as an integer
                    cloudCoverage = Integer.parseInt(cloudField.getText());

                    // Mark as submitted
                    isSubmitted = true;

                    // Print values
                    System.out.println("Latitude: " + latitude + ", Longitude: " + longitude + ", Cloud Coverage: " + cloudCoverage + "%");

                } catch (NumberFormatException ex) {
                    // Show error message for invalid input
                    JOptionPane.showMessageDialog(panel, "Please enter valid numerical values for Latitude, Longitude, and Cloud Coverage.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    // Method to get the submitted values
    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public int getCloudCoverage() {
        return cloudCoverage;
    }

    public boolean isSubmitted() {
        return isSubmitted;
    }
}
