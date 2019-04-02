package model.railway.coaches;

import model.railway.Coach;

public class DeLuxe extends Coach {
    public DeLuxe() {
        super((byte)20, (byte)4, (byte)5);
    }

    @Override
    public String toString() {
        return String.format("%-5s %-11s ", "*****","DeLuxe")+super.toString();
    }
}
