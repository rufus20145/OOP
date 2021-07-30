package src.homeworks.fourth.task_a;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    private static Scanner input = new Scanner(System.in);
    private static final String STRING_FORMAT_REGEX = "^\\(-?\\d+\\,\\ ?-?\\d+\\,\\ ?-?\\d+\\)$";

    public static void main(String[] args) {

        int numberOfDots = 0;
        Dot[] dots;
        Dot minDot;
        double minSum = 0;
        System.out.println("Введите количество точек: ");
        numberOfDots = getIntValue();
        if (numberOfDots > 0) {
            dots = new Dot[numberOfDots];

            for (int currDot = 0; currDot < numberOfDots; ++currDot) {
                String lineToParse = getStringValue(STRING_FORMAT_REGEX);

                dots[currDot] = new Dot();

                lineToParse = lineToParse.replace("(", "").replace(")", "").replace(" ", "");
                String[] splitStrings = lineToParse.split(",");

                int numberOfDimension = 1;
                for (String string : splitStrings) {
                    dots[currDot].setCoordinate(Double.parseDouble(string), numberOfDimension);
                    ++numberOfDimension;
                }
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

            System.out.println(minDot.getCoordinates() + String.format("%.2f", minSum));

        } else {
            System.out.println("Количество точек меньше 1.");
        }
        input.close();
    }

    private static void getStringValue() {
        getStringValue(null);
    }

    private static String getStringValue(String stringFormatRegex) {
        boolean exceptionCaught = false;
        String string = null;
        do {
            try {
                string = input.nextLine();
                if (stringFormatRegex != null && !string.matches(stringFormatRegex)) {
                    System.out
                            .println("Строка должна соответствовать формату (1,2,3) или (1, 2, 3). Повторите попытку");
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
            }
        } while (exceptionCaught);
        return string;
    }

    private static int getIntValue() {
        int value = 0;
        boolean exceptionCaught = false;

        do {
            exceptionCaught = false;
            try {
                value = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Введенное значение не является целым числом. Повторите попытку.");
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
        getStringValue();
        return value;
    }
}
