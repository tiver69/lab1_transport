package service;

import model.railway.Coach;
import model.railway.Train;

import java.util.ArrayList;

public class TrainService {

    /**
     * Print all available coaches with
     * total passengers places between parameters
     * @param train  - specific train entity for filtering
     * @param lover  - lower border of places
     * @param higher - higher order of places
     */
    public static void passengersBetween(Train train, byte lover, byte higher){
        ArrayList<Coach> trainCoaches = train.getCoaches();
        for (int i = 0; i < trainCoaches.size(); i++){
            Coach coach = trainCoaches.get(i);
            if (coach.getPassenger()>lover && coach.getPassenger() < higher)
                System.out.format("%3d: %s",i+1, coach.toString());
        }
    }

    public static void AscendingComfortSort(Train train){
        ArrayList<Coach> trainCoaches = train.getCoaches();
        for (int i = 0; i < trainCoaches.size(); i++){
            for (int j = i + 1; j < trainCoaches.size(); j++){
                if (trainCoaches.get(i).getPassenger() < trainCoaches.get(j).getPassenger()){
                    Coach coach = trainCoaches.get(i);
                    trainCoaches.set(i, trainCoaches.get(j));
                    trainCoaches.set(j, coach);
                }
            }
        }
        printCoachesArray(trainCoaches);
    }

    private static void printCoachesArray(ArrayList<Coach> trainCoaches){
        for (Coach coach: trainCoaches) {
            System.out.println(coach);
        }
    }

}
