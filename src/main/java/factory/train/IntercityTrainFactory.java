package factory.train;

import factory.TrainFactory;
import model.railway.coaches.*;
import model.railway.trains.Intercity;

import java.util.ArrayList;

/**
 * Abstract factory for creating intercity train entities
 * By default with 5 coaches of both classes
 */
public class IntercityTrainFactory extends TrainFactory {
    private byte seatingFirstCoach;
    private byte seatingSecondCoach;

    public IntercityTrainFactory(int id, String departure, String destination,
                                 byte seatingFirstCoach, byte seatingSecondCoach) {
        super(id, departure, destination);
        this.seatingFirstCoach = seatingFirstCoach;
        this.seatingSecondCoach = seatingSecondCoach;
    }

    public IntercityTrainFactory(int id, String departure, String destination) {
        super(id,departure,destination);
        seatingFirstCoach = 5;
        seatingSecondCoach = 5;
    }

    protected void setTrain(){
        super.train = new ArrayList();

        for (int i=0; i<seatingFirstCoach; i++){
            train.add(new SeatingFirst());
        }

        for (int i=0; i<seatingSecondCoach; i++){
            train.add(new SeatingSecond());
        }
    }

    public Intercity createTrain(){
        setTrain();
        return new Intercity(id,departure,destination,train,seatingFirstCoach,seatingSecondCoach);
    }
}
