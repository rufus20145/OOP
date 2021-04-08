package src.homeworks.sixth;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MyVariantOfTaskD {
    public static void main(String[] args) {
        final String NoSuchElementExceptionErrorMessage = "Вы ничего не ввели. Выход из программы.";
        final String IllegalStateExceptionErrorMessage = "Система ввода оказалась в некорректном состоянии. Повторите попытку.";

        final String emailRegex = "(?=(.{1,64}@))(?=(.{7,255}$))((([a-zA-Z0-9_а-яА-ЯёЁ]+)(\\+[a-zA-Z0-9_а-яА-ЯёЁ\\-_]+)?)@(([a-zA-Z0-9а-яА-ЯёЁ][a-zA-Z0-9_а-яА-ЯёЁ\\-_]*\\.)+([a-zA-Zа-яА-ЯёЁ0-9]{2,})|(((25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9])\\.){3}(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9]))))";
        final String inputStringRegex = "^" + emailRegex + ":" + emailRegex + "$";
        final String endSwitchString = "END";

        ArrayList<String> senders = new ArrayList<>();
        ArrayList<String> receivers = new ArrayList<>();

        ArrayList<String> firstSenders = new ArrayList<>();
        ArrayList<String> lastReceivers = new ArrayList<>();
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

            if (scannedLine.equals(endSwitchString)) {
                System.out.println("Переход к обработке данных.");
                isInLoop = false;
            } else if (scannedLine.matches(inputStringRegex)) {
                String[] splitStrings = scannedLine.split(":");
                if (senders.contains(splitStrings[0])) {
                    System.out.println(
                            "В двух разных строках обнаружен одинаковый отправитель. Текущая строка отброшена.");
                } else {
                    senders.add(splitStrings[0]);
                }
                if (receivers.contains(splitStrings[1])) {
                    System.out.println(
                            "В двух разных строках обнаружен одинаковый получатель. Текущая строка отброшена.");
                } else {
                    receivers.add(splitStrings[1]);
                }
            } else {
                System.out.println("Неизвестный формат строки. Повторите попытку ввода");
            }
        } while (isInLoop);

        // ищем всех первых отправителей
        for (String string : senders) {
            if (!receivers.contains(string)) {
                if (firstSenders.contains(string)) {
                    System.out.println(
                            "Отправитель, которого нет в числе получателей, встретился в двух строках. Выход из программы.");
                    System.exit(1);
                } else {
                    firstSenders.add(string);
                }
            }
        }

        // ищем всех последних получателей
        for (String string : receivers) {
            if (!senders.contains(string)) {
                if (lastReceivers.contains(string)) {
                    System.out.println(
                            "Получатель, которого нет в числе отправителей, встретился в двух строках. Выход из программы.");
                    System.exit(1);
                } else {
                    lastReceivers.add(string);
                }
            }
        }

        // теперь по очереди берем каждого из первых отправителей и просматриваем
        // цепочку от него до кого-то из списка последних получателей
        for (String string : firstSenders) {
            String currMail = string;
            StringBuilder output = new StringBuilder(currMail);

            do {
                currMail = receivers.get(senders.indexOf(currMail));
                output.append(" > ").append(currMail);
            } while (!lastReceivers.contains(currMail));

            System.out.println(output.toString());
        }

        input.close();
    }
}
