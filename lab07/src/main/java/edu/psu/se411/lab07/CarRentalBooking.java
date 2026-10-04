package edu.psu.se411.lab07;

import java.util.Date;
import edu.psu.se411.lab07.exception.InvalidArgumentException;
import edu.psu.se411.lab07.exception.MissingInformationException;
import edu.psu.se411.lab07.util.Config;

public class CarRentalBooking extends Booking {
    private final double dailyRate;
    private Integer days;

    public CarRentalBooking(String id, String name, Date date, String dest,
                            double dailyRate, Integer days) {
        super(id, name, date, dest);
        this.dailyRate = dailyRate;
        this.days = days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    @Override
    public double calculateTotalPrice()
            throws MissingInformationException, InvalidArgumentException {
        requireProvided(days, "Number of days");
        requireInRange(days, Config.MIN_RENTAL_DAYS,
                Config.MAX_RENTAL_DAYS, "Number of days");
        return dailyRate * days;
    }
}