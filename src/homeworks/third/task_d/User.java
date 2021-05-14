package homeworks.third.task_d;

import java.util.Objects;

public class User {

    private String username;
    private String password;
    private Basket userBasket;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        userBasket = new Basket();
    }

    public void addProductToUserBasket(Product product) {
        this.userBasket.addProduct(product);
    }

    public boolean login(String username, String password) {
        return Objects.equals(this.password, password) && Objects.equals(this.username, username);
    }

    public String getUsername() {
        return username;
    }
}
