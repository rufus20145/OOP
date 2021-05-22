package src.labs.first;

/**
 * Найти и напечатать, сколько раз повторяется в тексте каждое слово.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Task2 {
    private static final String SPLIT_REGEX = "\\!\\ |\\.\\ |\\.|\\ ";

    public static void main(String[] args) {
        String text;
        String[] words;
        String[] uniqueWords;
        Scanner input;
        int numberOfWords;
        int numberOfUniqueWords = 0;
        int[] amountOfUniqueWords;
        StringBuilder output = new StringBuilder();

        // ввод исходного текста
        System.out.println("Enter your sentence: ");
        input = new Scanner(System.in);
        text = input.nextLine();
        input.close();

        // разбиение текста на слова
        words = text.split(SPLIT_REGEX); // сначала ищем последовательность ". ", потом ".", а затем " ". Это
                                         // позволяет правильно разделять слова на границах предложений
        numberOfWords = words.length;
        uniqueWords = new String[numberOfWords];
        amountOfUniqueWords = new int[numberOfWords];

        // помещение слов, которые не встречались ранее, в словарь для будущего подсчета
        // их количества. Это также можно сделать, как мой подсчет количества слов чуть
        // ниже - с помощью двух циклов
        int currWord;
        int currUniqueWord = 0;
        for (currWord = 0; currWord < numberOfWords; currWord++) {
            if (!Arrays.asList(uniqueWords).contains((words[currWord].toLowerCase()))) {
                uniqueWords[currUniqueWord] = words[currWord].toLowerCase();
                currUniqueWord++; // двигаемся по массиву с уникальными словами, т.е. по сути считаем их
            }
        }

        // считаем количество вхождений каждого слова в исходный текст
        numberOfUniqueWords = currUniqueWord; // см. 47 строку
        for (currUniqueWord = 0; currUniqueWord < numberOfUniqueWords; currUniqueWord++) {
            for (currWord = 0; currWord < numberOfWords; currWord++) {
                if (uniqueWords[currUniqueWord].equalsIgnoreCase(words[currWord])) {
                    amountOfUniqueWords[currUniqueWord]++;
                }
            }
        }

        // собственно вывод уникальных слов и их количества в тексте
        for (currUniqueWord = 0; currUniqueWord < numberOfUniqueWords; currUniqueWord++) {
            if (uniqueWords[currUniqueWord] != null) {
                output.append(String.format("%-20s", uniqueWords[currUniqueWord]));
                output.append(String.format("%-6s", amountOfUniqueWords[currUniqueWord]));
                output.append("\n");
            }
        }
        System.out.println(output.toString());
    }
}
