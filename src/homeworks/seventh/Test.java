package src.homeworks.seventh;


import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        ArrayList<String> test321 = new ArrayList<>();
        test321.add("1");
        test321.add(1, "3");
        test321.add("2");
        test321.add(0, null);
        String[] test1233 = test321.toArray(new String[0]);
        System.out.println(Arrays.toString(test1233));

        System.out.println(true);
        MyArrayList<String> tempArrayList = new MyArrayList<>();
        tempArrayList.add("1");
        tempArrayList.add("2");
        tempArrayList.add(1, "3");
        tempArrayList.add(0, null);
        System.out.println(Arrays.asList(tempArrayList.toArray()).toString());
        String[] test123 = tempArrayList.toArray(new String[0]);
        System.out.println(Arrays.toString(test123));

        MyArrayList<String> secondArrayList = new MyArrayList<>(2);
        MyArrayList<String> arrayListToAddAll = new MyArrayList<>(2);
        secondArrayList.add("1");
        secondArrayList.add("2");

        arrayListToAddAll.add("1");
        arrayListToAddAll.add("2");
        System.out.println(secondArrayList.addAll(2, arrayListToAddAll));
        System.out.println(secondArrayList.addAll(2, arrayListToAddAll));
        System.out.println(secondArrayList.addAll(new MyArrayList<>()));

        System.out.println(Arrays.asList(secondArrayList.toArray()).toString());
        System.out.println(secondArrayList.set(2, "986"));
        System.out.println(secondArrayList.remove(4));
        System.out.println(Arrays.asList(secondArrayList.toArray()).toString());
        System.out.println("12343421u8412e");
        System.out.println(Arrays.asList(secondArrayList.subList(0, 1).toArray()).toString());

        MyArrayList<String> tmp = new MyArrayList<>();
        tmp.add("1");
        tmp.add("4");
        MyArrayList<String> toRemove = new MyArrayList<>(3);
        toRemove.add("1");
        toRemove.add("2");
        toRemove.add("3");
        toRemove.add("4");
        toRemove.remove("2");
        toRemove.removeAll(tmp);
        System.out.println(Arrays.asList(toRemove.toArray()).toString());

        tmp.clear();
        System.out.println(Arrays.asList(tmp.toArray()).toString() + " Here is cleared array.");

        MyLinkedList<String> test = new MyLinkedList<>();
        MyLinkedList<String> testAddAll = new MyLinkedList<>();
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

        MyHashMap<String, Integer> mapToPut = new MyHashMap<>(2);
        mapToPut.put("test1", 12);
        mapToPut.put("test2", 123);
        mapToPut.put("test3", 1234);
        mapToPut.put("test4", 12345);

        MyHashMap<String, Integer> firstMap = new MyHashMap<>(1);
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

        for (Object string : firstMap.getAllKeys()) {
            System.out.print(string + " ");
        }
        System.out.println();

        for (Object integer : firstMap.getAllValues()) {
            System.out.print(integer + " ");
        }
        System.out.println();

        firstMap.clear();
        System.out.println("Is this map empty? - " + firstMap.isEmpty() + ". It`s size is " + firstMap.size());

        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("О второй живой", "Артём");

        System.out.println("проверка integer");
        MyLinkedList<Integer> intTest = new MyLinkedList<>();
        intTest.add(1);
        intTest.add(2);
        intTest.add(3);
        intTest.add(0);
        System.out.println(intTest.remove(0));
        System.out.println(intTest.remove((Integer) 3));
        System.out.println(intTest.remove(1));

    }
}
