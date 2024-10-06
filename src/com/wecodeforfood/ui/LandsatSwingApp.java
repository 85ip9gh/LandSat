package com.wecodeforfood.ui;

import com.formdev.flatlaf.FlatDarculaLaf;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The {@code LandsatSwingApp} class is a simple Swing application that allows
 * users to input latitude, longitude, cloud coverage, and phone number to track
 * the LANDSAT satellite.
 *
 * <p> This class provides a simple GUI interface for users to input the required
 * information and submit the data for tracking the satellite.
 * </p>
 *
 * <p> The application is designed to be run as a standalone application and
 * provides a simple form for users to input the required data.
 * </p>
 *
 * <p> The application uses input validation to ensure that the latitude,
 * longitude, cloud coverage, and phone number are in the correct format.
 * </p>
 *
 * @author WeCodeForFood (Pesanth Janaseth Rangaswamy Anitha)
 * @since   1.0
 */
public class LandsatSwingApp {
    private double latitude;
    private double longitude;
    private int cloudCoverage;
    private String phoneNumber;
    private boolean isSubmitted = false; // Flag to indicate submission

    public LandsatSwingApp() {
        // Set FlatLaf Look and Feel
        try {
            UIManager.setLookAndFeel(new FlatDarculaLaf());
            // Optionally set the system properties if needed
            // UIManager.put("Button.defaultButtonFollowsFocus", Boolean.TRUE);
        } catch (Exception e) {
            e.printStackTrace(); // Print any exception that occurs
        }

        JFrame frame = new JFrame("Landsat Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);
        frame.setLayout(new GridBagLayout());

        // Set the frame to be non-resizable
        frame.setResizable(false);

        // Create panel with padding/margin around the content
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2)); // Padding around the panel
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
        gbc.insets = new Insets(5, 0, 5, 0); // Add padding between components

        // Latitude label and text field
        JLabel latLabel = new JLabel("Latitude:");
        latLabel.setFont(new Font("Arial", Font.BOLD, 12));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.5; // Scale with the window size
        panel.add(latLabel, gbc);

        JTextField latField = new JTextField(20);
        latField.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                JTextField textField = (JTextField) input;
                String text = textField.getText();
                boolean isValid = text.matches("^-?([1-8]?[0-9](\\.\\d+)?|90(\\.0+)?)$"); // Verify that the input is a valid latitude
                if (!isValid) {
                    JOptionPane.showMessageDialog(panel, "Please enter a valid latitude.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
                return isValid;
            }
        });
        gbc.gridx = 1;
        panel.add(latField, gbc);

        // Longitude label and text field
        JLabel longLabel = new JLabel("Longitude:");
        longLabel.setFont(new Font("Arial", Font.BOLD, 12));
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(longLabel, gbc);

        JTextField longField = new JTextField(20);
        longField.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                JTextField textField = (JTextField) input;
                String text = textField.getText();
                boolean isValid = text.matches("^-?([1-8]?[0-9](\\.\\d+)?|90(\\.0+)?)$"); // Verify that the input is a valid latitude
                if (!isValid) {
                    JOptionPane.showMessageDialog(panel, "Please enter a valid longitude.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
                return isValid;
            }
        });
        gbc.gridx = 1;
        panel.add(longField, gbc);

        // Cloud coverage label and text field
        JLabel cloudLabel = new JLabel("Cloud Coverage (%):");
        cloudLabel.setFont(new Font("Arial", Font.BOLD, 12));
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(cloudLabel, gbc);

        JTextField cloudField = new JTextField(20);
        cloudField.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                JTextField textField = (JTextField) input;
                String text = textField.getText();
                boolean isValid = text.matches("\\d{1,2}"); // Verify that the input is a valid latitude
                if (!isValid) {
                    JOptionPane.showMessageDialog(panel, "Please enter a valid cloud coverage value.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
                return isValid;
            }
        });
        gbc.gridx = 1;
        panel.add(cloudField, gbc);

        // Phone Number label and text field
        JLabel phoneLabel = new JLabel("Phone Number:");
        phoneLabel.setFont(new Font("Arial", Font.BOLD, 12));
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(phoneLabel, gbc);

        JTextField phoneInput = new JTextField(20);
        phoneInput.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                JTextField textField = (JTextField) input;
                String text = textField.getText();
                boolean isValid = text.matches("^\\d{10}$"); // Verify that the input is a valid latitude
                if (!isValid) {
                    JOptionPane.showMessageDialog(panel, "Please enter a valid phone number.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
                return isValid;
            }
        });
        gbc.gridx = 1;
        panel.add(phoneInput, gbc);

        // Submit button with bottom margin
        JButton submitButton = new JButton("Submit and Track");
        submitButton.setPreferredSize(new Dimension(200, 40));
        gbc.gridx = 0;
        gbc.gridy = 4;
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

                    phoneNumber = phoneInput.getText();

                    latField.setText("");
                    longField.setText("");
                    cloudField.setText("");
                    phoneInput.setText("");

                    JOptionPane.showMessageDialog(panel, "Thank you for submitting", "Submission Successful", JOptionPane.INFORMATION_MESSAGE);

                    // Mark as submitted
                    isSubmitted = true;
                } catch (NumberFormatException ex) {
                    // Show error message for invalid input
                    JOptionPane.showMessageDialog(panel, "Please enter valid numerical values for Latitude, Longitude, Cloud Coverage, and Phone Number.", "Input Error", JOptionPane.ERROR_MESSAGE);
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean isSubmitted() {
        return isSubmitted;
    }

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> new LandsatSwingApp());
//    }
}
