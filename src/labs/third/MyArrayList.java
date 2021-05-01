package src.labs.third;

import java.util.Arrays;

import src.labs.third.interfaces.Array;

public class MyArrayList implements Array {
    private static final int DEFAULT_CAPACITY = 10;
    private static final int SIZE_MULTIPLIER = 2;

    private String[] array;
    private int size;

    public MyArrayList() {
        this.array = new String[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public MyArrayList(int initSize) {
        if (initSize > 0) {
            this.array = new String[initSize];
            this.size = 0;
        } else {
            throw new IllegalArgumentException("Неверный размер массива" + initSize);
        }
    }

    public boolean add(String element) {
        add(size, element);
        return true;
    }

    public void add(int index, String element) {
        checkIndex(index);

        if (size == array.length) {
            array = Arrays.copyOf(array, array.length * SIZE_MULTIPLIER);
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        ++size;
    }

    public boolean addAll(Array c) {
        int prevSize = this.size;
        for (String string : c.toArray()) {
            add(string);
        }
        return this.size != prevSize;
    }

    public boolean addAll(int index, Array c) {
        checkIndex(index);

        int prevSize = this.size;
        String[] temp = c.toArray();
        for (int i = 0; i < temp.length; i++) {
            add(index + i, temp[i]);
        }
        return this.size != prevSize;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int indexOf(String o) {
        if (o == null) {
            for (int i = 0; i < this.size; ++i) {
                if (this.array[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < this.size; i++) {
                if (array[i].equals(o)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int lastIndexOf(String o) {
        if (o == null) {
            for (int i = this.size - 1; i >= 0; i--) {
                if (this.array[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = this.size - 1; i >= 0; i--) {
                if (o.equals(array[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean contains(String o) {
        return indexOf(o) != -1;
    }

    public boolean containsAll(Array c) {
        for (String string : c.toArray()) {
            if (!this.contains(string)) {
                return false;
            }
        }
        return true;
    }

    public String get(int index) {
        checkIndex(index);

        return array[index];
    }

    public String[] toArray() {
        return Arrays.copyOf(this.array, this.size);
    }

    public String set(int index, String element) {
        checkIndex(index);

        String bufString = this.array[index];
        this.array[index] = element;
        return bufString;
    }

    public String remove(int index) {
        checkIndex(index);
        
        String bufString = this.array[index];
        --size;
        System.arraycopy(array, index + 1, array, index, size - index);
        array[size] = null;
        return bufString;
    }

    public boolean remove(Object o) { // todo переделать как в linkedList
        if (o == null && this.contains(null)) {
            remove(indexOf(null));
            return true;
        } else {
            for (int i = 0; i < this.size; i++) {
                if (this.array[i].equals(o)) {
                    remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean removeAll(Array c) {
        int prevSize = this.size;
        for (String string : c.toArray()) {
            remove(string);
        }
        return this.size != prevSize;
    }

    public Array subList(int fromIndex, int toIndex) {
        Array buffer = new MyArrayList();
        for (int i = 0; i < this.size; i++) {
            if (i >= fromIndex && i < toIndex) {
                buffer.add(this.array[i]);
            }
        }
        return buffer;
    }

    public void clear() {
        array = new String[DEFAULT_CAPACITY];
        size = 0;
    }

    private void checkIndex(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is bigger than size " + size);
        }
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " is below zero");
        }
    }
}
