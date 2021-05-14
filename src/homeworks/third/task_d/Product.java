package src.homeworks.third.task_d;

public class Product {

    private String name;
    private double price;
    private double rating;

    public Product() {

    }

    public Product(String name, double price, double rating) {
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }

}
