package src.homeworks.tenth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class TaskA {
    private static final int RESULT_ARRAY_NUMBER = 2;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        do {
            String tmp = in.nextLine();
            if (tmp.matches("")) {
                break;
            } else {
                numbers.add(Integer.valueOf(tmp));
            }

        } while (true);
        int[] numbersToPass = new int[numbers.size()];

        for (int i = 0; i < numbers.size(); ++i) {
            numbersToPass[i] = numbers.get(i);
        }

        System.out.println(Arrays.toString(findLongestSequence(numbersToPass)));
        in.close();
    }

    private static int[] findLongestSequence(int[] nums) {
        TreeSet<Integer> numbers = new TreeSet<>();
        for (int intNum : nums) {
            numbers.add(intNum);
        }

        Integer[] tmp = numbers.toArray(new Integer[0]);
        for (int i = 0; i < numbers.size(); i++) {
            nums[i] = tmp[i];
        }

        int index;
        int result = 0;
        int endNumber = -1;
        int tmpResult = 0;
        for (index = 0; index < nums.length - 1; index++) {
            if (nums[index + 1] - nums[index] == 1) {
                tmpResult++;
            } else {
                if (result < tmpResult) {
                    result = tmpResult;
                    endNumber = index;
                }
                tmpResult = 0;
            }
        }
        if (result < tmpResult) {
            result = tmpResult;
            endNumber = index;
        }
        int[] resultArray = new int[RESULT_ARRAY_NUMBER];
        resultArray[0] = nums[endNumber - result];
        resultArray[1] = nums[endNumber];
        return resultArray;
    }

}
