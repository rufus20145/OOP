package src.labs.first;

/**
 * Найти, каких букв, гласных или согласных, больше в каждом предложении текста.
 */

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        String myText = null;
        String[] sentences;
        Scanner input = new Scanner(System.in);
        Boolean flag = true;
        char[] alphabet = "aAeEiIoOuUyY".toCharArray();

        System.out.println("Enter your text and then press enter.");
        do {
            try {
                myText = input.nextLine();
                flag = false;
            } catch (java.util.NoSuchElementException e) {
                System.out.println("\tYou didn't enter any text. Try again.");
                input.nextLine();
            } catch (java.lang.IllegalStateException e) {
                System.out.println("\tSomething went wrong. Try again.");
                input.nextLine();
            }
        } while (flag);

        sentences = myText.split("\\.\\s|\\.");

        for (String currSentence : sentences) {
            String[] words = currSentence.split("\\W");
            for (String currWord : words) {
                char[] charWord = currWord.toCharArray();
                for (char currDigit : charWord) {

                }
            }
        }

        System.out.println("I`m out.");

    }
}
