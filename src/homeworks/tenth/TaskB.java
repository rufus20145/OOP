package src.homeworks.tenth;

import java.util.Scanner;

public class TaskB {
    private static final int DECIMAL_CONSTANT = 10;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        printTable(in.nextInt());
        in.close();
    }

    private static void printTable(int n) {
        int[][] table = new int[n][n];
        int x = 0;
        int y = 0;
        int moveHorizontal = 0;
        int moveVertical = 1;
        for (int i = 1; i <= n * n; i++) {
            table[x][y] = i;
            if ((y + moveVertical >= n) || (y + moveVertical < 0) || (x + moveHorizontal >= n)
                    || (x + moveHorizontal < 0) || table[x + moveHorizontal][y + moveVertical] != 0) {
                int temp = moveVertical;
                moveVertical = -moveHorizontal;
                moveHorizontal = temp;
            }
            x += moveHorizontal;
            y += moveVertical;
        }

        int maxAmountOfDigits = 0;
        int maxNumber = n * n;
        while (maxNumber > 0) {
            ++maxAmountOfDigits;
            maxNumber /= DECIMAL_CONSTANT;
        }
        maxAmountOfDigits++;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                int tmp = table[i][j];
                int numberOfDigits = 0;
                while (tmp > 0) {
                    ++numberOfDigits;
                    tmp /= DECIMAL_CONSTANT;
                }
                sb.append(table[i][j]);
                for (; numberOfDigits < maxAmountOfDigits; numberOfDigits++) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
