package model.railway.trains;

import model.railway.Coach;
import model.railway.Train;
import model.railway.coaches.SeatingFirst;
import model.railway.coaches.SeatingSecond;

import java.util.ArrayList;

/**
 * Intercity class of trains, which includes
 * - number of first class coaching in train
 * - number of second class coaching in train
 */
public class Intercity extends Train {
    private byte sittingFirstCoach;
    private byte sittingSecondCoach;

    public Intercity(IntercityBuilder builder){
        super(builder.id, builder.departure, builder.destination, builder.coaches);
        this.sittingFirstCoach = builder.sittingFirstCoach;
        this.sittingSecondCoach = builder.sittingSecondCoach;
    }

//    public Intercity(int id, String departure, String destination, ArrayList<Coach> train,
//                     byte sittingFirstCoach, byte sittingSecondCoach) {
//        super(id, departure, destination, train);
//        this.sittingFirstCoach = sittingFirstCoach;
//        this.sittingSecondCoach = sittingSecondCoach;
//    }

    public byte getSittingFirstCoach() {
        return sittingFirstCoach;
    }

    public byte getSittingSecondCoach() {
        return sittingSecondCoach;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
//        if (obj == null) return false;
        if (!(obj instanceof Intercity)) return false;
        if (!super.equals(obj)) return false;

        Intercity otherTrain = (Intercity) obj;
        return sittingFirstCoach == otherTrain.getSittingFirstCoach()
                && sittingSecondCoach == otherTrain.getSittingSecondCoach();
    }

    @Override
    public String toString() {
        return "Intercity Train" + super.toString();
    }

    public static class IntercityBuilder{
        private int id;
        private String departure;
        private String destination;
        private ArrayList<Coach> coaches;
        private byte sittingFirstCoach = 10;
        private byte sittingSecondCoach = 10;

        public IntercityBuilder(int id, String departure, String destination){
            this.id = id;
            this.departure = departure;
            this.destination = destination;
        }

        public IntercityBuilder setSittingFirstCoach(byte sittingFirstCoach) {
            this.sittingFirstCoach = sittingFirstCoach;
            return this;
        }

        public IntercityBuilder setSittingSecondCoach(byte sittingSecondCoach) {
            this.sittingSecondCoach = sittingSecondCoach;
            return this;
        }

        public Intercity build() {

            coaches = new ArrayList();
            for (int i=0; i<this.sittingFirstCoach; i++){
                coaches.add(new SeatingFirst());
            }

            for (int i=0; i<this.sittingSecondCoach; i++){
                coaches.add(new SeatingSecond());
            }
            return new Intercity(this);
        }
    }
}
