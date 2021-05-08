package src.homeworks.ninth;

import java.util.ArrayList;
import java.util.Arrays;

public class TaskB {
    public static void main(String[] args) {
        // как-то мы получили этот массив
        int[][] massive = { { 0, 1, 1, 0, 1 }, { 0, 1, 0, 1, 1 }, { 1, 1, 0, 1, 0 }, { 0, 1, 0, 1, 0 },
                { 0, 1, 0, 0, 1 } };
        int[] result = findCavities(massive);
        Arrays.sort(result);
        System.out.println(Arrays.toString(result));
    }

    private static int[] findCavities(int[][] massive) {
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < massive.length; i++) {
            for (int j = 0; j < massive[i].length; j++) {
                if (massive[i][j] == 0) {
                    temp.add(getSize(massive, i, j));
                }
            }
        }

        int[] result = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            result[i] = temp.get(i);
        }
        return result;
    }

    private static int getSize(int[][] massive, int i, int j) {
        int size = 0;

        if (i < massive.length && j < massive[i].length) {
            if (massive[i][j] == 0) {
                size++;
                if (i < massive.length) {
                    size += getSize(massive, i + 1, j);
                }
                if (i < massive.length && j < massive[i].length) {
                    size += getSize(massive, i, j + 1);
                }
            }
            massive[i][j] = -1;
        }
        return size;
    }
}
