import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TimeSquareTest {

    private static final int height = 200;

    private TimeSquare TimeSquare_1;


    @Before
    public void before(){
        TimeSquare_1 = new TimeSquare(height);
        Assert.assertEquals(height, TimeSquare_1.getHeight());
    }

    @Test
    public void aggregate(){
        int aggregate = TimeSquare_1.aggregate(null);
        Assert.assertEquals(height, aggregate);

        System.out.println("Aggregate: ");
        final int add_road = 250;
        System.out.println("Sum of roads: " + TimeSquare_1.aggregate(add_road) + " km");

        Assert.assertEquals((int) (height + add_road), (int)(TimeSquare_1.aggregate(add_road)));
    }

    @Test
    public void deepClone(){
        TimeSquare clone = TimeSquare_1.deepClone();
        Assert.assertEquals(TimeSquare_1.getHeight(), clone.getHeight());
        Assert.assertNotSame(TimeSquare_1, clone);
    }

}
