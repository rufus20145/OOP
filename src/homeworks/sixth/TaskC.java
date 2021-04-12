package src.homeworks.sixth;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.TreeSet;

public class TaskC {
    public static void main(String[] args) {

        ArrayList<Double> inputArray = new ArrayList<>();
        double sum = 0;
        Scanner input = new Scanner(System.in);
        boolean exceptionCaught = false;

        System.out.println("Введите положительные числа, а затем 0, чтобы завершить ввод.");
        do {
            exceptionCaught = false;
            try {
                double tempNum = input.nextDouble();
                if (tempNum < 0) {
                    System.out.println("Разрешен ввод только положительных чисел. Повторите попытку.");
                    exceptionCaught = true;
                } else if (tempNum == 0) {
                    break;
                } else {
                    sum += tempNum;
                    inputArray.add(tempNum);
                    exceptionCaught = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Разрешен ввод только целых чисел. Повторите попытку.");
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
        System.out.println("Ввод завершён. Начинаю обработку.\n\nВот результат:");

        if (!inputArray.isEmpty()) {
            double avg = sum / inputArray.size();

            TreeSet<Double> result = new TreeSet<>();
            for (Double number : inputArray) {
                if (number > avg) {
                    result.add(number);
                }
            }

            for (Double number : result) {
                if (number == Math.round(number)) {
                    System.out.println(Math.round(number));
                } else {
                    System.out.println(number);
                }
            }
        } else { // inputArray is empty
            System.out.println("Введенная коллекция пуста.");
        }

        input.close();
    }
}
