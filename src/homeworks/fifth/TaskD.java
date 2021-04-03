// package src.homeworks.fifth;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TaskD {
    public static void main(String[] args) {

        final int percent = 100;

        double price = 0;
        double inflation = 0;
        int numberOfMonths = 0;
        Scanner input = new Scanner(System.in);
        boolean exceptionCaught = false;

        System.out.println("Введите начальную цену товара ");
        do {
            exceptionCaught = false;
            try {
                price = input.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Вам разрешено ввести только дробное число. Повторите попытку.");
                input.nextLine();
                exceptionCaught = true;
            } catch (NoSuchElementException e) {
                System.out.println("Вы ничего не ввели. Выход из программы.");
                input.nextLine();
                exceptionCaught = true;
            } catch (IllegalStateException e) {
                System.out.println("Система ввода оказалась в некорректном состоянии. Повторите попытку.");
                input = new Scanner(System.in);
                input.nextLine();
                exceptionCaught = true;
            }
        } while (exceptionCaught);

        System.out.println("Введите исходный процент инфляции ");
        do {
            exceptionCaught = false;
            try {
                inflation = input.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Вам разрешено ввести только дробное число. Повторите попытку.");
                input.nextLine();
                exceptionCaught = true;
            } catch (NoSuchElementException e) {
                System.out.println("Вы ничего не ввели. Выход из программы.");
                input.nextLine();
                exceptionCaught = true;
            } catch (IllegalStateException e) {
                System.out.println("Система ввода оказалась в некорректном состоянии. Повторите попытку.");
                input = new Scanner(System.in);
                input.nextLine();
                exceptionCaught = true;
            }
        } while (exceptionCaught);
        inflation += percent;

        System.out.println("Введите количество месяцев ");
        do {
            exceptionCaught = false;
            try {
                numberOfMonths = input.nextInt();
                if (numberOfMonths < 1) {
                    System.out.println("Количество месяцев не может быть меньше 1. Повторите попытку.");
                    exceptionCaught = true;
                } else {
                    input.nextLine();
                }
            } catch (InputMismatchException e) {
                System.out.println("Вам разрешено ввести только целое число. Повторите попытку.");
                input.nextLine();
                exceptionCaught = true;
            } catch (NoSuchElementException e) {
                System.out.println("Вы ничего не ввели. Выход из программы.");
                input.nextLine();
                exceptionCaught = true;
            } catch (IllegalStateException e) {
                System.out.println("Система ввода оказалась в некорректном состоянии. Повторите попытку.");
                input = new Scanner(System.in);
                input.nextLine();
                exceptionCaught = true;
            }
        } while (exceptionCaught);

        System.out.println("Теперь вводите изменения инфляции за эти месяцы по одному в строке");
        for (int currMonth = 0; currMonth < numberOfMonths; currMonth++) {
            double inflationChange = 0;

            do {
                exceptionCaught = false;
                try {
                    inflationChange = input.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.println("Вам разрешено ввести только дробное число. Повторите попытку.");
                    input.nextLine();
                    exceptionCaught = true;
                } catch (NoSuchElementException e) {
                    System.out.println("Вы ничего не ввели. Выход из программы.");
                    input.nextLine();
                    exceptionCaught = true;
                } catch (IllegalStateException e) {
                    System.out.println("Система ввода оказалась в некорректном состоянии. Повторите попытку.");
                    input = new Scanner(System.in);
                    input.nextLine();
                    exceptionCaught = true;
                }
            } while (exceptionCaught);
            inflation += inflationChange;
            price = price * inflation / percent;
            if (price <= 0) {
                System.err.println("Обвал экономики. Сваливаем с этой планеты.");
                System.exit(1);
            }
        }

        System.out.println(String.format(Locale.PRC, "%.2f", price));

        input.close();
    }
}
