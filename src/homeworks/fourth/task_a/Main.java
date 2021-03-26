package src.homeworks.fourth.task_a;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final String stringFormatRegex = "^\\(-?\\d+\\,\\ ?-?\\d+\\,\\ ?-?\\d+\\)$";

        int numberOfDots = 0;
        Dot[] dots;
        Dot minDot;
        double minSum = 0;
        boolean exceptionCaught = false;

        Scanner input = new Scanner(System.in);

        System.out.println("Введите количество точек: ");
        do {
            try {
                numberOfDots = input.nextInt();
                if (numberOfDots > 0) {
                    input.nextLine();
                    exceptionCaught = false;
                } else {
                    System.out.println("Количество точек должно быть положительным числом.");
                    exceptionCaught = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Здесь можно ввести только целое число. Повторите попытку.");
                exceptionCaught = true;
                input.nextLine();
            } catch (NoSuchElementException e) {
                System.out.println("Вы не ввели ничего. Повторите попытку.");
                exceptionCaught = true;
                input.nextLine();
            } catch (IllegalStateException e) {
                System.out.println("Система ввода оказалась в некорректном состоянии. Повторите попытку.");
                exceptionCaught = true;
                input = new Scanner(System.in);
                input.nextLine();
            }
        } while (exceptionCaught);
        dots = new Dot[numberOfDots];

        for (int currDot = 0; currDot < numberOfDots; ++currDot) {
            String lineToParse = null;
            do {
                try {
                    lineToParse = input.nextLine();
                    if (!lineToParse.matches(stringFormatRegex)) {
                        System.out.println(
                                "Строка должна соответствовать формату (1,2,3) или (1, 2, 3). Повторите попытку");
                        exceptionCaught = true;
                    } else {
                        exceptionCaught = false;
                    }
                } catch (NoSuchElementException e) {
                    System.out.println("Вы не ввели ничего. Повторите попытку.");
                    exceptionCaught = true;
                    input.nextLine();
                } catch (IllegalStateException e) {
                    System.out.println("Система ввода оказалась в некорректном состоянии. Повторите попытку.");
                    exceptionCaught = true;
                    input = new Scanner(System.in);
                    input.nextLine();
                }
                if (!exceptionCaught) {
                    dots[currDot] = new Dot();
                    int numberOfDimension = 1;

                    lineToParse = lineToParse.replace("(", "").replace(")", "").replace(" ", "");
                    String[] splitStrings = lineToParse.split("\\,");

                    for (String string : splitStrings) {
                        dots[currDot].setCoordinate(Double.parseDouble(string), numberOfDimension);
                        ++numberOfDimension;
                    }
                }
            } while (exceptionCaught);
            // System.out.println(dots[currDot].getAllInfo());//вывод всех данных точки после парсинга
        }

        minDot = dots[0];
        if (numberOfDots > 1) {
            for (int j = 0; j < dots.length; j++) {
                minSum += Dot.calcTheDistance(dots[0], dots[j]);
            }
        }
        for (int i = 1; i < dots.length; i++) {
            double currSum = 0;
            for (int j = 0; j < dots.length; j++) {
                if (i != j) {
                    currSum += Dot.calcTheDistance(dots[i], dots[j]);
                }
            }
            if (currSum < minSum) {
                minDot = dots[i];
                minSum = currSum;
            }
        }

        System.out.println(minDot.getCoordinates() + String.format(Locale.PRC, "%.2f", minSum));

        input.close();
    }
}
