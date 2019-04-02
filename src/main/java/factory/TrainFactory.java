package factory;

import model.railway.Train;
import model.railway.Coach;

import java.util.ArrayList;

public abstract class TrainFactory {
    protected int id;
    protected String departure;
    protected String destination;
    protected ArrayList<Coach> train;

    public TrainFactory(int id, String departure, String destination) {
        this.id = id;
        this.departure = departure;
        this.destination = destination;
    }

    protected abstract void setTrain();
    public abstract Train createTrain();
}
