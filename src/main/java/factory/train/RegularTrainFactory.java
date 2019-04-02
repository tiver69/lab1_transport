package factory.train;

import factory.TrainFactory;
import model.railway.Coach;
import model.railway.trains.Regular;
import model.railway.coaches.*;
import java.util.ArrayList;

/**
 * Abstract factory for creating regular train entities
 * By default with 1 de luxe, 4 compartment
 * and 5 berth coaches
 */
public class RegularTrainFactory extends TrainFactory {
    private byte deLuxeCoach;
    private byte compartmentCoach;
    private byte berthCoach;
    private ArrayList<Coach> train;

    public RegularTrainFactory(int id, String departure, String destination,
                               byte deLuxeCoach, byte compartmentCoach, byte berthCoach) {
        super(id, departure, destination);
        this.deLuxeCoach = deLuxeCoach;
        this.compartmentCoach = compartmentCoach;
        this.berthCoach = berthCoach;
    }

    public RegularTrainFactory(int id, String departure, String destination) {
        super(id, departure, destination);
        deLuxeCoach = 1;
        compartmentCoach = 4;
        berthCoach = 5;
    }

    protected void setTrain(){
        train = new ArrayList();

        for (int i=0; i<deLuxeCoach; i++){
            train.add(new DeLuxe());
        }

        for (int i=0; i<compartmentCoach; i++){
            train.add(new Compartment());
        }

        for (int i=0; i<berthCoach; i++){
            train.add(new Berth());
        }
    }

    public Regular createTrain(){
        setTrain();
        return new Regular(id,departure,destination,train,berthCoach,compartmentCoach,deLuxeCoach);
    }
}
