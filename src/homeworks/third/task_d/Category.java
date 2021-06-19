package src.homeworks.third.task_d;

import java.util.ArrayList;
import java.util.List;

public class Category {

    private String name;
    private List<Product> products;

    public Category() {
        this("Default");
    }

    public Category(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public String getName() {
        return name;
    }
}
