package model.entity;


/**
 * Abstract class for train coaches, which includes
 * - total number of passengers in coach
 * - coefficient for baggage per person
 * - level of comfort (from 1 to 5)
 * - number of places available for booking
 */
public abstract class Coach {
    private byte passenger;
    private byte baggageCoefficient;
    private byte star;
    private byte free;

    /**
     * @param passenger - total number of passengers in coach
     * @param baggageCoefficient - coefficient for baggage per person
     * @param star - level of comfort (from 1 to 5)
     */
    public Coach(byte passenger, byte baggageCoefficient, byte star) {
        this.passenger = passenger;
        this.baggageCoefficient = baggageCoefficient;
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
