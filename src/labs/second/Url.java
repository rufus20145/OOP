package src.labs.second;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Url {
    public static void main(String[] args) {

        String regex = new String("^(https://|http://)?([a-zA-Z0-9а-яА-ЯёЁ][a-zA-Z0-9_а-яА-ЯёЁ\\-_]+\\.)+"
                + "([a-zA-Zа-яА-ЯёЁ0-9]{2,})(:(6553[0-5]|655[0-2][0-9]|65[0-4][0-9]{2}|6[0-4][0-9]{3}"
                + "|[1-5][0-9]{4}|[1-9][0-9]{3}|[1-9][0-9]{2}|[1-9][0-9]|[1-9])){0,1}(/[a-zA-Z0-9а-яА-ЯёЁ]"
                + "[a-zA-Z0-9_\\-а-яА-ЯёЁ]*)*(/{0,1}\\?[a-zA-Z0-9\\-а-яА-ЯёЁ]+=[a-zA-Z0-9\\-а-яА-ЯёЁ]+"
                + "(&[a-zA-Z0-9\\-а-яА-ЯёЁ]=[a-zA-Z0-9\\-а-яА-ЯёЁ]+)*)*(/{0,1}#[a-zA-Zа-яА-ЯёЁ0-9_\\-]+)*/{0,1}$");

        Scanner input = new Scanner(System.in);

        String inputLine = input.nextLine();
        input.close();

        System.out.println(Pattern.matches(regex, inputLine));

    }
}
