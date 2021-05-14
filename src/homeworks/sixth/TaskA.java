package homeworks.sixth;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        final String noSuchElementExceptionErrorMessage = "Вы ничего не ввели. Выход из программы.";
        final String illegalStateExceptionErrorMessage = "Система ввода оказалась в некорректном состоянии. Повторите попытку.";

        final String numberRegex = "^-?\\d+$";
        final String streamRegex = "^STREAM [123]$";
        final String firstCollectionSwitch = "STREAM 1";
        final String secondCollectionSwitch = "STREAM 2";
        final String thirdCollectionSwitch = "STREAM 3";
        final String endSwitch = "END";

        final int firstStreamNumber = 1;
        final int secondStreamNumber = 2;
        final int thirdStreamNumber = 3;

        ArrayList<Integer> firstList = new ArrayList<>();
        ArrayList<Integer> secondList = new ArrayList<>();
        ArrayList<Integer> thirdList = new ArrayList<>();
        int currentStream = firstStreamNumber;
        Scanner input = new Scanner(System.in);
        StringBuilder output = new StringBuilder();
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

            if (scannedLine.matches(streamRegex) || scannedLine.matches(endSwitch)) {
                switch (scannedLine) {
                    case firstCollectionSwitch: 
                        // System.out.println("Выбран 1 поток.");
                        currentStream = firstStreamNumber;
                        break;
                    
                    case secondCollectionSwitch: 
                        // System.out.println("Выбран 2 поток.");
                        currentStream = secondStreamNumber;
                        break;
                    
                    case thirdCollectionSwitch: 
                        // System.out.println("Выбран 3 поток.");
                        currentStream = thirdStreamNumber;
                        break;
                    
                    case endSwitch: 
                        // System.out.println("Выход из программы");
                        isInLoop = false;
                        break;
                    
                    default: 
                        // System.out.println("Неправильный номер потока. Их всего 3. Номер не был
                        // изменен.");
                        break;
                    
                }
            } else if (scannedLine.matches(numberRegex)) {

                switch (currentStream) {
                    case firstStreamNumber: 
                        // System.out.println("Добавлено в 1 поток");

                        firstList.add(Integer.valueOf(scannedLine));
                        break;
                    
                    case secondStreamNumber: 
                        // System.out.println("Добавлено в 2 поток");

                        secondList.add(Integer.valueOf(scannedLine));
                        break;
                    
                    case thirdStreamNumber: 
                        // System.out.println("Добавлено в 3 поток");

                        thirdList.add(Integer.valueOf(scannedLine));
                        break;
                    
                    default: 
                        // System.out.println("Неизвестный поток");
                        break;
                    

                }
            } else {
                System.out.println("Ввод не соответствует формату.");
            }
        } while (isInLoop);

        int maxNumberOfElements = Math.max(firstList.size(), Math.max(secondList.size(), thirdList.size()));

        if (maxNumberOfElements == 0) {
            System.out.println("Коллекции пусты.");
        } else {
            for (int i = 0; i < maxNumberOfElements; i++) {

                int numberForPrint = 0;

                if (i < firstList.size()) {
                    // System.out.println("Добавили элемент из 1 списка");
                    numberForPrint += firstList.get(i);
                }
                if (i < secondList.size()) {
                    // System.out.println("Добавили элемент из 2 списка");
                    numberForPrint += secondList.get(i);
                }
                if (i < thirdList.size()) {
                    // System.out.println("Добавили элемент из 3 списка");
                    numberForPrint += thirdList.get(i);
                }

                output.append(numberForPrint).append(" ");

            }

            System.out.println(output.toString());
        }

        input.close();
    }
}
