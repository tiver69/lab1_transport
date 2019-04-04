package model.entity.coaches;

import model.entity.Coach;

/**
 * SeatingSecond coach (сидячий второго класса)
 * With 94 places available, 2 item of baggage
 *  per person and 2 comfort star
 */
public class SeatingSecond extends Coach {
    public SeatingSecond() {
        super((byte)94, (byte)2, (byte)2);
    }

    @Override
    public String toString() {
        return String.format("%-5s %-14s ", "**","Seating Second")+super.toString();
    }
}
