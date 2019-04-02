package model.railway.coaches;

import model.railway.Coach;

/**
 * Compartment coach (купе)
 * With 35 places available, 3 items of baggage
 *  per person and 4 comfort stars
 */
public class Compartment extends Coach {

    public Compartment() {
        super((byte)35, (byte)3, (byte)4);
    }

    @Override
    public String toString() {
        return String.format("%-5s %-11s ", "****", "Compartment")+super.toString();
    }
}
