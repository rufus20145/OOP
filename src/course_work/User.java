package src.course_work;

import java.util.Objects;

public class User {
    private String name;
    private String login;
    private String password;

    public User(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public boolean enter(String login, String password) {
        return Objects.equals(this.login, login) && Objects.equals(this.password, password);
    }

    public String getName() {
        return name;
    }
}
