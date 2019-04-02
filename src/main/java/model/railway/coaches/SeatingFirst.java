package model.railway.coaches;

import model.railway.Coach;

/**
 * SeatingFirst coach (сидячий первого класса)
 * With 64 places available, 3 item of baggage
 *  per person and 3 comfort star
 */
public class SeatingFirst extends Coach {

    public SeatingFirst() {
        super((byte)64, (byte)3, (byte)3);
    }

    @Override
    public String toString() {
        return String.format("%-5s %-14s ", "***","Seating First")+super.toString();
    }
}
