package src.labs.third;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyArrayList tempArrayList = new MyArrayList();
        tempArrayList.add("123");
        tempArrayList.add("321");
        tempArrayList.add(1, "4321");
        tempArrayList.add(0, null);
        System.out.println(Arrays.asList(tempArrayList.toArray()).toString());

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

        MyArrayList tmp = new MyArrayList();
        tmp.add("1");
        tmp.add("4");
        MyArrayList toRemove = new MyArrayList(3);
        toRemove.add("1");
        toRemove.add("2");
        toRemove.add("3");
        toRemove.add("4");
        // toRemove.remove("2");
        toRemove.removeAll(tmp);
        System.out.println(Arrays.asList(toRemove.toArray()).toString());

        tmp.clear();
        System.out.println(Arrays.asList(tmp.toArray()).toString() + " Here is cleared array.");

    }
}
