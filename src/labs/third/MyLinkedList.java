package src.labs.third;

import java.util.Objects;

import src.labs.third.interfaces.Linked;

public class MyLinkedList implements Linked {

    private Node firstElement;
    private Node lastElement;

    private int size = 0;

    public MyLinkedList() {
        // конструктор по умолчанию
    }

    @Override
    public boolean add(String o) {
        Node last = lastElement;
        Node newNode = new Node(o, null);
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
    public void add(int index, String o) {
        checkIndexForAdd(index);

        if (index == 0) {
            Node currNode = new Node(o, firstElement);
            firstElement = currNode;
            ++size;
        } else {
            Node prevNode = firstElement;
            for (int i = 0; i < index - 1; i++) {
                prevNode = prevNode.nextElement;
            }
            Node currNode = new Node(o, prevNode.nextElement);
            prevNode.nextElement = currNode;
            if (index == size) {
                lastElement = currNode;
            }
            ++size;
        }
    }

    @Override
    public boolean addAll(Linked c) {
        int prevSize = this.size;
        for (int i = 0; i < c.size(); i++) {
            add(c.get(i));
        }
        return this.size == prevSize;
    }

    @Override
    public boolean addAll(int index, Linked c) {
        checkIndexForAdd(index);

        int prevSize = this.size;
        for (int i = 0; i < c.size(); i++) {
            add(index + i, c.get(i));
        }
        return this.size == prevSize;
    }

    @Override
    public String[] toArray() {
        String[] outBuffer = new String[size];

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
    public int indexOf(String o) {
        int index = -1;

        for (int i = 0; i < size; i++) {
            if (Objects.equals(get(i), o)) {
                return i;
            }
        }
        return index;
    }

    @Override
    public int lastIndexOf(String o) {
        int index = -1;

        for (int i = 0; i < size; i++) {
            if (Objects.equals(get(i), o)) {
                index = i;
            }
        }
        return index;
    }

    @Override
    public boolean contains(String o) {
        return indexOf(o) != -1;
    }

    @Override
    public boolean containsAll(Linked c) {
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
    public String get(int index) {
        checkIndex(index);

        Node currNode = firstElement;
        for (int i = 0; i < index; i++) {
            currNode = currNode.nextElement;
        }
        return currNode.element;

    }

    @Override
    public String set(int index, String element) {
        checkIndex(index);

        Node currNode = firstElement;
        for (int i = 0; i < index; i++) {
            currNode = currNode.nextElement;
        }
        String buffer = currNode.element;
        currNode.element = element;
        return buffer;

    }

    @Override
    public String remove(int index) {
        checkIndex(index);

        if (index == 0) {
            String buffer = firstElement.element;
            firstElement = firstElement.nextElement;
            --size;
            return buffer;
        } else {
            Node prevNode = firstElement;
            for (int i = 0; i < index - 1; i++) {
                prevNode = prevNode.nextElement;
            }
            String buffer = prevNode.nextElement.element;
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
    public boolean removeAll(Linked c) {
        int prevSize = this.size;
        for (int i = 0; i < c.size(); i++) {
            remove(c.get(i));
        }
        return this.size != prevSize;
    }

    @Override
    public Linked subList(int fromIndex, int toIndex) {
        checkIndex(fromIndex);
        checkIndex(toIndex);
        if (fromIndex > toIndex) {
            throw new IndexOutOfBoundsException("fromIndex is bigger than toIndex");
        }

        Linked buffer = new MyLinkedList();
        Node currNode = firstElement;
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

    private static class Node {
        private String element;
        private Node nextElement;

        Node(String element, Node next) {
            this.element = element;
            this.nextElement = next;
        }

    }
}