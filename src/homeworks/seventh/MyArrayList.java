package src.homeworks.seventh;

import java.util.Arrays;
import java.util.Objects;

import src.homeworks.seventh.interfaces.Array;

public class MyArrayList<T> implements Array<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final int SIZE_MULTIPLIER = 2;

    private T[] array;
    private int size = 0;

    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public MyArrayList(int initSize) {
        if (initSize > 0) {
            this.array = (T[]) new Object[initSize];
        } else {
            throw new IllegalArgumentException("Неверный размер массива" + initSize);
        }
    }

    public boolean add(T element) {
        add(size, element);
        return true;
    }

    public void add(int index, T element) {
        checkIndexForAdd(index);

        if (size == array.length) {
            array = Arrays.copyOf(array, array.length * SIZE_MULTIPLIER);
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        ++size;
    }

    public boolean addAll(Array<T> c) {
        checkCollection(c);
        int prevSize = this.size;
        for (int i = 0; i < c.size(); i++) {
            add(c.get(i));
        }
        return this.size != prevSize;
    }

    public boolean addAll(int index, Array<T> c) {
        checkCollection(c);
        checkIndexForAdd(index);

        int prevSize = this.size;
        for (int i = 0; i < c.size(); i++) {
            add(index + i, c.get(i));
        }
        return this.size != prevSize;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int indexOf(T o) {
        for (int i = 0; i < this.size; i++) {
            if (Objects.equals(array[i], o)) {
                return i;
            }
        }

        return -1;
    }

    public int lastIndexOf(T o) {
        for (int i = this.size - 1; i >= 0; i--) {
            if (Objects.equals(array[i], o)) {
                return i;
            }
        }

        return -1;
    }

    public boolean contains(T o) {
        return indexOf(o) != -1;
    }

    public boolean containsAll(Array<T> c) {
        checkCollection(c);
        
        for (int i = 0; i < c.size(); i++) {
            if (!contains(c.get(i))) {
                return false;
            }
        }
        return true;
    }

    public T get(int index) {
        checkIndex(index);

        return array[index];
    }

    public Object[] toArray() {
        return Arrays.copyOf(this.array, this.size);
    }

    @SuppressWarnings("unchecked")
    public T[] toArray(T[] a) {
        return (T[]) Arrays.copyOf(this.array, this.size, a.getClass());
    }

    public T set(int index, T element) {
        checkIndex(index);

        T bufElement = this.array[index];
        this.array[index] = element;
        return bufElement;
    }

    public T remove(int index) {
        checkIndex(index);

        T bufString = this.array[index];
        --size;
        System.arraycopy(array, index + 1, array, index, size - index);
        array[size] = null;
        return bufString;
    }

    public boolean remove(Object o) {
        for (int i = 0; i < this.size; i++) {
            if (Objects.equals(array[i], o)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean removeAll(Array<T> c) {
        checkCollection(c);
        int prevSize = this.size;
        for (int i = 0; i < c.size(); i++) {
            remove(c.get(i));
        }
        return this.size != prevSize;
    }

    public Array<T> subList(int fromIndex, int toIndex) {
        Array<T> buffer = new MyArrayList<>();
        for (int i = 0; i < this.size; i++) {
            if (i >= fromIndex && i < toIndex) {
                buffer.add(this.array[i]);
            }
        }
        return buffer;
    }

    @SuppressWarnings("unchecked")
    public void clear() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
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

    private void checkIndexForAdd(int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " is bigger than size " + size);
        }
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " is below zero");
        }
    }

    private void checkCollection(Array<T> c) {
        if (c == null) {
            throw new IllegalArgumentException("Переданная коллекция равна null");
        }
    }
}
