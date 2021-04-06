package src.homeworks.sixth;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        final String NoSuchElementExceptionErrorMessage = "Вы ничего не ввели. Выход из программы.";
        final String IllegalStateExceptionErrorMessage = "Система ввода оказалась в некорректном состоянии. Повторите попытку.";

        final String firstCollectionRegex = "^STREAM 1$";
        final String secondCollectionRegex = "^STREAM 2$";
        final String thirdCollectionRegex = "^STREAM 3$";
        final String endRegex = "^END$";

        ArrayList<Integer> firstList = new ArrayList<>();
        ArrayList<Integer> secondList = new ArrayList<>();
        ArrayList<Integer> thirdList = new ArrayList<>();
        ArrayList<Integer> resultList = new ArrayList<>();
        int currentStream = 1;
        Scanner input = new Scanner(System.in);
        boolean exceptionCaught = false;
        boolean isInLoop = true;

        do {
            String inputLine = null;

            switch (currentStream) {
            case 1: {
                do {
                    exceptionCaught = false;
                    try {
                        inputLine = input.nextLine();
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
                
                break;
            }
            case 2: {
                System.out.println("2");
                break;
            }
            case 3: {
                System.out.println("3");
                break;
            }

            default: {
                System.out.println("Default");
                break;
            }

            }
        } while (isInLoop);
    }
}
