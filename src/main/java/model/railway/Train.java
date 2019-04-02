package model.railway;

import model.railway.coach.Coach;

import java.util.ArrayList;

public abstract class Train {
    private int id;
    private String departure;
    private String destination;

    private ArrayList<Coach> train;

    public Train(int id, String departure, String destination, ArrayList<Coach> train) {
        this.id = id;
        this.departure = departure;
        this.destination = destination;
        this.train = train;
    }

    @Override
    public String toString() {
        String trainString = String.format("#%d %s - %s:\n",id,departure,destination);
        for (int i=0; i< train.size(); i++){
            trainString = trainString + String.format("%3d: %s",i+1, train.get(i).toString());
        }
        return trainString;
    }
}
