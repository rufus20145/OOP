package src.homeworks.second;

/**
 * В консоли вводятся десять чисел от 0 до 9 включительно (каждое число вводится на отдельной строке).
 * К каждому числу необходимо прибавить значение 65, затем их необходимо привести к символьному типу
 * и объединить все символы в одну строку в той же последовательности, как они были введены в консоли.
 * Сформированную строку вывести в консоль.
 */

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {

        final int addition = 65;
        final int amountOfNumbers = 10;
        int[] numbers = new int[amountOfNumbers];
        StringBuilder sb = new StringBuilder();

        Scanner input = new Scanner(System.in);

        System.out.println("Please enter " + amountOfNumbers + " numbers");
        for (int i = 0; i < amountOfNumbers; i++) {

            boolean exceptionCaught = false;

            do {

                try {
                    numbers[i] = input.nextInt();
                    exceptionCaught = false;
                    if (numbers[i] > 9) {
                        System.out.println("Entered value is too big. Try again.");
                        exceptionCaught = true;
                    }
                    if (numbers[i] < 0) {
                        System.out.println("Entered value is too low. Try again.");
                        exceptionCaught = true;
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println("\tYou didn't enter any text. Try again.");
                    exceptionCaught = true;
                } catch (java.util.NoSuchElementException e) {
                    System.out.println("Something went wrong. Try again.");
                    exceptionCaught = true;
                } finally {
                    input.nextLine();
                }
            } while (exceptionCaught);

            numbers[i] += addition;
            sb.append((char) numbers[i]);
        }
        System.out.println(sb.toString());
        input.close();
    }
}
