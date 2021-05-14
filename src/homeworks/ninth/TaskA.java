package src.homeworks.ninth;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TaskA {
    private static final String INTEGER_REGEX = "^\\d+$";

    public static void main(String[] args) {
        ArrayList<Integer> tempPrices = new ArrayList<>();
        int[] prices;
        int maxNumberOfSales;
        String scannedLine;
        Scanner input = new Scanner(System.in);

        do {
            scannedLine = getStringValue(input);
            if (scannedLine.matches(INTEGER_REGEX)) {
                tempPrices.add(Integer.valueOf(scannedLine));
            }
        } while (!scannedLine.equals("END"));

        prices = new int[tempPrices.size()];
        for (int i = 0; i < tempPrices.size(); i++) {
            prices[i] = tempPrices.get(i);
        }

        maxNumberOfSales = getIntValue(input);

        System.out.println(getMaxProfit(prices, maxNumberOfSales));

    }

    public static int getMaxProfit(int[] prices, int maxNumberOfSales) {
        int numberOfDays = prices.length;
        
        return calcTheProfit(prices, 0, 1);
    }

    private static int calcTheProfit(int[] prices, int firstDay, int lastDay) {
        if (lastDay < prices.length) {
            int currentProfit = prices[lastDay] - prices[firstDay];
            int nextProfit = calcTheProfit(prices, firstDay, lastDay + 1);
            return (currentProfit > nextProfit) ? currentProfit : nextProfit;
        } else {
            return -1;
        }
    }

    private static int getIntValue(Scanner input) {
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
        return value;
    }

    private static String getStringValue(Scanner input) {
        boolean exceptionCaught = false;
        String inputString = null;

        do {
            exceptionCaught = false;
            try {
                inputString = input.nextLine();
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
        return inputString;
    }
}
