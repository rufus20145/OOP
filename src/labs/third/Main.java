package src.labs.third;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyArrayList tempArrayList = new MyArrayList();
        tempArrayList.add("123");
        tempArrayList.add("321");
        tempArrayList.add(1, "4321");

        MyArrayList secondArrayList = new MyArrayList(2);
        secondArrayList.add("1");
        secondArrayList.add("2");
        System.out.println(secondArrayList.addAll(2, tempArrayList));
        System.out.println(secondArrayList.addAll(new MyArrayList()));

        System.out.println(Arrays.asList(secondArrayList.toArray()).toString());
        System.out.println(secondArrayList.set(2, "986"));
        // System.out.println(secondArrayList.remove(4));
        System.out.println(Arrays.asList(secondArrayList.toArray()).toString());
        System.out.println("12343421u8412e");
        System.out.println(Arrays.asList(secondArrayList.subList(0, 1).toArray()).toString());
    }
}
