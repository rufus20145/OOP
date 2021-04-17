package src.labs.third;

import src.labs.third.interfaces.Array;
public class MyArrayList implements Array {

    private static final int DEFAULT_CAPACITY = 5;

    private String[] array;
    private int size;

    public MyArrayList() {
        this.array = new String[DEFAULT_CAPACITY];
    }

    public MyArrayList(int initSize) {
        if(initSize > 0) {
            this.array = new String[initSize];
        } else {
            this.array = new String[DEFAULT_CAPACITY];
        }
    }

    public boolean add(String o) {
        return false;
    }
}
