package edu.psu.se411.lab07;

import java.util.Date;
import edu.psu.se411.lab07.exception.InvalidArgumentException;
import edu.psu.se411.lab07.exception.MissingInformationException;
import edu.psu.se411.lab07.util.Config;
import edu.psu.se411.lab07.util.SeatClass;

public class TrainBooking extends Booking {
    private final SeatClass seatClass;
    private Double distance;

    public TrainBooking(String id, String name, Date date, String dest,
                        SeatClass seatClass, Double distance) {
        super(id, name, date, dest);
        this.seatClass = seatClass;
        this.distance = distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    @Override
    public double calculateTotalPrice()
            throws MissingInformationException, InvalidArgumentException {
        requireProvided(distance, "Distance");
        requireInRange(distance, Config.MIN_TRAIN_DISTANCE,
                Config.MAX_TRAIN_DISTANCE, "Distance");
        double rate = (seatClass == SeatClass.FIRST_CLASS)
                ? Config.TRAIN_FIRST_CLASS_RATE : Config.TRAIN_STANDARD_RATE;
        return distance * rate;
    }
}
