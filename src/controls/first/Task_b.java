package src.controls.first;

import java.util.Scanner;

/**
 * Выпуклый многоугольник задан на плоскости перечислением координат вершин в
 * порядке обхода его границы. Определить площадь многоугольника. Задаются
 * сначала количество точке n, далее для каждой точки вводится x, а потом y
 * координата. Площадь округлять до десятых (один разряд после запятой)
 */
public class Task_b {

    public static void main(String[] args) {
        double totalArea = 0;
        int numberOfDots;
        int[] dotsX;
        int[] dotsY;
        Scanner input = new Scanner(System.in);

        numberOfDots = input.nextInt();

        dotsX = new int[numberOfDots];
        dotsY = new int[numberOfDots];

        for (int i = 0; i < numberOfDots; i++) {
            dotsX[i] = input.nextInt();
            dotsY[i] = input.nextInt();
        }

        for (int i = 1; i < numberOfDots - 1; i++) {
            double firstEdge = getDistance(dotsX[0], dotsY[0], dotsX[i], dotsY[i]);
            double secondEdge = getDistance(dotsX[0], dotsY[0], dotsX[i + 1], dotsY[i + 1]);
            double thirdEdge = getDistance(dotsX[i], dotsY[i], dotsX[i + 1], dotsY[i + 1]);
            double halfPerimeter = (firstEdge + secondEdge + thirdEdge) / 2;
            totalArea += Math.sqrt(halfPerimeter * (halfPerimeter - firstEdge) * (halfPerimeter - secondEdge)
                    * (halfPerimeter - thirdEdge));

        }

        System.out.println(String.format("%.1f", totalArea));
    }

    static double getDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

}
