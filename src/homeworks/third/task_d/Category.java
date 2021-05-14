package homeworks.third.task_d;

import java.util.ArrayList;
import java.util.List;

public class Category {

    private String name;
    private List<Product> products = new ArrayList<>();

    public Category() {

    }

    public Category(String name) {
        this.name = name;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public String getName() {
        return name;
    }
}
