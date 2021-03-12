package src.homeworks.third.task_d;

/**
 * а) Создать класс Товар, имеющий переменные имя, цена, рейтинг. 
 * б) Создать класс Категория, имеющий переменные имя и массив товаров. Создать несколько объектов класса Категория.
 * в) Создать класс Basket, содержащий массив купленных товаров.
 * г) Создать класс User, содержащий логин, пароль и объект класса Basket. Создать объект класса User.
 */
public class Main {
    public static void main(String[] args) {
        Category smartphones = new Category();
        Category laptops = new Category();
        Category computers = new Category();

        User admin = new User("admin", "admin");

        System.out.println("Objects were created.");
    }
}
