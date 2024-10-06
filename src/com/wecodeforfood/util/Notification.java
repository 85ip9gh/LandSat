package com.wecodeforfood.util;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import java.lang.reflect.InaccessibleObjectException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * The Notification class provides methods to send SMS notifications using the Twilio API.
 * It offers functionality for sending immediate messages as well as scheduling messages for
 * future delivery.
 *
 * <p>
 * Example usage:
 * <pre>
 *     Notification.sendMessage("Hello World!", "+1234567890");
 *     Notification.sendMessage("Scheduled Message", "+1234567890", 5000); // Sends after 5 seconds
 * </pre>
 * </p>
 *
 * @author Aarav Sen Mehta, Mac
 * @version     1.0
 */
public class Notification {

    // Private constructor to prevent instantiation
    private Notification() {}

    /**
     * Sends an SMS message immediately.
     *
     * @param body The body of the SMS message to be sent.
     * @param phoneNum The recipient's phone number in E.164 format.
     * @throws IllegalArgumentException if the phone number is invalid.
     */
    public static void sendMessage(String body, String phoneNum) {
        try {
            // Create and send the message
            Message message = Message.creator(
                            new com.twilio.type.PhoneNumber(phoneNum),
                            new com.twilio.type.PhoneNumber("+15208580295"),
                            body)
                    .create();
            // Print the message body to the console
            System.out.println(message.getBody());
        } catch (InaccessibleObjectException e) {
            // Handle exception and print a message to the console
            System.out.println("Message sent to " + phoneNum);
        }
    }

    /**
     * Schedules an SMS message to be sent after a specified timeout.
     *
     * @param body The body of the SMS message to be sent.
     * @param phoneNum The recipient's phone number in E.164 format.
     * @param timeOut The delay in milliseconds before the message is sent.
     * @throws IllegalArgumentException if the phone number is invalid or timeout is negative.
     */
    public static void sendMessage(String body, String phoneNum, long timeOut) {
        // Create a scheduled executor service
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        // Schedule the task to send notification after the specified timeout
        scheduler.schedule(() -> {
            sendMessage(body, phoneNum);
        }, timeOut, TimeUnit.MILLISECONDS);

        // Shutdown the scheduler
        scheduler.shutdown();
    }
}



