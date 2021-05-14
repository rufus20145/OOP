package homeworks.ninth;

import java.util.ArrayList;
import java.util.Arrays;

public class TaskB {
    public static void main(String[] args) {
        // как-то мы получили эти массив
        int[][] massive = { { 0, 1, 1, 0, 1 }, { 0, 1, 0, 1, 1 }, { 1, 1, 0, 1, 0 }, { 0, 1, 0, 1, 0 },
                { 0, 1, 0, 0, 1 } };
        int[][] massive2 = { { 1, 1, 0, 1, 1 }, { 1, 1, 0, 1, 1 }, { 0, 0, 0, 0, 0 }, { 1, 1, 0, 1, 1 },
                { 1, 1, 0, 1, 1 } };
        int[][] massive3 = { { 0, 0, 0, 0, 0 }, { 1, 1, 0, 1, 1 }, { 0, 0, 0, 0, 0 }, { 1, 1, 0, 1, 1 },
                { 0, 0, 0, 0, 0 } };
        int[][] massive4 = { { 0, 1, 0, 0, 0 }, { 1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0 } };
        int[] result = findCavities(massive);
        System.out.println(Arrays.toString(result));
        result = findCavities(massive2);
        System.out.println(Arrays.toString(result));
        result = findCavities(massive3);
        System.out.println(Arrays.toString(result));
        result = findCavities(massive4);
        System.out.println(Arrays.toString(result));
    }

    private static int[] findCavities(int[][] massive) {
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < massive.length; i++) {
            for (int j = 0; j < massive[i].length; j++) {
                if (massive[i][j] == 0) {
                    temp.add(getSize(massive, i, j, 0));
                }
            }
        }

        int[] result = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            result[i] = temp.get(i);
        }
        Arrays.sort(result);
        return result;
    }

    private static int getSize(int[][] massive, int i, int j, int numberOfIteration) {
        int size = 0;

        if (i < massive.length && j < massive[i].length) {
            if (numberOfIteration > Math.max(massive.length * massive.length, massive[i].length * massive[i].length)) {
                return 0;
            }
            if (massive[i][j] == 0) {
                size++;
                massive[i][j] = -1;
                if (i < massive.length) {
                    size += getSize(massive, i + 1, j, numberOfIteration + 1);
                }
                if (i < massive.length && j < massive[i].length) {
                    size += getSize(massive, i, j + 1, numberOfIteration + 1);
                }
                if (i > 0) {
                    size += getSize(massive, i - 1, j, numberOfIteration + 1);
                }
                if (j > 0) {
                    size += getSize(massive, i, j - 1, numberOfIteration + 1);
                }
            }
        }
        return size;
    }
}
