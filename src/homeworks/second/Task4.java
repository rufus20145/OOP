package src.homeworks.second;

/**
 * В консоль вводятся три числа с обязательной дробной частью. Необходимо найти
 * и вывести на консоль в следующем порядке: 
 * 1) Сумму введённых чисел
 * 2) Сумму введённых чисел без учёта дробной части
 * 3) Разницу первой и второй найденных сумм
 */

import java.util.Scanner;

public class Task4 {

    public static void main(String[] args) {

        final int numberOfDigits = 3;

        Scanner input = new Scanner(System.in);
        float digit = 0;
        float firstSum = 0;
        int secondSum = 0;
        boolean exceptionCaught = false;

        System.out.println("Enter " + numberOfDigits + " numbers.");
        for (int i = 0; i < numberOfDigits; i++) {
            do {
                try {
                    digit = input.nextFloat();
                    exceptionCaught = false;
                } catch (java.util.InputMismatchException e) {
                    System.out.println("You must enter a valid float value. Try again.");
                    exceptionCaught = true;
                    input.nextLine();
                } catch (java.util.NoSuchElementException e) {
                    System.out.println("You didn't enter any text. Try again.");
                    exceptionCaught = true;
                    input.nextLine();
                } catch (java.lang.IllegalStateException e) {
                    System.out.println("Scanner was closed before input. Try again.");
                    input.nextLine();
                    exceptionCaught = true;
                }
            } while (exceptionCaught);
            firstSum += digit;
            secondSum += (int) digit;
        }
        System.out.println(firstSum);
        System.out.println((float) secondSum);
        System.out.println(firstSum - secondSum);
    }
}
