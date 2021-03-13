// package src.controls.first;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Task_c {

    public static void main(String[] args) {
        String regex = "^[+-]{0,1}([1-9]+[0-9]*[.,]{0,1}[0-9]*)|([+-]{0,1}[0]{1}[.,][0-9]+)|[0]{1}$";

        Scanner input = new Scanner(System.in);

        while (true) {
            String inputLine = input.nextLine();
            System.out.println(Pattern.matches(regex, inputLine));
        }
    }
}
