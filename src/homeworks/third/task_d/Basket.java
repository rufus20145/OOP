package homeworks.third.task_d;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private List<Product> products = new ArrayList<>();

    public Basket() {

    }

    public void addProduct(Product product) {
        products.add(product);
    }

}
