package src.labs.third;

import java.util.InputMismatchException;
import src.labs.third.interfaces.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyArrayList arrayList;
        MyLinkedList linkedList;
        MyHashMap hashMap;
        Scanner input = new Scanner(System.in);
        boolean exceptionCaught = false;
        boolean isInProgramm = true;
        String collection;

        do {
            try {
                collection = input.nextLine();
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

        } while (isInProgramm);
    }

    static void enterElementToCollection() {
        
    }
}
