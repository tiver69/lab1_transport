package model.entity.coaches;

import model.entity.Coach;

/**
 * DeLuxe coach (Люкс)
 * With 20 places available, 4 item of baggage
 *  per person and 5 comfort star
 */
public class DeLuxe extends Coach {

    String conductorName;
    boolean teaAvailable;
    boolean wifiAvailable;

    public DeLuxe(String conductorName, boolean teaAvailable, boolean wifiAvailable) {
        super((byte)20, (byte)4, (byte)5);
        this.conductorName = conductorName;
        this.teaAvailable = teaAvailable;
        this.wifiAvailable = wifiAvailable;
    }

    public void setConductorName(String conductorName) {
        this.conductorName = conductorName;
    }

    public void setTeaAvailable(boolean teaAvailable) {
        this.teaAvailable = teaAvailable;
    }

    public void setWifiAvailable(boolean wifiAvailable) {
        this.wifiAvailable = wifiAvailable;
    }

    public String getConductorName() {
        return conductorName;
    }

    public boolean isTeaAvailable() {
        return teaAvailable;
    }

    public boolean isWifiAvailable() {
        return wifiAvailable;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
//        if (obj == null) return false;
        if (!(obj instanceof DeLuxe)) return false;
        if (!super.equals(obj)) return false;

        DeLuxe otherTrain = (DeLuxe) obj;
        return conductorName.equals(otherTrain.getConductorName())
                && wifiAvailable == otherTrain.isWifiAvailable()
                && teaAvailable == otherTrain.isTeaAvailable();
    }

    @Override
    public String toString() {
        String luxeParam = "";
        if (teaAvailable) luxeParam = " + tea";
        if (wifiAvailable) luxeParam += " + WiFi";
        return String.format("%-5s %-11s ", "*****","DeLuxe")
                + super.toString() + luxeParam + "\n";
    }
}