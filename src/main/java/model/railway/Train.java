package model.railway;

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

    public void setCoachFreePlaces(byte coachNum, byte free){
        coaches.get(coachNum).setFree(free);
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
