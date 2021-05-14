package src.homeworks.second;

/**
 * В консоль вводится строка, состоящая только их букв латинского алфавита верхнего и нижнего регистра и пробелов.
 * Необходимо сформировать новую строку, где каждая буква заменена на следующую букву в алфавите
 * с сохранением регистра (а->b, C->D). При этом последняя буква заменяется на первую, также с сохранением регистра.
 */

import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        String originalString = null;
        Scanner input = new Scanner(System.in);
        boolean exceptionCaught = false;
        StringBuilder sb = new StringBuilder();

        System.out.println("Please enter your string: ");
        do {
            try {
                originalString = input.nextLine();
                exceptionCaught = false;
            } catch (java.util.NoSuchElementException e) {
                System.out.println("You didn't enter any text. Try again.");
                input.nextLine();
                exceptionCaught = true;
            } catch (java.lang.IllegalStateException e) {
                System.out.println("Something went wrong. Try again.");
                input.nextLine();
                exceptionCaught = true; // x
            }
        } while (exceptionCaught);
        input.close();

        for (char character : originalString.toCharArray()) {
            if ('Z' == character) {
                character = 'A';
            } else if ('z' == character) {
                character = 'a';
            } else if (' ' != character) {
                ++character;
            }
            sb.append(character);
        }

        System.out.println(sb.toString());
    }
}