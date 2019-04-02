package model.railway.coaches;

import model.railway.Coach;

public class Berth extends Coach {

    public Berth() {
        super((byte)54, (byte)1, (byte)1);
    }

    @Override
    public String toString() {
        return String.format("%-5s %-11s ", "*","Berth")+super.toString();
    }
}
