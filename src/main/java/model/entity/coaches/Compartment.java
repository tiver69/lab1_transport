package model.entity.coaches;

import model.entity.Coach;

/**
 * Compartment coach (купе)
 * With 35 places available, 3 items of baggage
 *  per person and 4 comfort stars
 */
public class Compartment extends Coach {

    String conductorName;
    boolean teaAvailable;

    public Compartment(String conductorName, boolean teaAvailable) {
        super((byte)35, (byte)3, (byte)4);
        this.conductorName = conductorName;
        this.teaAvailable = teaAvailable;
    }

    public void setConductorName(String conductorName) {
        this.conductorName = conductorName;
    }

    public void setTeaAvailable(boolean teaAvailable) {
        this.teaAvailable = teaAvailable;
    }

    public String getConductorName() {
        return conductorName;
    }

    public boolean isTeaAvailable() {
        return teaAvailable;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
//        if (obj == null) return false;
        if (!(obj instanceof Compartment)) return false;
        if (!super.equals(obj)) return false;

        Compartment otherTrain = (Compartment) obj;
        return conductorName.equals(otherTrain.getConductorName())
                && teaAvailable == otherTrain.isTeaAvailable();
    }

    @Override
    public String toString() {
        String compartmentParam = "";
        if (teaAvailable) compartmentParam = " + tea";
        return String.format("%-5s %-11s ", "****", "Compartment")
                + super.toString() + compartmentParam + "\n";
    }
}