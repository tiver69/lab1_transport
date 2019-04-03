package model.railway.trains;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntercityTest {

    public static Intercity intercityTrain1, intercityTrain2, intercityTrain3;
    public static Regular regularTrain1;

    @BeforeClass
    public static void setUpClass(){
        regularTrain1 = new Regular.RegularBuilder(72, "Zaporizhzhya",
                "Kyiv")
                .setDeLuxeCoach((byte)2)
                .setCompartmentCoach((byte)10)
                .setBerthCoach((byte)15)
                .build();

        intercityTrain1 = new Intercity.IntercityBuilder(732,
                "Zaporizhzhya","Kyiv" )
                .setSittingFirstCoach((byte)10)
                .setSittingSecondCoach((byte)10)
                .build();

        intercityTrain2 = new Intercity.IntercityBuilder(732,
                "Zaporizhzhya","Kyiv" )
                .setSittingFirstCoach((byte)10)
                .setSittingSecondCoach((byte)10)
                .build();

        intercityTrain3 = new Intercity.IntercityBuilder(732,
                "Kyiv","Zaporizhzhya" )
                .setSittingFirstCoach((byte)10)
                .setSittingSecondCoach((byte)10)
                .build();
    }

    @Test
    public void shouldReturnTrueWithIT12() {
        Assert.assertTrue(intercityTrain2.equals(intercityTrain1));
    }

    @Test
    public void shouldReturnFalseWithIT13() {
        Assert.assertFalse(intercityTrain1.equals(intercityTrain3));
    }

    @Test
    public void shouldReturnFalseWithITAndRT() {
        Assert.assertFalse(intercityTrain1.equals(regularTrain1));
    }
}