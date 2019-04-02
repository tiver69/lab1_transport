package model.railway;

import model.railway.coach.Coach;

import java.util.ArrayList;

public class Regular extends Train{
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
        return "RegularTrain" + super.toString() + "}";
    }
}
