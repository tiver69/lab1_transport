package model.railway.trains;

import model.railway.Coach;
import model.railway.Train;

import java.util.ArrayList;

/**
 * Regular class of trains, which includes
 * - number of berth coaches in train
 * - number of compartment coaches in train
 * - number of de luxe coaches in train
 */
public class Regular extends Train {
    private byte berthCoach;
    private byte compartmentCoach;
    private byte deLuxeCoach;

    public Regular(int id, String departure, String destination, ArrayList<Coach> train,
                   byte berthCoach, byte compartmentCoach, byte deLuxeCoach) {
        super(id, departure, destination, train);
        this.berthCoach = berthCoach;
        this.compartmentCoach = compartmentCoach;
        this.deLuxeCoach = deLuxeCoach;
    }

    @Override
    public String toString() {
        return "Regular Train" + super.toString() + "}";
    }
}
