package model.railway.trains;

import model.railway.Coach;
import model.railway.Train;

import java.util.ArrayList;

/**
 * Intercity class of trains, which includes
 * - number of first class coaching in train
 * - number of second class coaching in train
 */
public class Intercity extends Train {
    private byte sittingFirstCoach;
    private byte sittingSecondCoach;

    public Intercity(int id, String departure, String destination, ArrayList<Coach> train,
                     byte sittingFirstCoach, byte sittingSecondCoach) {
        super(id, departure, destination, train);
        this.sittingFirstCoach = sittingFirstCoach;
        this.sittingSecondCoach = sittingSecondCoach;
    }

    @Override
    public String toString() {
        return "Intercity Train" + super.toString() + "}";
    }
}
