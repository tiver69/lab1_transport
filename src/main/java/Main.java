import factory.train.IntercityTrainFactory;
import factory.train.RegularTrainFactory;
import model.railway.Coach;
import model.railway.Train;
import model.railway.trains.Intercity;
import model.railway.trains.Regular;
import service.TrainService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
//    private static Regular regular;
//    private static Intercity intercity;
    private static ArrayList<Train> trains = new ArrayList<Train>();

    public static void main(String[] args) {

        IntercityTrainFactory bigIntercity = new IntercityTrainFactory(732, "Zaporizhzhya",
                "Kyiv", (byte)10, (byte)10);

        RegularTrainFactory bigRegular = new RegularTrainFactory(72, "Zaporizhzhya",
                "Kyiv", (byte)2, (byte)10, (byte)15 );

        trains.add(bigRegular.createTrain());
        trains.add(bigIntercity.createTrain());
//        regular = bigRegular.createTrain();
//        intercity = bigIntercity.createTrain();

        printAll();

        String cmd = "";
        while (!cmd.equals(":q")){
            System.out.print("todo: ");
            Scanner in = new Scanner(System.in);
            cmd = in.nextLine();
            switch (cmd){
                case "count pass":
                    countPassengers();
                    break;
                case "count bagg":
                    countBaggage();
                    break;
                case "show cheaper":
                    showCheaper();
                    break;
                case "pass between":
                    System.out.print("from: ");
                    byte lover = in.nextByte();
                    System.out.print("to: ");
                    byte top = in.nextByte();
                    passengersBetween(lover,top);
                    break;
                case ":q":
                    break;
                default:
                    System.out.println("NO such command found");
                    break;
            }
        }
    }

    private static void countPassengers(){
        System.out.print("TOTAL PASSENGERS FOR:\n");
        for (Train train : trains) {
            System.out.println("#" + train.getId() + ": " +
                    TrainService.countPassengers(train));
        }
    }

    private static void countBaggage(){
        System.out.print("TOTAL BAGGAGE FOR:\n");
        for (Train train : trains) {
            System.out.println("#" + train.getId() + ": " +
                    TrainService.countBaggage(train));
        }
    }

    private static void showCheaper(){
        System.out.println("COACHES SORTED FROM CHEAP TO EXPENSIVE:\n");
        for (Train train : trains) {
            System.out.println("#" + train.getId() + ":");
            printCoachesArray(TrainService.AscendingComfortSort(train));
        }
    }

    private static void passengersBetween(byte lover, byte top){
        System.out.println("COACHES WITH PASSENGERS AMOUNT SORTED:\n");
        for (Train train : trains) {
            System.out.println("#" + train.getId() + ":");
            printCoachesArray(TrainService.passengersBetween(train,lover,top));
        }
    }

    private static void printAll(){
        System.out.println("TRAINS AVAILABLE:\n\n");
        for (Train train: trains) {
            System.out.println(train);
        }
    }

    private static void printCoachesArray(ArrayList<Coach> trainCoaches){
        for (Coach coach: trainCoaches) {
            System.out.print(coach);
        }
        System.out.println();
    }
}
