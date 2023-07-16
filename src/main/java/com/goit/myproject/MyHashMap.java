package com.goit.myproject;

public class MyHashMap {
    private static final int DEFAULT_CAPACITY = 16;

    private Node[] buckets;
    private int size;

    private class Node {
        private Object key;
        private Object value;
        private Node next;

        public Node(Object key, Object value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public MyHashMap() {
        buckets = new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    public void put(Object key, Object value) {
        int index = getBucketIndex(key);

        if (buckets[index] == null) {
            buckets[index] = new Node(key, value);
            size++;
        } else {
            Node currentNode = buckets[index];
            while (currentNode != null) {
                if (currentNode.key.equals(key)) {
                    currentNode.value = value;
                    return;
                }
                currentNode = currentNode.next;
            }

            Node newNode = new Node(key, value);
            newNode.next = buckets[index];
            buckets[index] = newNode;
            size++;
        }
    }

    public void remove(Object key) {
        int index = getBucketIndex(key);

        if (buckets[index] != null) {
            Node previousNode = null;
            Node currentNode = buckets[index];

            while (currentNode != null) {
                if (currentNode.key.equals(key)) {
                    if (previousNode == null) {
                        buckets[index] = currentNode.next;
                    } else {
                        previousNode.next = currentNode.next;
                    }
                    size--;
                    return;
                }

                previousNode = currentNode;
                currentNode = currentNode.next;
            }
        }
    }

    public void clear() {
        buckets = new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object get(Object key) {
        int index = getBucketIndex(key);

        Node currentNode = buckets[index];
        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                return currentNode.value;
            }
            currentNode = currentNode.next;
        }

        return null;
    }

    private int getBucketIndex(Object key) {
        if (key == null) {
            return 0;
        }

        int hashCode = key.hashCode();
        return hashCode % buckets.length;
    }
}

