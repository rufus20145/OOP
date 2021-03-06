package src.labs.second;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Ipv6 {
    public static void main(String[] args) {

        String regex = new String("^([0-9a-fA-F]{0,4}:){2,7}([0-9a-fA-F]{0,4})$");

        Scanner input = new Scanner(System.in);

        String inputLine = input.nextLine();
        input.close();

        System.out.println(Pattern.matches(regex, inputLine));
    }
}
