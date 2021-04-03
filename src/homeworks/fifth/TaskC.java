package src.homeworks.fifth;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        int number = 0;
        double searchableNumber;
        Scanner input = new Scanner(System.in);
        boolean exceptionCaught = false;

        do {
            exceptionCaught = false;
            try {
                number = input.nextInt();
                if (number < 1) {
                    System.out.println("Количество элементов не может быть меньше 1. Повторите попытку.");
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

        searchableNumber = (Math.sqrt((double) 1 + 8 * number) - 1) / 2;

        if (searchableNumber == Math.round(searchableNumber)) {
            System.out.println(true);
            System.out.println(String.format("%d", (int) searchableNumber));
        } else {
            System.out.println(false);
        }

        input.close();
    }
}
