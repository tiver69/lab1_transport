package service;

import model.railway.Coach;
import model.railway.Train;

import java.util.ArrayList;

public class TrainService {

    /**
     * Search for all coaches with
     * total passenger places between parameters
     * @param train  - specific train entity for filtering
     * @param lover  - lower border of places
     * @param higher - higher order of places
     * @return array list of filtered coaches
     */
    public static ArrayList<Coach> passengersBetween(Train train, byte lover, byte higher){
        ArrayList<Coach> trainCoaches = train.getCoaches();
        ArrayList<Coach> resultCoaches = new ArrayList();
        for (int i = 0; i < trainCoaches.size(); i++) {
            Coach coach = trainCoaches.get(i);
            if (coach.getPassenger() > lover && coach.getPassenger() < higher) {
//                System.out.format("%3d: %s", i + 1, coach.toString());
                resultCoaches.add(coach);
            }
        }
        return resultCoaches;
    }

    /**
     * Sort all coaches from lower comfort class
     * to higher
     * @param train - train for sorting
     * @return array list with sorted values
     */
    public static ArrayList<Coach> AscendingComfortSort(Train train){
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
//        printCoachesArray(trainCoaches);
        return trainCoaches;
    }

    /**
     * Count total passenger capacity
     * @param train - for counting
     * @return - passenger capacity
     */
    public static int countPassengers(Train train){
        ArrayList<Coach> trainCoaches = train.getCoaches();
        int sumPassengers = 0;
        for (Coach coach: trainCoaches){
            sumPassengers+=coach.getPassenger();
        }
        return sumPassengers;
    }

    /**
     * Count total passenger capacity
     * @param train - for counting
     * @return - passenger capacity
     */
    public static int countBaggage(Train train){
        ArrayList<Coach> trainCoaches = train.getCoaches();
        int sumBaggage = 0;
        for (Coach coach: trainCoaches){
            sumBaggage+=coach.getPassenger()*coach.getBaggageCoefficient();
        }
        return sumBaggage;
    }

    private static void printCoachesArray(ArrayList<Coach> trainCoaches){
        for (Coach coach: trainCoaches) {
            System.out.println(coach);
        }
    }

}
