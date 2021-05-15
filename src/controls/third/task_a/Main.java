package src.controls.third.task_a;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * На вход программе подаются строки, содержащие телефонные номера. Выведите
 * "Correct", если номер в строке проходит по формату, затем в этой же строке
 * выведите преобразованный номер в международном формате, например
 * "+79035553399" Если номера нет или он не в правильном формате, выведите "No"
 * Правильными считаются номера, в которых присутствует 10 цифр(возможно, с
 * разделителями), и, опционально, 8, +7 или 7.
 */

public class Main {
    private static final String END_STRING = "";
    private static final String PHRONE_NUMBER_REGEX = "(\\+7|8|7)? ?[\\d]{3} ?[\\d ]{7,10}";
    private static final String PHONE_NUMBER_WITH_PLUS_AND_SEVEN_REGEX = "\\+7 ?\\d{3} ?\\d{3} ?(\\d{2} ?){2}";
    private static final String PHONE_NUMBER_WITH_SEVEN_REGEX = "7 ?\\d{3} ?\\d{3} ?(\\d{2} ?){2}";
    private static final String PHONE_NUMBER_WITH_EIGHT_REGEX = "8 ?\\d{3} ?\\d{3} ?(\\d{2} ?){2}";
    private static final String PHONE_NUMBER_WITHOUT_CODE_REGEX = "\\d{3} ?\\d{3} ?(\\d{2} ?){2}";

    public static void main(String[] args) {
        Pattern p = Pattern.compile(PHRONE_NUMBER_REGEX);
        Pattern plusAndSevenPattern = Pattern.compile(PHONE_NUMBER_WITH_PLUS_AND_SEVEN_REGEX);
        Pattern sevenPattern = Pattern.compile(PHONE_NUMBER_WITH_SEVEN_REGEX);
        Pattern eightPattern = Pattern.compile(PHONE_NUMBER_WITH_EIGHT_REGEX);
        Pattern withoutCode = Pattern.compile(PHONE_NUMBER_WITHOUT_CODE_REGEX);
        Matcher m;
        ArrayList<String> scannedStrings = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        do {
            String buffer = input.nextLine();
            if (buffer.equals(END_STRING)) {
                break;
            } else {
                scannedStrings.add(buffer);
            }
        } while (true);

        for (int i = 0; i < scannedStrings.size(); i++) {
            m = p.matcher(scannedStrings.get(i));
            if (m.find()) {

                StringBuilder temp = new StringBuilder("Correct:");
                m = plusAndSevenPattern.matcher(scannedStrings.get(i));
                if (m.find()) {

                    String tmp = m.group(0);
                    tmp = tmp.replace(" ", "");
                    temp.append(tmp);

                } else {
                    m = sevenPattern.matcher(scannedStrings.get(i));
                    if (m.find()) {
                        String tmp = m.group(0);
                        tmp = tmp.replace(" ", "");
                        temp.append("+").append(tmp);

                    } else {
                        m = eightPattern.matcher(scannedStrings.get(i));
                        if (m.find()) {
                            String tmp = m.group(0);
                            tmp = tmp.replace(" ", "").replaceAll("^8", "7");
                            temp.append("+").append(tmp);
                        } else {
                            m = withoutCode.matcher(scannedStrings.get(i));
                            if (m.find()) {
                                String tmp = m.group(0);
                                tmp = tmp.replace(" ", "");
                                temp.append("+7").append(tmp);
                            }
                        }
                    }
                }
                scannedStrings.set(i, temp.toString());

            } else {
                System.out.println(false);
                scannedStrings.set(i, "No");
            }
        }
        for (String string : scannedStrings) {
            System.out.println(string);
        }
        input.close();
    }
}
