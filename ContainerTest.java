import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class ContainerTest {

    protected Container<Product, Integer> product_prices;
    protected static ArrayList<Product> list = new ArrayList<>();

    @Before
    public void beforeeach(){
        list.add(new Product(100));
        list.add(new Product(100));
        list.add(new Product(200));
        list.add(new Product(200));
        product_prices = new Container<Product, Integer>(list);
    }



    @Test
    public void elements() {
    }


    @Test
    public void aggregateAllElements() {

        int sum = 0;
        int  summaries = 0;

        for (int i = 0; i < list.size(); i++) {
            sum = sum + list.get(i).getPrice();
            summaries = (product_prices.elements().get(i).aggregate(summaries));
        }


        Assert.assertEquals(sum, summaries);
    }

    @Test
    public void cloneElementAtIndex() {
    try {
        Product copy = product_prices.elements().get(2).deepClone();
        Assert.assertEquals(product_prices.elements().get(2).getPrice(), copy.getPrice());
    }
    catch(IndexOutOfBoundsException e) {
        System.out.println("Index too big or small");
    }
    }
}
