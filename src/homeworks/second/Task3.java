package src.homeworks.second;

/**
 * Вводится строка из произвольных символов. Необходимо вывести на консоль
 * среднюю кодовых значений всех символов строки (сумма всех кодовых значений
 * символов / кол-во символов).
 */

import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {
        String inputString = null;
        float sumOfDigits = 0;
        Scanner input = new Scanner(System.in);
        boolean exceptionCaught = false;

        input.close();

        do {
            try {
                inputString = input.nextLine();
            } catch (java.util.NoSuchElementException e) {
                System.out.println("You didn't enter any text. Try again.");
                input.nextLine();
                exceptionCaught = true;
            } catch (java.lang.IllegalStateException e) {
                System.out.println("Something went wrong. Try again.");
                exceptionCaught = true;
                break;
            }
        } while (exceptionCaught);
        input.close();

        for (char digit : inputString.toCharArray()) {
            sumOfDigits += (int) digit;
        }

        System.out.println(sumOfDigits / inputString.length());
    }
}
