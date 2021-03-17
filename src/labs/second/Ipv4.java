package src.labs.second;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Ipv4 {
    public static void main(String[] args) {

        String regex = new String(
                "^((25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[0-9][0-9]|[0-9])\\.)"
                + "{3}(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[0-9][0-9]|[0-9])$");

        Scanner input = new Scanner(System.in);

        String inputLine = input.nextLine();
        input.close();

        System.out.println(Pattern.matches(regex, inputLine));
    }
}
