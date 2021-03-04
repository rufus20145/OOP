package src.labs.first;

/*
  ������ n ����� � �������. ������� �� ������� �� ������, ����� ������� ������ �������, ����� �� �����.
 */

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        int numberOfStrings = -1;
        float averageLength = 0;
        String[] strings;
        int[] lengthsOfStrings;
        Scanner input;

        // ��������� ���������� �����
        input = new Scanner(System.in);
        System.out.println("Enter number of strings: ");
        do {
            try {
                numberOfStrings = input.nextInt();
                if (numberOfStrings < 1) {
                    System.out.println("Number of strings must be greater than zero");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("You entered wrong value. Try again.");
                input.nextLine();
            }
        } while (numberOfStrings < 1);

        // �������� ������ ��� ������ � �� �����
        strings = new String[numberOfStrings];
        lengthsOfStrings = new int[numberOfStrings];

        // ������ ������ ��� ������
        System.out.println("Now enter " + numberOfStrings + " strings");
        input.nextLine();
        for (int currString = 0; currString < numberOfStrings; currString++) {
            strings[currString] = input.nextLine();
        }
        input.close();
        System.out.println("");

        // ������� ����� �����
        for (int currString = 0; currString < numberOfStrings; currString++) {
            lengthsOfStrings[currString] = strings[currString].length();
        }

        // ������� ������� ����� ������
        for (int currString = 0; currString < numberOfStrings; currString++) {
            averageLength += lengthsOfStrings[currString];
        }
        averageLength /= numberOfStrings;

        // ������� ����������� ������ � �������
        for (int currString = 0; currString < numberOfStrings; currString++) {
            if (lengthsOfStrings[currString] < averageLength) {
                System.out.println(strings[currString] + " - length is " + lengthsOfStrings[currString]);
            }
        }
    }
}