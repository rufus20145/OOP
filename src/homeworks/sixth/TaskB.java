package src.homeworks.sixth;

import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        final String NoSuchElementExceptionErrorMessage = "Вы ничего не ввели. Выход из программы.";
        final String IllegalStateExceptionErrorMessage = "Система ввода оказалась в некорректном состоянии. Повторите попытку.";

        HashMap<Integer, String> stringRestorer = new HashMap<>();

        String scannedString = null;
        String[] splitStrings;
        StringBuilder output = new StringBuilder();
        Scanner input = new Scanner(System.in);
        boolean exceptionCaught = false;

        System.out.println("Введите первую строку ");
        do {
            exceptionCaught = false;
            try {
                scannedString = input.nextLine();
            } catch (NoSuchElementException e) {
                System.out.println(NoSuchElementExceptionErrorMessage);
                input.nextLine();
                exceptionCaught = true;
            } catch (IllegalStateException e) {
                System.out.println(IllegalStateExceptionErrorMessage);
                input = new Scanner(System.in);
                input.nextLine();
                exceptionCaught = true;
            }
        } while (exceptionCaught);

        splitStrings = scannedString.split(";");
        for (String string : splitStrings) {

            String[] smallBuffer = string.split(":");
            stringRestorer.put(Integer.parseInt(smallBuffer[1]), smallBuffer[0]);
            // System.out.println("Value:" + smallBuffer[0] + " Key: " + smallBuffer[1]);
        }

        System.out.println("Введите вторую строку ");
        do {
            exceptionCaught = false;
            try {
                scannedString = input.nextLine();
            } catch (NoSuchElementException e) {
                System.out.println(NoSuchElementExceptionErrorMessage);
                input.nextLine();
                exceptionCaught = true;
            } catch (IllegalStateException e) {
                System.out.println(IllegalStateExceptionErrorMessage);
                input = new Scanner(System.in);
                input.nextLine();
                exceptionCaught = true;
            }
        } while (exceptionCaught);

        splitStrings = scannedString.split("-");
        for (String string : splitStrings) {
            if (stringRestorer.containsKey(Integer.parseInt(string))) {
                output.append(stringRestorer.get(Integer.parseInt(string)));
            }
            else {
                output.append("_");
            }
        }
        System.out.println(output.toString());
        input.close();
    }
}
