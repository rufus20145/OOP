package src.controls.third.task_b;

import java.io.File;
// import java.io.FileWriter;
// import java.io.PrintStream;
import java.util.ArrayList;
// import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static final Object END_STRING = "";
    private static final int HUNDRED = 100;
    private static final int FIRST_ELEMENT = 1;
    private static final int SECOND_ELEMENT = 2;
    private static final int THIRD_ELEMENT = 3;

    public static void main(String[] args) {

        HashMap<String, Integer> accounts = new HashMap<>();
        ArrayList<String> scStrings = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        if (args.length > 0) {
            File inputFile = new File(args[1]);
            try (Scanner scan = new Scanner(inputFile);) {
                while (scan.hasNextLine()) {
                    scStrings.add(scan.nextLine());
                }
            } catch (Exception e) {
                System.out.println("I didn`t find a file");
            }
        } else {
            do {
                if (input.hasNextLine()) {
                    String buffer = input.nextLine();
                    if (buffer.equals(END_STRING)) {
                        break;
                    } else {
                        scStrings.add(buffer);
                    }
                }
            } while (true);
        }
        StringBuilder sb = new StringBuilder();
        for (String buffer : scStrings) {
            String[] parts = buffer.split(" ");
            if (parts[0].equals("DEPOSIT")) {
                if (accounts.containsKey(parts[FIRST_ELEMENT])) {
                    accounts.replace(parts[FIRST_ELEMENT],
                            accounts.get(parts[FIRST_ELEMENT]) + Integer.valueOf(parts[SECOND_ELEMENT]));
                } else {
                    accounts.put(parts[FIRST_ELEMENT], Integer.valueOf(parts[SECOND_ELEMENT]));
                }
            } else if (parts[0].equals("WITHDRAW")) {
                if (accounts.containsKey(parts[FIRST_ELEMENT])) {
                    accounts.replace(parts[FIRST_ELEMENT],
                            accounts.get(parts[FIRST_ELEMENT]) - Integer.valueOf(parts[SECOND_ELEMENT]));
                } else {
                    accounts.put(parts[FIRST_ELEMENT], -1 * Integer.valueOf(parts[SECOND_ELEMENT]));
                }
            } else if (parts[0].equals("BALANCE")) {
                if (accounts.containsKey(parts[FIRST_ELEMENT])) {
                    if (args.length > 0) {
                        sb.append(accounts.get(parts[FIRST_ELEMENT])).append("\n");
                    } else {
                        System.out.println(accounts.get(parts[FIRST_ELEMENT]));
                    }
                } else {
                    System.out.println("ERROR");
                }
            } else if (parts[0].equals("TRANSFER")) {
                if (accounts.containsKey(parts[FIRST_ELEMENT])) {
                    accounts.replace(parts[FIRST_ELEMENT],
                            accounts.get(parts[FIRST_ELEMENT]) - Integer.valueOf(parts[THIRD_ELEMENT]));
                } else {
                    accounts.put(parts[FIRST_ELEMENT], -1 * Integer.valueOf(parts[THIRD_ELEMENT]));
                }
                if (accounts.containsKey(parts[SECOND_ELEMENT])) {
                    accounts.replace(parts[SECOND_ELEMENT],
                            accounts.get(parts[SECOND_ELEMENT]) + Integer.valueOf(parts[THIRD_ELEMENT]));
                } else {
                    accounts.put(parts[SECOND_ELEMENT], Integer.valueOf(parts[THIRD_ELEMENT]));
                }
            } else if (parts[0].equals("INCOME")) {
                for (String key : accounts.keySet()) {
                    if (accounts.get(key) > 0) {
                        accounts.replace(key, accounts.get(key) + (int) Math
                                .floor((accounts.get(key) * (Double.parseDouble(parts[FIRST_ELEMENT]) / HUNDRED))));
                    }
                }
            }
        }
        // StringBuilder resFileName = new StringBuilder(args[1].replace(".txt", ""));
        // resFileName.append("-out.txt");
        // File out = new File(resFileName.toString());
        // if (out.createNewFile()) {
        // FileWriter print = new FileWriter(out);
        // for (String string : sb.toString().split("\n")) {
        // print.write(string);
        // print.close();
        // }
        // }
        input.close();
    }
}
