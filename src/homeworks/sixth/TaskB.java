package homeworks.sixth;

import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        final String noSuchElementExceptionErrorMessage = "Вы ничего не ввели. Выход из программы.";
        final String illegalStateExceptionErrorMessage = "Система ввода оказалась в некорректном состоянии. Повторите попытку.";

        HashMap<Integer, String> stringRestorer = new HashMap<>();

        String scannedString = null;
        Scanner input = new Scanner(System.in);
        boolean exceptionCaught = false;

        System.out.println("Введите первую строку ");
        do {
            exceptionCaught = false;
            try {
                scannedString = input.nextLine();
            } catch (NoSuchElementException e) {
                System.out.println(noSuchElementExceptionErrorMessage);
                input.nextLine();
                exceptionCaught = true;
            } catch (IllegalStateException e) {
                System.out.println(illegalStateExceptionErrorMessage);
                input = new Scanner(System.in);
                input.nextLine();
                exceptionCaught = true;
            }
        } while (exceptionCaught);

        String[] splitStrings = scannedString.split(";");
        for (String string : splitStrings) {
            String[] smallBuffer = string.split(":");
            stringRestorer.put(Integer.valueOf(smallBuffer[1]), smallBuffer[0]);
            // System.out.println("Value:" + smallBuffer[0] + " Key: " + smallBuffer[1]);
        }

        System.out.println("Введите вторую строку ");
        do {
            exceptionCaught = false;
            try {
                scannedString = input.nextLine();
            } catch (NoSuchElementException e) {
                System.out.println(noSuchElementExceptionErrorMessage);
                input.nextLine();
                exceptionCaught = true;
            } catch (IllegalStateException e) {
                System.out.println(illegalStateExceptionErrorMessage);
                input = new Scanner(System.in);
                input.nextLine();
                exceptionCaught = true;
            }
        } while (exceptionCaught);

        StringBuilder output = new StringBuilder();
        splitStrings = scannedString.split("-");
        for (String string : splitStrings) {
            output.append(stringRestorer.getOrDefault(Integer.valueOf(string), "_"));
        }
        System.out.println(output.toString());
        input.close();
    }
}
