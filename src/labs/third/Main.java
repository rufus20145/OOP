package src.labs.third;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    private static final String ARRAY_LIST = "ARRAY";
    private static final String LINKED_LIST = "LINKED";
    private static final String MAP = "MAP";

    public static void main(String[] args) {
        MyArrayList arrayList = new MyArrayList();
        MyLinkedList linkedList = new MyLinkedList();
        MyHashMap hashMap = new MyHashMap();
        Scanner input = new Scanner(System.in);
        boolean exceptionCaught = false;
        String collection = null;
        String element = null;

        System.out.println("Введите тип коллекции, с которой будем работать: ");
        do {
            exceptionCaught = false;
            try {
                collection = input.nextLine();
                if (!collection.matches("^(ARRAY|LINKED|MAP)$")) {
                    System.out.println("Вид коллекции не распознан. Повторите попытку.");
                    exceptionCaught = true;
                }
            } catch (NoSuchElementException e) {
                System.out.println("Вы не ввели ничего. Повторите попытку.");
                exceptionCaught = true;
                input.nextLine();
            } catch (IllegalStateException e) {
                System.out.println("Система ввода оказалась в некорректном состоянии. Повторите попытку.");
                exceptionCaught = true;
                input = new Scanner(System.in);
                input.nextLine();
            }
        } while (exceptionCaught);

        do {
            System.out.println("Введите элемент коллекции (для map ключ и значение на двух строках): ");

            element = getStringValue(input);

            if (element.equals("END")) {
                break;
            }

            switch (collection.toUpperCase()) {
                case ARRAY_LIST:
                    arrayList.add(element);
                    break;
                case LINKED_LIST:
                    linkedList.add(element);
                    break;
                case MAP:
                    Integer value = getIntValue(input);
                    getStringValue(input);
                    hashMap.put(element, value);
                    break;
                default:
                    System.out.println("Сюда попасть было нельзя, но ты смог.");
                    break;
            }
        } while (true);

        System.out.println("Количество элементов в структуре: ");
        switch (collection) {
            case ARRAY_LIST:
                System.out.println(arrayList.size() + "\nВывести все элементы структуры?");
                if (getStringValue(input).equals("YES")) {
                    for (String string : arrayList.toArray()) {
                        System.out.println(string);
                    }
                }
                break;
            case LINKED_LIST:
                System.out.println(linkedList.size() + "\nВывести все элементы структуры?");
                if (getStringValue(input).equals("YES")) {
                    for (String string : linkedList.toArray()) {
                        System.out.println(string);
                    }
                }
                break;
            case MAP:
                System.out.println(hashMap.size() + "\nВывести все элементы структуры?");
                if (getStringValue(input).equals("YES")) {
                    String[] temp = hashMap.getAllKeys();
                    for (String string : temp) {
                        System.out.println(string + " -> " + hashMap.get(string));
                    }
                }
                break;
            default:
                System.out.println("Сюда попасть было нельзя, но ты смог.");
                break;
        }

        System.out.println("Вывести элемент по индексу или ключу?");
        if (getStringValue(input).equals("YES")) {
            long startTime = 0;
            long finishTime = 0;
            int index;
            String key;
            switch (collection) {
                case ARRAY_LIST:
                    index = getIntValue(input);
                    startTime = System.currentTimeMillis();
                    System.out.println(arrayList.get(index));
                    finishTime = System.currentTimeMillis();
                    break;
                case LINKED_LIST:
                    index = getIntValue(input);
                    startTime = System.currentTimeMillis();
                    System.out.println(linkedList.get(index));
                    finishTime = System.currentTimeMillis();
                    break;
                case MAP:
                    key = getStringValue(input);
                    startTime = System.currentTimeMillis();
                    int a = hashMap.get(key);
                    finishTime = System.currentTimeMillis();
                    System.out.println(a);
                    break;
                default:
                    System.out.println("Сюда попасть было нельзя, но ты смог.");
                    break;
            }
            System.out.println("Это действие заняло столько времени: " + (finishTime - startTime));
        }
        System.out.println("END");
        input.close();
    }

    private static String getStringValue(Scanner input) {
        boolean exceptionCaught = false;
        String inputString = null;

        do {
            exceptionCaught = false;
            try {
                inputString = input.nextLine();
            } catch (NoSuchElementException e) {
                System.out.println("Вы не ввели ничего. Повторите попытку.");
                exceptionCaught = true;
                input.nextLine();
            } catch (IllegalStateException e) {
                System.out.println("Система ввода оказалась в некорректном состоянии. Повторите попытку.");
                exceptionCaught = true;
                input = new Scanner(System.in);
                input.nextLine();
            }
        } while (exceptionCaught);
        return inputString;
    }

    private static int getIntValue(Scanner input) {
        int value = 0;
        boolean exceptionCaught = false;

        do {
            exceptionCaught = false;
            try {
                value = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Введенное значение не является целым числом. Повторите попытку.");
                exceptionCaught = true;
                input.nextLine();
            } catch (NoSuchElementException e) {
                System.out.println("Вы не ввели ничего. Повторите попытку.");
                exceptionCaught = true;
                input.nextLine();
            } catch (IllegalStateException e) {
                System.out.println("Система ввода оказалась в некорректном состоянии. Повторите попытку.");
                exceptionCaught = true;
                input = new Scanner(System.in);
                input.nextLine();
            }
        } while (exceptionCaught);
        return value;
    }

}
