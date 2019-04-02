package model.railway;

public abstract class Coach {
    private byte passenger;
    private byte baggageCoefficient;
    private byte star;
    private byte free;

    public Coach(byte passenger, byte baggage, byte star) {
        this.passenger = passenger;
        this.baggageCoefficient = baggage;
        this.star = star;
        this.free = passenger;
    }

    public void setFree(byte free) {
        this.free = free;
    }

    public byte getPassenger() {
        return passenger;
    }

    public byte getBaggageCoefficient() {
        return baggageCoefficient;
    }

    public byte getStar() {
        return star;
    }

    public byte getFree() {
        return free;
    }

    @Override
    public String toString() {
        return  String.format("[%d/%d free]\n",free, passenger);
    }
}
