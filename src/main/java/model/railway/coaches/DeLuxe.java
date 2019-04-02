package model.railway.coaches;

import model.railway.Coach;

/**
 * DeLuxe coach (Люкс)
 * With 20 places available, 4 item of baggage
 *  per person and 5 comfort star
 */
public class DeLuxe extends Coach {
    public DeLuxe() {
        super((byte)20, (byte)4, (byte)5);
    }

    @Override
    public String toString() {
        return String.format("%-5s %-11s ", "*****","DeLuxe")+super.toString();
    }
}
