package src.labs.second;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Email {

    public static void main(String[] args) {

        String regex = new String("^(?=(.{1,64}@))(?=(.{7,255}$))((([a-zA-Z0-9_а-яА-ЯёЁ]+)"
        + "(\\+[a-zA-Z0-9_а-яА-ЯёЁ\\-_]+)?)@(([a-zA-Z0-9а-яА-ЯёЁ][a-zA-Z0-9_а-яА-ЯёЁ\\-_]+\\.)+"
        + "([a-zA-Zа-яА-ЯёЁ0-9]{2,})|(((25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9])\\.){3}"
        + "(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9]))))$");

        Scanner input = new Scanner(System.in);

        String inputLine = input.nextLine();
        input.close();

        System.out.println(Pattern.matches(regex, inputLine));
    }
}
