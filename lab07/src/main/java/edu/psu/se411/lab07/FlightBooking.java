package edu.psu.se411.lab07;

import java.util.Date;
import edu.psu.se411.lab07.exception.InvalidArgumentException;
import edu.psu.se411.lab07.exception.MissingInformationException;
import edu.psu.se411.lab07.util.Config;

public class FlightBooking extends Booking {
    private final double basePrice;
    private final double includedLuggageWeight;
    private Double luggageWeight;

    public FlightBooking(String id, String name, Date date, String dest,
                         double basePrice, double includedLuggageWeight, Double luggageWeight) {
        super(id, name, date, dest);
        this.basePrice = basePrice;
        this.includedLuggageWeight = includedLuggageWeight;
        this.luggageWeight = luggageWeight;
    }

    public FlightBooking(String id, String name, Date date, String dest,
                         double basePrice, double includedLuggageWeight) {
        this(id, name, date, dest, basePrice, includedLuggageWeight, null);
    }

    public void setLuggageWeight(Double luggageWeight) {
        this.luggageWeight = luggageWeight;
    }

    @Override
    public double calculateTotalPrice()
            throws MissingInformationException, InvalidArgumentException {
        requireProvided(luggageWeight, "Luggage weight");
        requireInRange(luggageWeight, Config.MIN_LUGGAGE_WEIGHT,
                Config.MAX_LUGGAGE_WEIGHT, "Luggage weight");
        double extraWeight = Math.max(0, luggageWeight - includedLuggageWeight);
        return (basePrice + extraWeight * Config.EXTRA_LUGGAGE_RATE) * (1 + Config.TAX_RATE);
    }
}
