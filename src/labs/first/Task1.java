package labs.first;

/**
 * Ввести n строк с консоли. Вывести на консоль те строки, длина которых меньше средней, также их длины.
 */

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        int numberOfStrings = -1;
        float averageLength = 0;
        String[] strings;
        int[] lengthsOfStrings;
        Scanner input;

        // считываем количество строк
        input = new Scanner(System.in);
        System.out.println("Enter number of strings: ");
        do {
            try {
                numberOfStrings = input.nextInt();
                if (numberOfStrings < 1) {
                    System.out.println("Number of strings must be greater than zero");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("You entered wrong value. Try again.");
                input.nextLine();
            }
        } while (numberOfStrings < 1);

        // выделяем память под строки и их длины
        strings = new String[numberOfStrings];
        lengthsOfStrings = new int[numberOfStrings];

        // теперь вводим эти строки
        System.out.println("Now enter " + numberOfStrings + " strings");
        input.nextLine();
        for (int currString = 0; currString < numberOfStrings; currString++) {
            strings[currString] = input.nextLine();
        }
        input.close();
        System.out.println("");

        // считаем длины строк
        for (int currString = 0; currString < numberOfStrings; currString++) {
            lengthsOfStrings[currString] = strings[currString].length();
        }

        // считаем среднюю длину строки
        for (int currString = 0; currString < numberOfStrings; currString++) {
            averageLength += lengthsOfStrings[currString];
        }
        averageLength /= numberOfStrings;

        // выводим необходимые строки в консоль
        for (int currString = 0; currString < numberOfStrings; currString++) {
            if (lengthsOfStrings[currString] < averageLength) {
                System.out.println(strings[currString] + " - length is " + lengthsOfStrings[currString]);
            }
        }
    }
}