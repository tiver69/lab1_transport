import model.entity.*;
import model.entity.trains.Intercity;
import model.entity.trains.Regular;
import service.TrainService;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Train> trains = new ArrayList<Train>();

    public static void main(String[] args) {

        Regular regular = new Regular.RegularBuilder(72, "Zaporizhzhya",
                "Kyiv")
                .setDeLuxeCoach((byte)2)
                .setCompartmentCoach((byte)10)
                .setBerthCoach((byte)15)
                .build();

        Intercity intercity = new Intercity.IntercityBuilder(732,
                "Zaporizhzhya","Kyiv" )
                .setSittingFirstCoach((byte)15)
                .setSittingSecondCoach((byte)15)
                .build();

        trains.add(regular);
        trains.add(intercity);

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
