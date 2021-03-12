package src.homeworks.third.task_d;

import java.util.ArrayList;
import java.util.List;

public class Category {

    String name;
    List<Product> products = new ArrayList<>();

    public Category() {
        
    }

    public Category(String name) {
        this.name = name;
    }
}
