package src.homeworks.seventh;

import java.util.Arrays;
import java.util.Objects;

import src.homeworks.seventh.interfaces.Array;
public class MyArrayList<T> implements Array<T>{
    private static final int DEFAULT_CAPACITY = 10;
    private static final int SIZE_MULTIPLIER = 2;

    private Object[] array;
    private int size;

    public MyArrayList() {
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public MyArrayList(int initSize) {
        if (initSize > 0) {
            this.array = new Object[initSize];
            this.size = 0;
        } else {
            throw new IllegalArgumentException("Неверный размер массива" + initSize);
        }
    }

    public boolean add(T element) {
        add(size, element);
        return true;
    }

    public void add(int index, T element) {
        checkIndex(index);
        if (size == array.length) {
            array = Arrays.copyOf(array, array.length * SIZE_MULTIPLIER);
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        ++size;
    }

    @SuppressWarnings("unchecked")
    public boolean addAll(Array<T> c) {
        int prevSize = this.size;
        for (Object o : c.toArray()) {
            add((T) o);
        }
        return this.size != prevSize;
    }

    @SuppressWarnings("unchecked")
    public boolean addAll(int index, Array<T> c) {
        checkIndex(index);
        int prevSize = this.size;
        Object[] temp = c.toArray();
        for (int i = 0; i < temp.length; i++) {
            add(index + i, (T) temp[i]);
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

    public int lastIndexOf(T o) {
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

    public boolean contains(T o) {
        return indexOf(o) != -1;
    }

    @SuppressWarnings("unchecked")
    public boolean containsAll(Array<T> c) {
        for (Object o : c.toArray()) {
            if (!this.contains((T) o)) {
                return false;
            }
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        checkIndex(index);
        return (T) array[index];
    }

    @SuppressWarnings("unchecked")
    public T[] toArray() {
        return (T[]) Arrays.copyOf(this.array, this.size);
    }

    @SuppressWarnings("unchecked")
    public T set(int index, T element) {
        checkIndex(index);
        T bufElement = (T) this.array[index];
        this.array[index] = element;
        return bufElement;
    }

    @SuppressWarnings("unchecked")
    public T remove(int index) {
        checkIndex(index);
        T bufString = (T) this.array[index];
        --size;
        System.arraycopy(array, index + 1, array, index, size - index);
        array[size] = null;
        return bufString;
    }

    public boolean remove(Object o) {
        for (int i = 0; i < this.size; i++) {
            if (Objects.equals(o, get(i))) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean removeAll(Array<T> c) {
        int prevSize = this.size;
        for (Object o : c.toArray()) {
            remove(o);
        }
        return this.size != prevSize;
    }

    @SuppressWarnings("unchecked")
    public MyArrayList<T> subList(int fromIndex, int toIndex) {
        MyArrayList<T> buffer = new MyArrayList<>();
        for (int i = 0; i < this.size; i++) {
            if (i >= fromIndex && i < toIndex) {
                buffer.add((T) this.array[i]);
            }
        }
        return buffer;
    }

    public void clear() {
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is bigger than size " + size);
        }
    }

}
