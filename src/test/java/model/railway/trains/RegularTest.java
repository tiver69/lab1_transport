package model.railway.trains;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class RegularTest {

    public static Regular regularTrain1, regularTrain2, regularTrain3;
    public static Intercity intercityTrain1;

    @BeforeClass
    public static void setUpClass(){

        regularTrain1 = new Regular.RegularBuilder(72, "Zaporizhzhya",
                "Kyiv")
                .setDeLuxeCoach((byte)2)
                .setCompartmentCoach((byte)10)
                .setBerthCoach((byte)15)
                .build();

        regularTrain2 = new Regular.RegularBuilder(72, "Zaporizhzhya",
                "Kyiv")
                .setDeLuxeCoach((byte)3)
                .setCompartmentCoach((byte)11)
                .setBerthCoach((byte)16)
                .build();

        regularTrain3 = new Regular.RegularBuilder(72, "Zaporizhzhya",
                "Kyiv")
                .setDeLuxeCoach((byte)3)
                .setCompartmentCoach((byte)11)
                .setBerthCoach((byte)16)
                .build();

        intercityTrain1 = new Intercity.IntercityBuilder(732,
                "Zaporizhzhya","Kyiv" )
                .setSittingFirstCoach((byte)10)
                .setSittingSecondCoach((byte)10)
                .build();
    }

    @Test
    public void shouldReturnTrueWithRT23() {
        Assert.assertTrue(regularTrain2.equals(regularTrain3));
    }

    @Test
    public void shouldReturnFalseWithRT13() {
        Assert.assertFalse(regularTrain1.equals(regularTrain3));
    }

    @Test
    public void shouldReturnFalseWithITAndRT() {
        Assert.assertFalse(intercityTrain1.equals(regularTrain1));
    }
}