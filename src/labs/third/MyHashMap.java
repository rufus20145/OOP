package src.labs.third;

import java.util.Objects;

import src.labs.third.interfaces.Map;

public class MyHashMap implements Map {

    private static final int DEFAULT_CAPACITY = 16;
    private static final double DEFAULT_MAX_USAGE_PERCENT = 0.75;

    private Node[] baskets;
    private int size;
    private int initCapacity;
    private double maxUsagePercent;

    public MyHashMap() {
        this(DEFAULT_CAPACITY, DEFAULT_MAX_USAGE_PERCENT);
    }

    public MyHashMap(int initCapacity) {
        this(initCapacity, DEFAULT_MAX_USAGE_PERCENT);
    }

    public MyHashMap(int initCapacity, double maxUsagePercent) {
        if (initCapacity < 1) {
            throw new IllegalArgumentException("initCapacity must be greater than 0");
        } else {
            baskets = new Node[initCapacity];
            this.initCapacity = initCapacity;
            this.maxUsagePercent = maxUsagePercent;
        }
    }

    @Override
    public Integer put(String key, Integer value) {
        int hash = computeHash(key);

        if (baskets[hash % baskets.length] == null) {
            baskets[hash % baskets.length] = new Node(hash, key, value, null);
            ++size;
        } else {
            Node currNode = baskets[hash % baskets.length];
            do {
                if (Objects.equals(currNode.getKey(), key)) {
                    Integer oldValue = currNode.value;
                    currNode.setValue(value);
                    return oldValue;
                }
                if (currNode.next == null) {
                    currNode.next = new Node(hash, key, value, null);
                    ++size;
                    break;
                }
                currNode = currNode.next;
            } while (currNode != null);
        }
        if (size > initCapacity * maxUsagePercent) {
            baskets = resize();
        }
        return null;
    }

    @Override
    public void putAll(Map map) {
        MyHashMap map2 = (MyHashMap) map;
        for (Node node : map2.baskets) {
            if (node != null) {
                do {
                    put(node.getKey(), node.getValue());
                    node = node.next;
                } while (node != null);
            }
        }
    }

    private Node[] resize() {
        Node[] oldBaskets = baskets;
        initCapacity *= 2;
        Node[] newBaskets = new Node[initCapacity];

        for (int i = 0; i < oldBaskets.length; i++) {
            if (oldBaskets[i] != null) {
                Node currNode = baskets[i];
                do {
                    newBaskets[currNode.getHash() % newBaskets.length] = currNode;
                    currNode = currNode.next;
                } while (currNode != null);
            }
        }
        return newBaskets;
    }

    @Override
    public Integer remove(String key) {
        int hash = computeHash(key);

        if (baskets[hash % baskets.length] != null) {
            Node currNode = baskets[hash % baskets.length];
            Node prevNode = null;
            do {
                if (Objects.equals(currNode.getKey(), key)) {
                    Integer removedValue = currNode.value;
                    if (prevNode == null) {
                        baskets[hash % baskets.length] = currNode.next;
                    } else {
                        prevNode.next = currNode.next;
                    }
                    --size;
                    return removedValue;
                }
                prevNode = currNode;
                currNode = currNode.next;
            } while (currNode != null);
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(String key) {
        int hash = computeHash(key);

        if (baskets[hash % baskets.length] != null) {
            Node currNode = baskets[hash % baskets.length];
            do {
                if (Objects.equals(currNode.getKey(), key)) {
                    return true;
                }
                currNode = currNode.next;
            } while (currNode != null);
        }
        return false;
    }

    @Override
    public boolean containsValue(Integer value) {
        for (Node node : baskets) {
            if (node != null) {
                do {
                    if (Objects.equals(node.getValue(), value)) {
                        return true;
                    }
                    node = node.next;
                } while (node != null);
            }
        }
        return false;
    }

    @Override
    public Integer get(String key) {
        int hash = computeHash(key);

        if (baskets[hash % baskets.length] != null) {
            Node currNode = baskets[hash % baskets.length];
            do {
                if (Objects.equals(currNode.getKey(), key)) {
                    return currNode.getValue();
                }
                currNode = currNode.next;
            } while (currNode != null);
        }
        return null;
    }

    @Override
    public void clear() {
        size = 0;
        baskets = new Node[initCapacity];
    }

    private static int computeHash(String key) {
        int hash = 0;
        if (key != null) {
            int keyLength = key.length();
            for (char digit : key.toCharArray()) {
                hash += (int) digit * keyLength--; // -- здесь специально для уменьшения
                                                   // keyLength после использования
            }
        }
        return hash;
    }

    private static class Node {
        private int hash;
        private String key;
        private Integer value;
        private Node next;

        public Node(int hash, String key, Integer value, Node next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Integer setValue(Integer newValue) {
            Integer prevValue = this.value;
            this.value = newValue;
            return prevValue;
        }

        public String getKey() {
            return key;
        }

        public Integer getValue() {
            return value;
        }

        public int getHash() {
            return hash;
        }
    }
}
