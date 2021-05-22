package src.labs.first;

/**
 * Найти, каких букв, гласных или согласных, больше в каждом предложении текста.
 */

import java.util.Scanner;

public class Task3 {
    private static final String CONSONANTS = "bcdfghjklmnpqrstvwxz";
    private static final String VOCALS = "aeiouy";

    public static void main(String[] args) {
        String myText = null;
        String[] sentences;
        Scanner input = new Scanner(System.in);
        boolean flag = true;

        System.out.println("Enter your text and then press enter.");
        do {
            try {
                myText = input.nextLine();
                flag = false;
            } catch (java.util.NoSuchElementException e) {
                System.out.println("You didn't enter any text. Try again.");
                input.nextLine();
            } catch (java.lang.IllegalStateException e) {
                System.out.println("Something went wrong. Try again.");
                input.nextLine();
            }
        } while (flag);
        input.close();

        sentences = myText.split("\\.\\s|\\.");

        int numberOfSentence = 1;
        for (String currSentence : sentences) {

            int numberOfVocals = 0;
            int numberOfConsonants = 0;
            currSentence = currSentence.replace(" ", "");

            for (char character : currSentence.toLowerCase().toCharArray()) {
                if (VOCALS.contains((String.valueOf(character)))) {
                    ++numberOfVocals;
                } else if (CONSONANTS.contains(String.valueOf(character))) {
                    ++numberOfConsonants;
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append("In sentence №");
            sb.append(numberOfSentence);
            if (numberOfVocals > numberOfConsonants) {
                sb.append(" number of vocals is greater than number of consonants.");
            } else if (numberOfVocals < numberOfConsonants) {
                sb.append(" number of consonants is greater than number of vocals.");
            } else {
                sb.append(" number of vocals and consonants are equal.");
            }
            System.out.println(sb.toString());

            numberOfSentence += 1;
        }
    }
}
