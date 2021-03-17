package src.labs.second;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Password {
    public static void main(String[] args) {

        String regex = new String("((?=.*[a-z])(?=.*[0-9])(?=.*[A-Z])(\\_*).{8,})");

        Scanner input = new Scanner(System.in);

        String inputLine = input.nextLine();
        input.close();

        System.out.println(Pattern.matches(regex, inputLine));
    }
}
