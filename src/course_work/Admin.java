package src.course_work;

public class Admin extends User {

    public Admin() {
        super("default", "admin", "admin");
    }

    public Admin(String name, String login, String password) {
        super(name, login, password);
    }

}
