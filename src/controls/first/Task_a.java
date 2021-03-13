// package src.controls.first;

import java.util.Arrays;
import java.util.Scanner;

/**
 * � ������������� ������ ������ ����� �������� �� ������� � �������� (���
 * �������� �������� �������� +33). ����� �������� � ���������� �������.
 */
public class Task_a {

    public static void main(String[] args) {

        String smallLetters = "��������������������������������";
        String bigLetters = "�����Ũ��������������������������";
        String inputString;
        Scanner input = new Scanner(System.in);
        StringBuilder outputString = new StringBuilder();

        inputString = input.nextLine();

        for (char digit : inputString.toCharArray()) {

            if (smallLetters.contains(Character.toString(digit))) {
                outputString.append('[');
                outputString.append(smallLetters.indexOf(digit) + 1);
                outputString.append(']');
            } else if (bigLetters.contains(Character.toString(digit))) {
                outputString.append('[');
                outputString.append(bigLetters.indexOf(digit) + 34);
                outputString.append(']');
            } else {
                outputString.append(digit);
            }
        }
        System.out.println(outputString.toString());
    }
}
