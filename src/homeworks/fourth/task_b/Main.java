package homeworks.fourth.task_b;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final String stringFormatRegex = "^\\(-?\\d+\\,\\ ?-?\\d+\\)$";

        int numberOfDots = 0;
        Dot[] dots;
        boolean exceptionCaught = false;
        double maxArea = 0;

        Scanner input = new Scanner(System.in);

        System.out.println("Введите количество точек: ");
        do {
            try {
                numberOfDots = input.nextInt();
                if (numberOfDots > 2) {
                    input.nextLine();
                    exceptionCaught = false;
                } else {
                    System.out.println("Минимальное количество точек - 3, т.к. необходимо построить треугольник.");
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
                        System.out.println("Строка должна соответствовать формату (1,2) или (1, 2). Повторите попытку");
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

        for (int i = 0; i < numberOfDots; i++) {
            for (int j = 0; j < numberOfDots; j++) {
                for (int k = 0; k < numberOfDots; k++) {
                    double currArea = computeAreaOfTriangle(dots[i], dots[j], dots[k]);
                    if (currArea > maxArea) {
                        maxArea = currArea;
                    }
                }
            }
        }

        System.out.println(String.format(Locale.PRC, "%.2f", maxArea));

        input.close();
    }

    /**
     * @param firstDot  координаты первой точки треугольника
     * @param secondDot координаты второй точки треугольника
     * @param thirdDot  координаты третьей точки треугольника
     * @return площадь треугольника
     */
    public static double computeAreaOfTriangle(Dot firstDot, Dot secondDot, Dot thirdDot) {

        double firstEdge = Dot.calcTheDistance(firstDot, secondDot);
        double secondEdge = Dot.calcTheDistance(secondDot, thirdDot);
        double thirdEdge = Dot.calcTheDistance(thirdDot, firstDot);

        double semiPerimeter = (firstEdge + secondEdge + thirdEdge) / 2;

        return Math.sqrt(semiPerimeter * (semiPerimeter - firstEdge) * (semiPerimeter - secondEdge)
                * Math.abs((semiPerimeter - thirdEdge)));
    }
}
