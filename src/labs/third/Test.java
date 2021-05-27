package src.labs.third;

import java.util.Arrays;

public class Test {
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
        System.out.println(secondArrayList.remove(4));
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
        toRemove.remove("2");
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
        test.add(null);
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
        System.out.println(test.remove("111"));// false
        System.out.println(test.remove("1112"));// true
        System.out.println(test.remove(Integer.valueOf(1)));// false
        System.out.println(test.removeAll(testAddAll));// true

        System.out.println(Arrays.asList(test.subList(0, 5).toArray()).toString());

        MyHashMap mapToPut = new MyHashMap(2);
        mapToPut.put("test1", 12);
        mapToPut.put("test2", 123);
        mapToPut.put("test3", 1234);
        mapToPut.put("test4", 12345);

        MyHashMap firstMap = new MyHashMap(1);
        System.out.println("Is this map empty? - " + firstMap.isEmpty() + ". It`s size is " + firstMap.size());
        System.out.println(firstMap.put("testString", 111)); // null, т.к. там ничего не было
        System.out.println(firstMap.put("testString", 222)); // 111, т.к. совпадают ключи
        System.out.println("Now it`s size is " + firstMap.size()); // 1, т.к. значение было заменено
        firstMap.putAll(mapToPut);
        System.out.println("Now it`s size is " + firstMap.size()); // 5
        System.out.println(firstMap.remove("testString")); // 222
        System.out.println(firstMap.get("test4")); // 12345
        System.out.println(firstMap.get("test5")); // null
        System.out.println(firstMap.containsKey("test5")); // false
        System.out.println(firstMap.containsKey("test4")); // true
        System.out.println(firstMap.containsValue(111)); // false
        System.out.println(firstMap.containsValue(123)); // true
        System.out.println("Is this map empty? - " + firstMap.isEmpty() + ". It`s size is " + firstMap.size());

        for (String string : firstMap.getAllKeys()) {
            System.out.print(string + " ");
        }
        System.out.println();

        for (Integer integer : firstMap.getAllValues()) {
            System.out.print(integer + " ");
        }
        System.out.println();

        firstMap.clear();
        System.out.println("Is this map empty? - " + firstMap.isEmpty() + ". It`s size is " + firstMap.size());

        MyLinkedList check = new MyLinkedList();
        check.add("test1");
        System.out.println(Arrays.asList(check.toArray()).toString());
        check.remove(0);
        check.add("test2");
        System.out.println(Arrays.asList(check.toArray()).toString());

        MyLinkedList test123321 = new MyLinkedList();
        test123321.add("01");
        test123321.add("02");
        test123321.add("03");
        test123321.add(null);
        test123321.add(null);
        test123321.add("666");
        System.out.println(Arrays.asList(test.toArray()).toString());
        System.out.println(test123321.indexOf("666"));
        System.out.println(test123321.set(0, "sad"));
        System.out.println(test123321.set(1, "asd"));
        System.out.println(test123321.get(0));
        System.out.println(test123321.remove(2));
        System.out.println(Arrays.asList(test123321.toArray()).toString());
        System.out.println(test123321.remove("sad"));
        System.out.println(test123321.remove("asd"));
        System.out.println(test123321.remove(Integer.valueOf(3)));
        MyLinkedList remove = new MyLinkedList();
        remove.add(null);
        System.out.println(test123321.removeAll(remove));
        System.out.println(test123321.get(1));

    }
}
