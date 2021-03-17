package src.homeworks.third.task_d;

public class User {

    private String username;
    private String password;
    private Basket userBasket;

    public User() {

    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        userBasket = new Basket();
    }

    public void addProductToUserBasket(Product product) {
        this.userBasket.addProduct(product);
    }
}
