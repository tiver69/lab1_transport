package model.railway.trains;

import model.railway.Coach;
import model.railway.Train;
import model.railway.coaches.Berth;
import model.railway.coaches.Compartment;
import model.railway.coaches.DeLuxe;

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

    public Regular(RegularBuilder builder){
        super(builder.id, builder.departure, builder.destination, builder.coaches);
        this.berthCoach = builder.berthCoach;
        this.compartmentCoach = builder.compartmentCoach;
        this.deLuxeCoach = builder.deLuxeCoach;
    }


    public byte getBerthCoach() {
        return berthCoach;
    }

    public byte getCompartmentCoach() {
        return compartmentCoach;
    }

    public byte getDeLuxeCoach() {
        return deLuxeCoach;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
//        if (obj == null) return false;
        if (!(obj instanceof Regular)) return false;
        if (!super.equals(obj)) return false;

        Regular otherTrain = (Regular) obj;
        return berthCoach == otherTrain.getBerthCoach()
                && compartmentCoach == otherTrain.getCompartmentCoach()
                && deLuxeCoach == otherTrain.deLuxeCoach;
    }

    @Override
    public String toString() {
        return "Regular Train" + super.toString();
    }

    public static class RegularBuilder {
        private int id;
        private String departure;
        private String destination;
        private ArrayList<Coach> coaches;
        private byte berthCoach;
        private byte compartmentCoach;
        private byte deLuxeCoach;

        public RegularBuilder(int id, String departure, String destination) {
            this.id = id;
            this.departure = departure;
            this.destination = destination;
        }

        public RegularBuilder setBerthCoach(byte berthCoach) {
            this.berthCoach = berthCoach;
            return this;
        }

        public RegularBuilder setCompartmentCoach(byte compartmentCoach) {
            this.compartmentCoach = compartmentCoach;
            return this;
        }

        public RegularBuilder setDeLuxeCoach(byte deLuxeCoach) {
            this.deLuxeCoach = deLuxeCoach;
            return this;
        }

        public Regular build(){
            coaches = new ArrayList();

            for (int i=0; i<deLuxeCoach; i++){
                coaches.add(new DeLuxe());
            }

            for (int i=0; i<compartmentCoach; i++){
                coaches.add(new Compartment());
            }

            for (int i=0; i<berthCoach; i++){
                coaches.add(new Berth());
            }
            return new Regular(this);
        }
    }

}
