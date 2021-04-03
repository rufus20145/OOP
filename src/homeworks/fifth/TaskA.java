// package src.homeworks.fifth;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {

        boolean exceptionCaught = false;
        Scanner input = new Scanner(System.in);
        int numberOfNumbers = 0;
        String inputString = null;
        String inputStringFormatRegex = "(x: ?-?\\d+(\\.\\d+)?(; ?p: ?\\d+(\\.\\d+)?)?$)|"
                + "(p: ?\\d+(\\.\\d+)?; ?x: ?-?\\d+(\\.\\d+)?$)";
        // регулярка тут: https://regex101.com/r/8sx6pE/9
        String firstXSecondPRegex = "^x: ?-?\\d+(\\.\\d+)?(; ?p: ?\\d+(\\.\\d+)?)$";
        String firstPSecondXRegex = "^p: ?\\d+(\\.\\d+)?; ?x: ?-?\\d+(\\.\\d+)?$";
        String onlyXRegex = "^x: ?-?\\d+(\\.\\d+)?$";
        double[] numbers;
        double[] weights;
        double sum = 0;
        double totalWeight = 0;

        System.out.println("Введите количество значений");
        do {
            exceptionCaught = false;
            try {
                numberOfNumbers = input.nextInt();
                if (numberOfNumbers < 1) {
                    System.out.println("Количество элементов не может быть меньше 1. Повторите попытку.");
                    exceptionCaught = true;
                } else {
                    input.nextLine();
                }
            } catch (InputMismatchException e) {
                System.out.println("Вам разрешено ввести только целое число. Повторите попытку.");
                input.nextLine();
                exceptionCaught = true;
            } catch (NoSuchElementException e) {
                System.out.println("Вы ничего не ввели. Выход из программы.");
                input.nextLine();
                exceptionCaught = true;
            } catch (IllegalStateException e) {
                System.out.println("Система ввода оказалась в некорректном состоянии. Повторите попытку.");
                input = new Scanner(System.in);
                input.nextLine();
                exceptionCaught = true;
            }
        } while (exceptionCaught);

        numbers = new double[numberOfNumbers];
        weights = new double[numberOfNumbers];

        System.out.println("Теперь введите значения ");
        for (int currentNumber = 0; currentNumber < numberOfNumbers; currentNumber++) {
            do {
                exceptionCaught = false;
                try {
                    inputString = input.nextLine();
                    if (!inputString.matches(inputStringFormatRegex)) {
                        System.out.println("Строка не соответствует формату ввода. Повторите попытку.");
                        exceptionCaught = true;
                    }
                } catch (NoSuchElementException e) {
                    System.out.println("Вы ничего не ввели. Выход из программы.");
                    input.nextLine();
                    exceptionCaught = true;
                } catch (IllegalStateException e) {
                    System.out.println("Система ввода оказалась в некорректном состоянии. Повторите попытку.");
                    input = new Scanner(System.in);
                    input.nextLine();
                    exceptionCaught = true;
                }
            } while (exceptionCaught);

            if (inputString.matches(firstXSecondPRegex)) {
                String[] splitStrings = inputString.replaceAll("[xp :]", "").split(";");
                numbers[currentNumber] = Double.parseDouble(splitStrings[0]);
                weights[currentNumber] = Double.parseDouble(splitStrings[1]);
            } else if (inputString.matches(firstPSecondXRegex)) {
                String[] splitStrings = inputString.replaceAll("[xp :]", "").split(";");
                weights[currentNumber] = Double.parseDouble(splitStrings[0]);
                numbers[currentNumber] = Double.parseDouble(splitStrings[1]);
            } else if (inputString.matches(onlyXRegex)) {
                inputString = inputString.replaceAll("[x: ]", "");
                numbers[currentNumber] = Double.parseDouble(inputString);
                weights[currentNumber] = 1;
            }

            sum += numbers[currentNumber] * weights[currentNumber];
            totalWeight += weights[currentNumber];
        }
        if (totalWeight != 0) {
            System.out.println(String.format(Locale.PRC, "%.3f", sum / totalWeight));
        } else {
            System.out.println("Сумма весов чисел равна нулю. Деление невозможно.");
        }
        input.close();
    }
}
