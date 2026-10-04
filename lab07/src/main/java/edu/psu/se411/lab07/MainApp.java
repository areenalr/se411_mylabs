package edu.psu.se411.lab07;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.psu.se411.lab07.exception.InvalidArgumentException;
import edu.psu.se411.lab07.exception.MissingInformationException;
import edu.psu.se411.lab07.util.SeatClass;

public class MainApp {
    static Logger logger = LoggerFactory.getLogger(MainApp.class);

    public static double computeTotalPrice(Booking booking)
            throws MissingInformationException, InvalidArgumentException {
        return booking.calculateTotalPrice();
    }

    private static void run(Booking booking) {
        try {
            System.out.println(booking.getBookingId() + " Total Price: " + computeTotalPrice(booking));
            logger.info("Booking {} priced successfully", booking.getBookingId());
        } catch (MissingInformationException | InvalidArgumentException e) {
            System.out.println(booking.getBookingId() + " Error: " + e.getMessage());
            logger.error("Booking " + booking.getBookingId() + " failed", e);
        }
    }

    public static void main(String[] args) {
        logger.info("Application is starting...");

        // Valid bookings (from the lab)
        run(new FlightBooking("B001", "John Doe", new Date(), "New York", 200.0, 30.0, 20.0));
        run(new CarRentalBooking("B002", "Jane Smith", new Date(), "Los Angeles", 50.0, 10));
        run(new TrainBooking("B003", "Alice Johnson", new Date(), "Chicago", SeatClass.STANDARD_CLASS, 100.0));

        // Exception tests
        run(new FlightBooking("B004", "Sam Lee", new Date(), "Paris", 200.0, 30.0));
        run(new FlightBooking("B005", "Sam Lee", new Date(), "Paris", 200.0, 30.0, 55.0));
        run(new TrainBooking("B006", "Ann Roe", new Date(), "Rome", SeatClass.FIRST_CLASS, 3000.0));
        run(new CarRentalBooking("B007", "Bob Ray", new Date(), "Dubai", 50.0, 0));

        logger.info("Application is stopping...");
    }
}
