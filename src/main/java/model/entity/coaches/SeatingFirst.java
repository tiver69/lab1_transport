package model.entity.coaches;

import model.entity.Coach;

/**
 * SeatingFirst coach (сидячий первого класса)
 * With 64 places available, 3 item of baggage
 *  per person and 3 comfort star
 */
public class SeatingFirst extends Coach {

    Boolean lunchAvailable;

    public SeatingFirst(boolean lunchAvailable) {
        super((byte)64, (byte)3, (byte)3);
        this.lunchAvailable = lunchAvailable;
    }

    public Boolean getLunchAvailable() {
        return lunchAvailable;
    }

    public void setLunchAvailable(Boolean lunchAvailable) {
        this.lunchAvailable = lunchAvailable;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
//        if (obj == null) return false;
        if (!(obj instanceof SeatingFirst)) return false;
        SeatingFirst otherTrain = (SeatingFirst)obj;
        return lunchAvailable == otherTrain.lunchAvailable;
    }

    @Override
    public String toString() {
        String firstParam = "";
        if (lunchAvailable) firstParam = " + lunch";
        return String.format("%-5s %-14s ", "***","Seating First")
                + super.toString()+ firstParam + "\n";
    }
}