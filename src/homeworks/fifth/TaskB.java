package src.homeworks.fifth;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {

        int amountOfNumbers = 0;
        Scanner input = new Scanner(System.in);
        double[] numbers;
        double sum = 0;
        double average;
        boolean exceptionCaught = false;

        System.out.println("Введите количество значений");
        do {
            exceptionCaught = false;
            try {
                amountOfNumbers = input.nextInt();
                if (amountOfNumbers < 1) {
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

        numbers = new double[amountOfNumbers];

        for (int currentNumber = 0; currentNumber < amountOfNumbers; currentNumber++) {
            do {
                exceptionCaught = false;
                try {
                    numbers[currentNumber] = input.nextDouble();
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

            sum += numbers[currentNumber];
        }

        average = sum / amountOfNumbers;
        sum = 0;

        for (double number : numbers) {
            sum += Math.pow((number - average), 2);
        }

        System.out.println(String.format("%.3f", Math.sqrt(sum / amountOfNumbers)));

        input.close();
    }

}
