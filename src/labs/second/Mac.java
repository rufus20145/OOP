package src.labs.second;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Mac {
    public static void main(String[] args) {

        String regex = new String("^([0-9A-Fa-f]{2}:){5}([0-9A-Fa-f]{2})$");

        Scanner input = new Scanner(System.in);

        String inputLine = input.nextLine();
        input.close();

        System.out.println(Pattern.matches(regex, inputLine));
    }
}
