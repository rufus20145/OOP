package src.labs.second;

import java.util.Scanner;
import java.util.regex.Pattern;

public class HexNumber {

    public static void main(String[] args) {

        String regex = new String("^[1-9a-fA-F]{1}[0-9a-fA-F]*$");

        Scanner input = new Scanner(System.in);

        String inputLine = input.nextLine();
        input.close();

        System.out.println(Pattern.matches(regex, inputLine));

    
    }
}
