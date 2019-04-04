package model.entity.coaches;

import model.entity.Coach;

/**
 * Berth coach (плацкарт)
 * With 54 places available, 1 item of baggage
 *  per person and 1 comfort star
 */
public class Berth extends Coach {

    public Berth() {
        super((byte)54, (byte)1, (byte)1);
    }

    @Override
    public String toString() {
        return String.format("%-5s %-11s ", "*","Berth")+super.toString();
    }
}
