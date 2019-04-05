package model.entity.coaches;

import model.entity.Coach;

/**
 * Berth coach (плацкарт)
 * With 54 places available, 1 item of baggage
 *  per person and 1 comfort star
 */
public class Berth extends Coach {

    String conductorName;

    public Berth(String conductorName) {
        super((byte)54, (byte)1, (byte)1);
        this.conductorName = conductorName;
    }

    public void setConductorName(String conductorName) {
        this.conductorName = conductorName;
    }

    public String getConductorName() {
        return conductorName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
//        if (obj == null) return false;
        if (!(obj instanceof Berth)) return false;
        if (!super.equals(obj)) return false;

        Berth otherTrain = (Berth) obj;
        return conductorName.equals(otherTrain.getConductorName());
    }

    @Override
    public String toString() {
        return String.format("%-5s %-11s ", "*","Berth")
                + super.toString() + "\n";
    }
}