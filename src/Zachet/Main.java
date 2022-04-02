package src.Zachet;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final double FIRST_CONSTANT = 1000; // верхнее ограничение для генерируемых чисел
    private static final double SECOND_CONSTANT = -1000; // смещение, чтобы числа были в том числе и отрицательными

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int matrixSize;
        int[][] matrix;

        System.out.println("Введите размер генерируемой матрицы");
        matrixSize = in.nextInt();
        matrix = new int[matrixSize][matrixSize];

        fillMatrix(matrix, matrixSize);

        int minDiagElement = findMinDiagElement(matrix);
        System.out.println("Минимальный элемент = " + minDiagElement);

        int[][] newMatrix = removeRowsWithElement(matrix, minDiagElement);

        System.out.println("Исходная матрица:");
        printMatrix(matrix);

        System.out.println("Полученная матрица");
        printMatrix(newMatrix);

        in.close();
    }

    private static void fillMatrix(int[][] matrix, int matrixSize) {
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = (int) Math.round(FIRST_CONSTANT * Math.random() + SECOND_CONSTANT);
            }
        }
    }

    private static int findMinDiagElement(int[][] matrix) {
        int minElement = matrix[0][0];  
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][i] < minElement) {
                minElement = matrix[i][i];
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][matrix.length - i - 1] < minElement) {
                minElement = matrix[i][matrix.length - i - 1];
            }
        }

        return minElement;
    }

    private static int[][] removeRowsWithElement(int[][] matrix, int minDiagElement) {
        boolean[] rowsToCopy = new boolean[matrix.length];
        int[][] newMatrix;
        int newNumberOfRows = matrix.length;
        int currNewRow;

        for (int i = 0; i < rowsToCopy.length; i++) {
            rowsToCopy[i] = true;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == minDiagElement) {
                    rowsToCopy[i] = false;
                    newNumberOfRows--;
                }
            }
        }

        currNewRow = 0;
        newMatrix = new int[newNumberOfRows][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            if (rowsToCopy[i]) {
                newMatrix[currNewRow++] = Arrays.copyOf(matrix[i], matrix[i].length);
            }
        }

        return newMatrix;
    }

    private static void printMatrix(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sb.append(String.format("%5d", matrix[i][j]));
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
