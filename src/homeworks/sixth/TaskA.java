package src.homeworks.sixth;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        final String NoSuchElementExceptionErrorMessage = "Вы ничего не ввели. Выход из программы.";
        final String IllegalStateExceptionErrorMessage = "Система ввода оказалась в некорректном состоянии. Повторите попытку.";

        final String numberRegex = "^-?\\d+$";
        final String streamRegex = "^STREAM \\d$";
        final String firstCollectionSwitch = "STREAM 1";
        final String secondCollectionSwitch = "STREAM 2";
        final String thirdCollectionSwitch = "STREAM 3";
        final String endSwitch = "END";

        ArrayList<Integer> firstList = new ArrayList<>();
        ArrayList<Integer> secondList = new ArrayList<>();
        ArrayList<Integer> thirdList = new ArrayList<>();
        int[] resultArray;
        int currentStream = 1;
        int maxNumberOfElements = 0;
        Scanner input = new Scanner(System.in);
        StringBuilder output = new StringBuilder();
        boolean exceptionCaught = false;
        boolean isInLoop = true;
        boolean isFirstIteration = true;

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

            // данный блок не должен выполняться сразу после запуска, значения идут в
            // первую коллекцию
            if (!isFirstIteration && scannedLine.matches(streamRegex) || scannedLine.matches(endSwitch)) {

                switch (scannedLine) {
                case firstCollectionSwitch: {
                    // System.out.println("Выбран 1 поток.");
                    currentStream = 1;
                    break;
                }
                case secondCollectionSwitch: {
                    // System.out.println("Выбран 2 поток.");
                    currentStream = 2;
                    break;
                }
                case thirdCollectionSwitch: {
                    // System.out.println("Выбран 3 поток.");
                    currentStream = 3;
                    break;
                }
                case endSwitch: {
                    // System.out.println("Выход из программы");
                    isInLoop = false;
                    break;
                }
                default: {
                    // System.out.println("Неправильный номер потока. Их всего 3. Номер не был
                    // изменен.");
                    break;
                }
                }
            } else if (scannedLine.matches(numberRegex)) {

                switch (currentStream) {
                case 1: {
                    // System.out.println("Добавлено в 1 поток");

                    firstList.add(Integer.parseInt(scannedLine));
                    break;
                }
                case 2: {
                    // System.out.println("Добавлено в 2 поток");

                    secondList.add(Integer.parseInt(scannedLine));
                    break;
                }
                case 3: {
                    // System.out.println("Добавлено в 3 поток");

                    thirdList.add(Integer.parseInt(scannedLine));
                    break;
                }

                default: {
                    // System.out.println("Неизвестный поток");
                    break;
                }

                }
            } else {
                // System.out.println("Ввод не соответствует формату.");
            }
            isFirstIteration = false;
        } while (isInLoop);

        maxNumberOfElements = Math.max(firstList.size(), Math.max(secondList.size(), thirdList.size()));

        if (maxNumberOfElements == 0) {
            System.out.println("Коллекции пусты.");
        } else {
            resultArray = new int[maxNumberOfElements];
            for (int i = 0; i < maxNumberOfElements; i++) {

                if (i < firstList.size()) {
                    // System.out.println("Добавили элемент из 1 списка");
                    resultArray[i] += firstList.get(i);
                }
                if (i < secondList.size()) {
                    // System.out.println("Добавили элемент из 2 списка");
                    resultArray[i] += secondList.get(i);
                }
                if (i < thirdList.size()) {
                    // System.out.println("Добавили элемент из 3 списка");
                    resultArray[i] += thirdList.get(i);
                }

                output.append(resultArray[i]).append(" ");

            }

            System.out.println(output.toString());
        }

        input.close();
    }
}
