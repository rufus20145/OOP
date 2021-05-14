package controls.first;

import java.util.Scanner;

/**
 * В кириллическом тексте каждую букву заменить ее номером в алфавите (для
 * верхнего регистра смещение +33). Числа выделить в квадратных скобках.
 */
public class TaskA {

    public static void main(String[] args) {

        String smallLetters = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        String bigLetters = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
        String inputString;
        Scanner input = new Scanner(System.in);
        StringBuilder outputString = new StringBuilder();

        inputString = input.nextLine();

        for (char digit : inputString.toCharArray()) {

            if (smallLetters.contains(Character.toString(digit))) {
                outputString.append('[').append(smallLetters.indexOf(digit) + 1).append(']');
            } else if (bigLetters.contains(Character.toString(digit))) {
                outputString.append('[').append(bigLetters.indexOf(digit) + 34).append(']');
            } else {
                outputString.append(digit);
            }
        }

        System.out.println(outputString.toString());
        input.close();
    }
}
