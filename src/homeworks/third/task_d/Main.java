package src.homeworks.third.task_d;

import java.util.Scanner;

/**
 * а) Создать класс Товар, имеющий переменные имя, цена, рейтинг. б) Создать
 * класс Категория, имеющий переменные имя и массив товаров. Создать несколько
 * объектов класса Категория. в) Создать класс Basket, содержащий массив
 * купленных товаров. г) Создать класс User, содержащий логин, пароль и объект
 * класса Basket. Создать объект класса User.
 */
public class Main {
    public static void main(String[] args) {

        final int NUMBER_OF_PRODUCTS = 5;
        Scanner input = new Scanner(System.in);
        Category smartphones = new Category();
        Category laptops = new Category();
        Category computers = new Category();

        User admin = new User("admin", "someStrongPassword_123");

        System.out.println(
                "Введите продуктов, которые подходят в категорию ПК (цена и рейтинг будут заданы автоматически):");
        for (int currProduct = 0; currProduct < NUMBER_OF_PRODUCTS; currProduct++) {
            String inputString = input.nextLine();
            Product productToAdd = new Product(inputString, Math.random() * 1000, Math.random());
            computers.addProduct(productToAdd);
        }

        System.out.println("А теперь несколько товаров и их цен для помещения в корзину");
        for (int currProduct = 0; currProduct < NUMBER_OF_PRODUCTS; currProduct++) {
            String inputString = input.nextLine();
            int price = input.nextInt();
            Product productToAdd = new Product(inputString, price, Math.random());
            admin.addProductToUserBasket(productToAdd);
            input.nextLine();
        }

        smartphones.addProduct(null);
        laptops.getName();

        
        System.out.println("Все операции выполнены успешно.");
        input.close();
    }
}
