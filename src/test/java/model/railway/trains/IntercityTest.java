package model.railway.trains;

import factory.train.IntercityTrainFactory;
import factory.train.RegularTrainFactory;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntercityTest {

    public static Intercity intercityTrain1, intercityTrain2, intercityTrain3;
    public static Regular regularTrain1;

    @BeforeClass
    public static void setUpClass(){
        IntercityTrainFactory bigIntercityFactory = new IntercityTrainFactory(732, "Zaporizhzhya",
                "Kyiv", (byte)10, (byte)10);
        intercityTrain1 = bigIntercityFactory.createTrain();
        intercityTrain2 = bigIntercityFactory.createTrain();
        IntercityTrainFactory bigIntercityFactory2 = new IntercityTrainFactory(732, "Kyiv",
                "Zaporizhzhya", (byte)10, (byte)10);
        intercityTrain3 = bigIntercityFactory2.createTrain();
        RegularTrainFactory bigRegularFactory = new RegularTrainFactory(72, "Zaporizhzhya",
                "Kyiv", (byte)2, (byte)10, (byte)15 );
        regularTrain1 = bigRegularFactory.createTrain();
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