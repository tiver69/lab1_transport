package model.entity.coaches;

import model.entity.Coach;

/**
 * SeatingSecond coach (сидячий второго класса)
 * With 94 places available, 2 item of baggage
 *  per person and 2 comfort star
 */
public class SeatingSecond extends Coach {

    Boolean wifiAvailable;
    Boolean socketAvailable;

    public SeatingSecond(boolean socketAvailable, boolean wifiAvailable) {
        super((byte)94, (byte)2, (byte)2);
        this.wifiAvailable = wifiAvailable;
        this.socketAvailable = socketAvailable;
    }

    public void setWifiAvailable(Boolean wifiAvailable) {
        this.wifiAvailable = wifiAvailable;
    }

    public void setSocketAvailable(Boolean socketAvailable) {
        this.socketAvailable = socketAvailable;
    }

    public Boolean isSocketAvailable() {
        return socketAvailable;
    }

    public Boolean isWifiAvailable() {
        return wifiAvailable;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
//        if (obj == null) return false;
        if (!(obj instanceof SeatingSecond)) return false;
        if (!super.equals(obj)) return false;

        SeatingSecond otherTrain = (SeatingSecond)obj;
        return wifiAvailable == otherTrain.wifiAvailable
                && socketAvailable == otherTrain.isSocketAvailable();
    }

    @Override
    public String toString() {
        String secondParam = "";
        if (socketAvailable)
            secondParam += " + 220V";
        if (wifiAvailable)
            secondParam += " + WiFi";
        return String.format("%-5s %-14s ", "**","Seating Second")
                + super.toString() + secondParam + "\n";
    }
}