package src.homeworks.seventh;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

import src.homeworks.seventh.interfaces.Map;

public class MyHashMap<K, V> implements Map<K, V> {

    private static final int DEFAULT_CAPACITY = 16;
    private static final double DEFAULT_MAX_USAGE_PERCENT = 0.75;

    HashSet<Node<K, V>> allNodes = new HashSet<>();

    private Node<K, V>[] baskets;
    private int size;
    private int initCapacity;
    private double maxUsagePercent;

    public MyHashMap() {
        this(DEFAULT_CAPACITY, DEFAULT_MAX_USAGE_PERCENT);
    }

    public MyHashMap(int initCapacity) {
        this(initCapacity, DEFAULT_MAX_USAGE_PERCENT);
    }

    @SuppressWarnings("unchecked")
    public MyHashMap(int initCapacity, double maxUsagePercent) {
        if (initCapacity < 1 || maxUsagePercent < 0 || maxUsagePercent > 1) {
            throw new IllegalArgumentException("Check your arguments.");
        } else {
            baskets = new Node[initCapacity];
            this.initCapacity = initCapacity;
            this.maxUsagePercent = maxUsagePercent;
        }
    }

    @Override
    public V put(K key, V value) {
        int hash = computeHash(key);

        Node<K, V> newNode = new Node<>(hash, key, value);
        allNodes.add(newNode);

        if (baskets[hash % baskets.length] == null) {
            baskets[hash % baskets.length] = newNode;
            ++size;
        } else {
            Node<K, V> currNode = baskets[hash % baskets.length];
            do {
                if (Objects.equals(currNode.getKey(), key)) {
                    V prevValue = currNode.setValue(value);

                    allNodes.remove(newNode);

                    return prevValue;
                }
                if (currNode.next == null) {
                    currNode.next = newNode;
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
    public void putAll(Map<K, V> map) {
        if (map instanceof MyHashMap) {
            MyHashMap<K, V> map2 = (MyHashMap<K, V>) map;
            for (Node<K, V> node : map2.baskets) {
                if (node != null) {
                    do {
                        put(node.getKey(), node.getValue());
                        node = node.next;
                    } while (node != null);
                }
            }
        } else {
            throw new IllegalArgumentException("Argument is not of type MyHashMap");
        }
    }

    @SuppressWarnings("unchecked")
    private Node<K, V>[] resize() {
        Node<K, V>[] oldBaskets = baskets;
        initCapacity *= 2;
        Node<K, V>[] newBaskets = new Node[initCapacity];

        for (int i = 0; i < oldBaskets.length; i++) {
            if (oldBaskets[i] != null) {
                Node<K, V> currNode = oldBaskets[i];
                do {
                    if (newBaskets[currNode.getHash() % newBaskets.length] == null) {
                        newBaskets[currNode.getHash() % newBaskets.length] = currNode;
                    } else {
                        Node<K, V> nodeToComplete = newBaskets[currNode.getHash() % newBaskets.length];
                        do {
                            if (nodeToComplete.next == null) {
                                nodeToComplete.next = currNode;
                            }
                            nodeToComplete = nodeToComplete.next;
                        } while (nodeToComplete != null);
                    }

                    currNode = currNode.next;
                } while (currNode != null);
            }
        }
        return newBaskets;
    }

    @Override
    public V remove(K key) {
        int hash = computeHash(key);

        if (baskets[hash % baskets.length] != null) {
            Node<K, V> currNode = baskets[hash % baskets.length];
            Node<K, V> prevNode = null;
            do {
                if (Objects.equals(currNode.getKey(), key)) {
                    V removedValue = currNode.value;

                    allNodes.remove(currNode);

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
    public boolean containsKey(K key) {
        int hash = computeHash(key);

        if (baskets[hash % baskets.length] != null) {
            Node<K, V> currNode = baskets[hash % baskets.length];
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
    public boolean containsValue(V value) {
        for (Node<K, V> currNode : baskets) {
            if (currNode != null) {
                do {
                    if (Objects.equals(currNode.getValue(), value)) {
                        return true;
                    }
                    currNode = currNode.next;
                } while (currNode != null);
            }
        }
        return false;
    }

    @Override
    public V get(K key) {
        int hash = computeHash(key);

        if (baskets[hash % baskets.length] != null) {
            Node<K, V> currNode = baskets[hash % baskets.length];
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
    @SuppressWarnings("unchecked")
    public void clear() {
        size = 0;
        baskets = new Node[initCapacity];
    }

    public Object[] getAllKeys() {
        ArrayList<K> tmp = new ArrayList<>();
        for (Node<K, V> node : allNodes) {
            tmp.add(node.getKey());
        }
        return tmp.toArray();
    }

    public Object[] getAllValues() {
        ArrayList<V> tmp = new ArrayList<>();
        for (Node<K, V> node : allNodes) {
            tmp.add(node.getValue());
        }
        return tmp.toArray();
    }

    private int computeHash(K key) {
        return Math.abs(Objects.hashCode(key));
    }

    public static class Node<K, V> {
        private int hash;
        private K key;
        private V value;
        private Node<K, V> next;

        public Node(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }

        public V setValue(V newValue) {
            V prevValue = this.value;
            this.value = newValue;
            return prevValue;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public int getHash() {
            return hash;
        }
    }
}
