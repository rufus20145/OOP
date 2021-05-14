package homeworks.sixth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TaskD {
    public static void main(String[] args) {
        final String noSuchElementExceptionErrorMessage = "Вы ничего не ввели. Выход из программы.";
        final String illegalStateExceptionErrorMessage = "Система ввода оказалась в некорректном состоянии. Повторите попытку.";

        final String emailRegex = "(?=(.{1,64}@))(?=(.{7,255}$))((([a-zA-Z0-9_а-яА-ЯёЁ]+)(\\+[a-zA-Z0-9_а-яА-ЯёЁ\\-_]+)?)@(([a-zA-Z0-9а-яА-ЯёЁ][a-zA-Z0-9_а-яА-ЯёЁ\\-_]*\\.)+([a-zA-Zа-яА-ЯёЁ0-9]{2,})|(((25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9])\\.){3}(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9]))))";
        final String inputStringRegex = "^" + emailRegex + ":" + emailRegex + "$";
        final String endSwitchString = "END";

        HashMap<String, String> pairs = new HashMap<>();

        Scanner input = new Scanner(System.in);
        boolean exceptionCaught = false;
        boolean isInLoop = true;

        do {
            String scannedLine = null;

            do {
                exceptionCaught = false;
                try {
                    scannedLine = input.nextLine();
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

            if (scannedLine.equals(endSwitchString)) {
                System.out.println("Переход к обработке данных.");
                isInLoop = false;
            } else if (scannedLine.matches(inputStringRegex)) {
                String[] splitStrings = scannedLine.split(":");
                if (pairs.containsKey(splitStrings[0])) {
                    System.out.println("В двух разных строках обнаружен одинаковый отправитель. "
                            + "Текущая строка отброшена (да, я знаю, что HashMap и так умеет в дедупликацию). ");
                } else if (pairs.containsValue(splitStrings[1])) {
                    System.out.println("В двух разных строках обнаружен одинаковый получатель."
                            + "Текущая строка отброшена (да, я знаю, что HashMap и так умеет в дедупликацию). ");
                } else {
                    pairs.put(splitStrings[0], splitStrings[1]);
                }
            } else {
                System.out.println("Неизвестный формат строки. Повторите попытку ввода");
            }
        } while (isInLoop);

        ArrayList<String> firstSenders = new ArrayList<>();
        // ищем всех первых отправителей
        for (String string : pairs.keySet()) {
            if (!pairs.containsValue(string)) {
                firstSenders.add(string);
            }
        }

        // теперь по очереди берем каждого из списка первых отправителей и просматриваем
        // цепочку от него пока почта получателя есть в отправителях
        for (String string : firstSenders) {
            StringBuilder output = new StringBuilder(string);

            do {
                string = pairs.get(string);
                output.append(" > ").append(string);
            } while (pairs.containsKey(string));

            System.out.println(output.toString());
        }

        input.close();
    }
}
