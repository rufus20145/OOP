package src.homeworks.seventh;

import java.util.Objects;

public class MyLinkedList<T> {

    private Node<T> firstElement;
    private Node<T> lastElement;

    private int size = 0;

    public MyLinkedList() {
        // конструктор по умолчанию
    }

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

    public void add(int index, T o) {
        if (index > size) {
            throw new IndexOutOfBoundsException("Invalid index " + index);
        } else if (index == 0) {
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

    public boolean addAll(MyLinkedList<T> c) {
        int prevSize = this.size;
        for (T t : c.toArray()) {
            add(t);
        }
        return this.size == prevSize;
    }

    public boolean addAll(int index, MyLinkedList<T> c) {
        int prevSize = this.size;
        T[] tmpArray = c.toArray();
        for (int i = 0; i < tmpArray.length; i++) {
            add(index + i, tmpArray[i]);
        }
        return this.size == prevSize;
    }

    public T[] toArray() {
        MyArrayList<T> outBuffer = new MyArrayList<>();

        for (Node<T> currNode = firstElement; currNode != null; currNode = currNode.nextElement) {
            outBuffer.add(currNode.element);
        }
        return outBuffer.toArray();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int indexOf(T o) {
        T[] tmp = this.toArray();
        for (int i = 0; i < tmp.length; i++) {
            if(Objects.equals(o, tmp[i])) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T o) {
        T[] tmp = this.toArray();

        for (int i = tmp.length; i >= 0; i--) {
            if(Objects.equals(o, tmp[i])) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(T o) {
        return indexOf(o) >= 0;
    }

    public boolean containsAll(MyLinkedList<T> c) {
        for (T t : c.toArray()) {
            if (!contains(t)) {
                return false;
            }
        }
        return true;
    }

    public void clear() {
        firstElement = null;
        lastElement = null;
        size = 0;
    }

    public T get(int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException("Too big index" + index);
        } else {
            Node<T> currNode = firstElement;
            for (int i = 0; i < index; i++) {
                currNode = currNode.nextElement;
            }
            return currNode.element;
        }
    }

    public T set(int index, T element) {
        if (index > size) {
            throw new IndexOutOfBoundsException("Too big index" + index);
        } else {
            Node<T> currNode = firstElement;
            for (int i = 0; i < index; i++) {
                currNode = currNode.nextElement;
            }
            T buffer = currNode.element;
            currNode.element = element;
            return buffer;
        }
    }

    public T remove(int index) {
        if (index == 0) {
            T buffer = firstElement.element;
            firstElement = firstElement.nextElement;
            --size;
            return buffer;
        } else if (index > size) {
            throw new IndexOutOfBoundsException("Invalid index " + index);
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

    public boolean remove(Object o) { // как должна себя вести программа при передаче сюда не строки?
        for (int i = 0; i < size; i++) {
            if (Objects.equals(o, get(i))) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean removeAll(MyLinkedList<T> c) {
        int prevSize = this.size;
        for (T t : c.toArray()) {
            remove(t);
        }
        return this.size != prevSize;
    }

    public MyLinkedList<T> subList(int fromIndex, int toIndex) {
        if (fromIndex > toIndex || fromIndex > size || toIndex > size) {
            throw new IndexOutOfBoundsException("Check your indexes");
        } else {
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