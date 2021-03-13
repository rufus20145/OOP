package src.homeworks.third.task_d;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    List<Product> products = new ArrayList<>();// 123

    public Basket() {

    }

    public void addProduct(Product product) {
        products.add(product);
    }
    
}
