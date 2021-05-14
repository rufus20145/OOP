package src.labs.second;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ExactString {

    public static void main(String[] args) {

        String regex = new String("^abcdefghijklmnopqrstuv18340$");

        Scanner input = new Scanner(System.in);

        String inputLine = input.nextLine();
        input.close();

        System.out.println(Pattern.matches(regex, inputLine));
    }
}
