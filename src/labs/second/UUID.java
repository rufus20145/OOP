package src.labs.second;

import java.util.Scanner;
import java.util.regex.Pattern;

public class UUID {
    public static void main(String[] args) {

        String regex = new String("((?=[{(][^{}()]{36}[})])"
                        + "(^.([0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}).$))"
                        + "|^([0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12})$");

        Scanner input = new Scanner(System.in);

        String inputLine = input.nextLine();
        input.close();

        System.out.println(Pattern.matches(regex, inputLine));

    }
}
