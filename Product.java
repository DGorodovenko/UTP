import java.util.ArrayList;
import java.util.List;

public class Product implements IAggregable<Product, Integer>, IDeeplyCloneable<Product> {

    private int price;
    private int counter = 0;
    protected int current_price = price;
    protected ArrayList<Integer> price_list = new ArrayList<>();
    protected int average = 0;

    public Product() {
    }

    public Product(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public Integer aggregate(Integer whattoadd) {
        if  (whattoadd == null) {
            return price;
        }
        current_price = current_price + whattoadd;
        counter++;
        return price + whattoadd;
    }

    public Product deepClone() {
        Product clone = new Product();
        clone.price = price;
        return clone;
    }

}
