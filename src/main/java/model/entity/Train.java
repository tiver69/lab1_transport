package model.entity;

import java.util.ArrayList;

/**
 * Abstract class for trains, which includes
 *  * - number of route
 *  * - departure station
 *  * - destination station
 *  * - list of coaches in train
 */
public abstract class Train {
    private int id;
    private String departure;
    private String destination;
    private ArrayList<Coach> coaches;

    public Train(int id, String departure, String destination, ArrayList<Coach> coaches) {
        this.id = id;
        this.departure = departure;
        this.destination = destination;
        this.coaches = coaches;
    }

    public ArrayList<Coach> getCoaches() {
        return (ArrayList<Coach>)coaches.clone();
    }

    public Coach getCoachByNumber(byte coachNum){
        return coaches.get(coachNum);
    }

    public int getId() {
        return id;
    }

    public String getDeparture() {
        return departure;
    }

    public String getDestination() {
        return destination;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
//        if (obj == null) return false;
        if (!(obj instanceof Train)) return false;

        Train otherTrain = (Train)obj;
        return id == otherTrain.id
                && departure.equals(otherTrain.departure)
                && destination.equals(otherTrain.destination)
                && coaches.equals(otherTrain.getCoaches());
    }

    @Override
    public String toString() {
        String trainString = String.format("#%d %s - %s:\n",id,departure,destination);
        for (int i = 0; i< coaches.size(); i++){
            trainString = trainString + String.format("%3d: %s",i+1, coaches.get(i).toString());
        }
        return trainString;
    }
}