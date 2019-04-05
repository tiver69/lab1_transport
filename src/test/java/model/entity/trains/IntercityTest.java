package model.entity.trains;

import model.entity.coaches.SeatingFirst;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

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
                .setSittingFirstCoach((byte)2)
                .setSittingSecondCoach((byte)10)
                .build();

        intercityTrain2 = new Intercity.IntercityBuilder(732,
                "Zaporizhzhya","Kyiv" )
                .setSittingFirstCoach((byte)2)
                .setSittingSecondCoach((byte)10)
                .build();

        intercityTrain3 = new Intercity.IntercityBuilder(732,
                "Zaporizhzhya","Kyiv" )
                .setSittingFirstCoach((byte)10)
                .setSittingSecondCoach((byte)10)
                .build();
        ((SeatingFirst)intercityTrain3.getCoachByNumber((byte)2)).setLunchAvailable(false);
    }

    @Test
    public void shouldReturnTrueWithIT12() {
        Assert.assertThat(intercityTrain2, equalTo(intercityTrain1));
    }

    @Test
    public void shouldReturnFalseWithIT13() {
        Assert.assertThat(intercityTrain1, is(not(equalTo(intercityTrain3))));
    }

    @Test
    public void shouldReturnFalseWithITAndRT() {
        Assert.assertThat(intercityTrain1, is(not(equalTo(regularTrain1))));
    }
}