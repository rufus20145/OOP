package src.labs.third;

import java.util.Arrays;
import java.util.LinkedList;

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

        MyLinkedList test = new MyLinkedList();
        MyLinkedList testAddAll = new MyLinkedList();
        testAddAll.add("1");
        testAddAll.add("2");
        test.add("123");
        test.add("1234");
        test.add("12345");
        test.add(3, "1234567");
        test.addAll(testAddAll);
        test.addAll(0, testAddAll);
        test.add(5, "777");
        System.out.println(Arrays.asList(test.toArray()).toString());
        System.out.println("indexes are " + test.indexOf("123") + " and " + test.indexOf("1234567") + " and "
                + test.indexOf("9777"));
        System.out.println(test.set(0, "111"));
        System.out.println(test.set(0, "1112"));
        System.out.println(test.get(0));
        System.out.println(test.remove(8));
        System.out.println(Arrays.asList(test.toArray()).toString());
        System.out.println(test.remove("111"));//false
        System.out.println(test.remove("1112"));//true
        System.out.println(test.remove(Integer.valueOf(1)));//false
        System.out.println(test.removeAll(testAddAll));//true

        System.out.println(Arrays.asList(test.subList(0, 5).toArray()).toString());
    }
}
