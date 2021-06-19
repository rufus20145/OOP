package src.homeworks.third.task_d;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private List<Product> products;

    public Basket() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

}
