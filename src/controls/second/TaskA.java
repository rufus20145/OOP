package src.controls.second;

import java.util.Scanner;

/**
 * Серия Фибоначчи - это серия элементов, в которой используются два предыдущих
 * элемента, чтобы получить следующий элемент, начиная с 0 и 1. В этой задаче
 * необходимо написать функцию, которая будет генерировать ряд Фибоначчи. Способ
 * реализации любой, главный принцип - чем быстрее тем лучше.
 */

public class TaskA {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int first = input.nextInt();
        int second = input.nextInt();

        System.out.println(makeFibboString(first, second));
        input.close();

    }

    public static String makeFibboString (int first, int second) {

        StringBuilder output = new StringBuilder();
        int previousFibboNumber = 0;
        int currentFibboNumber = 1;
        for(int i = 2; i < second; ++i) {
            int buffer = previousFibboNumber + currentFibboNumber;
            previousFibboNumber = currentFibboNumber;
            currentFibboNumber = buffer;
            if(i >= first) {
                output.append(currentFibboNumber).append(" ");
            }
        }
        return output.toString();
    }
}
