package edu.psu.se411.lab07;

import java.util.Date;
import edu.psu.se411.lab07.exception.InvalidArgumentException;
import edu.psu.se411.lab07.exception.MissingInformationException;

public abstract class Booking {
    private final String bookingId;
    private final String customerName;
    private final Date travelDate;
    private final String destination;

    public Booking(String bookingId, String customerName, Date travelDate, String destination) {
        this.bookingId = bookingId;
        this.customerName = customerName;
        this.travelDate = travelDate;
        this.destination = destination;
    }

    public abstract double calculateTotalPrice()
            throws MissingInformationException, InvalidArgumentException;

    protected void requireProvided(Object value, String name) throws MissingInformationException {
        if (value == null) {
            throw new MissingInformationException(name + " is not provided");
        }
    }

    protected void requireInRange(double value, double min, double max, String name)
            throws InvalidArgumentException {
        if (value < min || value > max) {
            throw new InvalidArgumentException(
                    name + " must be between " + min + " and " + max + " but was " + value);
        }
    }

    public String getBookingId() { return bookingId; }
    public String getCustomerName() { return customerName; }
    public Date getTravelDate() { return travelDate; }
    public String getDestination() { return destination; }
}
