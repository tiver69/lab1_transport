package service;

import factory.train.*;
import model.railway.*;
import model.railway.trains.*;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class TrainServiceTest {

    public static Intercity intercityTrain;
    public static Regular regularTrain;

    @BeforeClass
    public static void setUpClass(){
        IntercityTrainFactory bigIntercityFactory = new IntercityTrainFactory(732, "Zaporizhzhya",
                "Kyiv", (byte)10, (byte)10);
        intercityTrain = bigIntercityFactory.createTrain();
        RegularTrainFactory bigRegularFactory = new RegularTrainFactory(72, "Zaporizhzhya",
                "Kyiv", (byte)2, (byte)10, (byte)15 );
        regularTrain = bigRegularFactory.createTrain();
    }

    @Test
    public void passengersBetween() {
        ArrayList<Coach> passengersBetween = TrainService.passengersBetween(regularTrain,
                (byte)30, (byte)40);
        Assert.assertThat("Number of filtered coaches must match compartment coach quantity",
                (byte)passengersBetween.size(), equalTo(regularTrain.getCompartmentCoach()));
    }

    @Test
    public void ascendingComfortSort() {
        ArrayList<Coach> sortedCoaches = TrainService.AscendingComfortSort(regularTrain);
        boolean flag = true;
        for (int i=0; i<sortedCoaches.size() - 1; i++){
            if (sortedCoaches.get(i).getStar() > sortedCoaches.get(i+1).getStar()) flag = false;
        }
        Assert.assertTrue("Values are not sorted",flag);
    }

    @Test
    public void countPassengers() {
        int intercityPassengers = TrainService.countPassengers(intercityTrain);
        int regularPassengers = TrainService.countPassengers(regularTrain);
        int totalPassengers = 10*(64+94+35)+20*2+54*15;
        Assert.assertThat("Number of passengers mush be equal",
                intercityPassengers + regularPassengers,equalTo(totalPassengers));
    }

    @Test
    public void countBaggage() {
        int intercityBaggage = TrainService.countBaggage(intercityTrain);
        int regularBaggage = TrainService.countBaggage(regularTrain);
        int totalBaggage = 10*(64*3+94*2+35*3)+20*2*4+54*15;
        Assert.assertThat("Number of baggage mush be equal",
                intercityBaggage + regularBaggage,equalTo(totalBaggage));
    }
}