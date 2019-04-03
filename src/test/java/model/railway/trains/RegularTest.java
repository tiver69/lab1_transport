package model.railway.trains;

import factory.train.IntercityTrainFactory;
import factory.train.RegularTrainFactory;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class RegularTest {

    public static Regular regularTrain1, regularTrain2, regularTrain3;
    public static Intercity intercityTrain1;

    @BeforeClass
    public static void setUpClass(){
        RegularTrainFactory bigRegularFactory = new RegularTrainFactory(72, "Zaporizhzhya",
                "Kyiv", (byte)2, (byte)10, (byte)15 );
        regularTrain1 = bigRegularFactory.createTrain();
        RegularTrainFactory bigRegularFactory2 = new RegularTrainFactory(72, "Zaporizhzhya",
                "Kyiv", (byte)3, (byte)11, (byte)16 );
        regularTrain2 = bigRegularFactory2.createTrain();
        regularTrain3 = bigRegularFactory2.createTrain();
        IntercityTrainFactory bigIntercityFactory = new IntercityTrainFactory(732, "Zaporizhzhya",
                "Kyiv", (byte)10, (byte)10);
        intercityTrain1 = bigIntercityFactory.createTrain();
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