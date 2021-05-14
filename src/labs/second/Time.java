package src.labs.second;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Time {
    public static void main(String[] args) {

        String regex = new String("^([0-9]{4})-((02-(2[0-8]|[01][0-9]))|((01|03|05|07|08|10|12)-"
                + "(3[0-1]|[0-2][0-9]))|((04|06|09|11)-(30|[0-2][0-9])))"
                + "[ T](2[0-3]|[0-1][0-9](:[0-5][0-9]){2})Z{0,1}"
                + "(\\+(1[0-4]|0[0-9])([0-5][0-9]){0,1}(:[0-5][0-9]){0,1}){0,1}"
                + "(\\-(1[0-2]|0[0-9])([0-5][0-9]){0,1}(:[0-5][0-9]){0,1}){0,1}$");

        Scanner input = new Scanner(System.in);

        String inputLine = input.nextLine();
        input.close();

        System.out.println(Pattern.matches(regex, inputLine));
    }
}
