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

    public void add(int index, String o) {
        if (index > size) {
            throw new IndexOutOfBoundsException("Invalid index " + index);
        } else if (index == 0) {
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

    public boolean addAll(Linked c) {
        int prevSize = this.size;
        for (String string : c.toArray()) {
            add(string);
        }
        return this.size == prevSize;
    }

    public boolean addAll(int index, Linked c) {
        int prevSize = this.size;
        String[] tmpArray = c.toArray();
        for (int i = 0; i < tmpArray.length; i++) {
            add(index + i, tmpArray[i]);
        }
        return this.size == prevSize;
    }

    public String[] toArray() {
        MyArrayList outBuffer = new MyArrayList();

        for (Node currNode = firstElement; currNode != null; currNode = currNode.nextElement) {
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

    @Override
    public int indexOf(String o) {
        int index = 0;
        if (o == null) {
            for (Node currNode = firstElement; currNode != null; currNode = currNode.nextElement) {
                if (currNode.element == null) {
                    return index;
                }
                ++index;
            }
        } else {
            for (Node currNode = firstElement; currNode != null; currNode = currNode.nextElement) {
                if (o.equals(currNode.element)) {
                    return index;
                }
                ++index;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String o) {
        String[] tmp = this.toArray();
        if (o == null) {
            for (int i = tmp.length - 1; i >= 0; i--) {
                if (tmp[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = tmp.length - 1; i >= 0; i--) {
                if (o.equals(tmp[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public boolean contains(String o) {
        return indexOf(o) >= 0;
    }

    @Override
    public boolean containsAll(Linked c) {
        for (String string : c.toArray()) {
            if (!contains(string)) {
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
        if (index > size) {
            throw new IndexOutOfBoundsException("Too big index" + index);
        } else {
            Node currNode = firstElement;
            for (int i = 0; i < index; i++) {
                currNode = currNode.nextElement;
            }
            return currNode.element;
        }
    }

    @Override
    public String set(int index, String element) {
        if (index > size) {
            throw new IndexOutOfBoundsException("Too big index" + index);
        } else {
            Node currNode = firstElement;
            for (int i = 0; i < index; i++) {
                currNode = currNode.nextElement;
            }
            String buffer = currNode.element;
            currNode.element = element;
            return buffer;
        }
    }

    @Override
    public String remove(int index) {
        if (index == 0) {
            String buffer = firstElement.element;
            firstElement = firstElement.nextElement;
            --size;
            return buffer;
        } else if (index > size) {
            throw new IndexOutOfBoundsException("Invalid index " + index);
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
        for (String string : c.toArray()) {
            remove(string);
        }
        return this.size != prevSize;
    }

    @Override
    public Linked subList(int fromIndex, int toIndex) {
        if (fromIndex > toIndex || fromIndex > size || toIndex > size) {
            throw new IndexOutOfBoundsException("Check your indexes");
        } else {
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