package src.homeworks.seventh;

import java.util.Objects;

import src.homeworks.seventh.interfaces.Linked;

public class MyLinkedList<T> implements Linked<T> {

    private Node<T> firstElement;
    private Node<T> lastElement;

    private int size = 0;

    public MyLinkedList() {
        // конструктор по умолчанию
    }

    @Override
    public boolean add(T o) {
        Node<T> last = lastElement;
        Node<T> newNode = new Node<>(o, null);
        lastElement = newNode;
        if (last == null) {
            firstElement = newNode;
        } else {
            last.nextElement = newNode;
        }
        ++size;
        return true;
    }

    @Override
    public void add(int index, T o) {
        checkIndexForAdd(index);

        if (index == 0) {
            Node<T> currNode = new Node<>(o, firstElement);
            firstElement = currNode;
            ++size;
        } else {
            Node<T> prevNode = firstElement;
            for (int i = 0; i < index - 1; i++) {
                prevNode = prevNode.nextElement;
            }
            Node<T> currNode = new Node<>(o, prevNode.nextElement);
            prevNode.nextElement = currNode;
            if (index == size) {
                lastElement = currNode;
            }
            ++size;
        }
    }

    @Override
    public boolean addAll(Linked<T> c) {
        int prevSize = this.size;
        for (int i = 0; i < c.size(); i++) {
            add(c.get(i));
        }
        return this.size == prevSize;
    }

    @Override
    public boolean addAll(int index, Linked<T> c) {
        checkIndexForAdd(index);

        int prevSize = this.size;
        for (int i = 0; i < c.size(); i++) {
            add(index + i, c.get(i));
        }
        return this.size == prevSize;
    }

    @Override
    public Object[] toArray() {
        Object[] outBuffer = new Object[size];

        for (int i = 0; i < size; i++) {
            outBuffer[i] = get(i);
        }

        return outBuffer;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int indexOf(T o) {
        int index = -1;

        for (int i = 0; i < size; i++) {
            if (Objects.equals(get(i), o)) {
                return i;
            }
        }
        return index;
    }

    @Override
    public int lastIndexOf(T o) {
        int index = -1;

        for (int i = 0; i < size; i++) {
            if (Objects.equals(get(i), o)) {
                index = i;
            }
        }
        return index;
    }

    @Override
    public boolean contains(T o) {
        return indexOf(o) != -1;
    }

    @Override
    public boolean containsAll(Linked<T> c) {
        for (int i = 0; i < c.size(); i++) {
            if (!contains(c.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void clear() {
        firstElement = null;
        lastElement = null;
        size = 0;
    }

    @Override
    public T get(int index) {
        checkIndex(index);

        Node<T> currNode = firstElement;
        for (int i = 0; i < index; i++) {
            currNode = currNode.nextElement;
        }
        return currNode.element;
    }

    @Override
    public T set(int index, T element) {
        checkIndex(index);

        Node<T> currNode = firstElement;
        for (int i = 0; i < index; i++) {
            currNode = currNode.nextElement;
        }
        T buffer = currNode.element;
        currNode.element = element;
        return buffer;

    }

    @Override
    public T remove(int index) {
        checkIndex(index);

        if (index == 0) {
            T buffer = firstElement.element;
            firstElement = firstElement.nextElement;
            --size;
            return buffer;
        } else {
            Node<T> prevNode = firstElement;
            for (int i = 0; i < index - 1; i++) {
                prevNode = prevNode.nextElement;
            }
            T buffer = prevNode.nextElement.element;
            prevNode.nextElement = prevNode.nextElement.nextElement;
            if (index == size) {
                lastElement = prevNode;
            }
            --size;
            return buffer;
        }
    }

    @Override
    public boolean remove(Object o) { // как должна себя вести программа при передаче сюда не строки?
        for (int i = 0; i < size; i++) {
            if (Objects.equals(o, get(i))) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeAll(Linked<T> c) {
        int prevSize = this.size;
        for (int i = 0; i < c.size(); i++) {
            remove(c.get(i));
        }
        return this.size != prevSize;
    }

    @Override
    public MyLinkedList<T> subList(int fromIndex, int toIndex) {
        checkIndex(fromIndex);
        checkIndex(toIndex);
        if (fromIndex > toIndex) {
            throw new IndexOutOfBoundsException("fromIndex is bigger than toIndex");
        }

        MyLinkedList<T> buffer = new MyLinkedList<>();
        Node<T> currNode = firstElement;
        for (int i = 0; i < fromIndex - 1; i++) {
            currNode = currNode.nextElement;
        }
        for (int i = fromIndex; i < toIndex; i++) {
            buffer.add(currNode.element);
            currNode = currNode.nextElement;
        }

        return buffer;
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

    private static class Node<T> {
        private T element;
        private Node<T> nextElement;

        Node(T element, Node<T> next) {
            this.element = element;
            this.nextElement = next;
        }

    }
}