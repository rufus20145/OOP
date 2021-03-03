package src.labs.first;

/**
 * Найти и напечатать, сколько раз повторяется в тексте каждое слово.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        String text;
        String[] words, uniqueWords;
        Scanner input;
        int numberOfWords, numberOfUniqueWords = 0, currUniqueWord = 0, currWord;
        int[] amountOfUniqueWords;
        StringBuilder tempSB = new StringBuilder();

        // ввод исходного текста
        System.out.println("Enter your text: ");
        input = new Scanner(System.in);
        text = input.nextLine();
        input.close();

        // разбиение текста на слова
        words = text.split("\\.\\ |\\.|\\ "); // сначала ищем последовательность ". ", потом ".", а затем " ". Это
                                              // позволяет правильно разделять слова на границах предложений
        numberOfWords = words.length;
        uniqueWords = new String[numberOfWords];
        amountOfUniqueWords = new int[numberOfWords];

        // помещение слов, которые не встречались ранее, в словарь для будущего подсчета
        // их количества. Это также можно сделать, как мой подсчет количества слов чуть
        // ниже - с помощью двух циклов
        for (currWord = 0; currWord < numberOfWords; currWord++) {
            if (!Arrays.asList(uniqueWords).contains((words[currWord].toLowerCase()))) {
                uniqueWords[currUniqueWord] = words[currWord].toLowerCase();
                currUniqueWord++; // двигаемся по массиву с уникальными словами, т.е. по сути считаем их
            }
        }

        // считаем количество вхождений каждого слова в исходный текст
        numberOfUniqueWords = currUniqueWord; // см. 37 строку
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
                tempSB.append(String.format("%-20s", uniqueWords[currUniqueWord]));
                tempSB.append(String.format("%-6s", amountOfUniqueWords[currUniqueWord]));
                tempSB.append("\n");
            }
        }
        System.out.println(tempSB.toString());
    }
}
