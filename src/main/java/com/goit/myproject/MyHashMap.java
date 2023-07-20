package com.goit.myproject;

public class MyHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private Node<K, V>[] buckets;
    private int size;

    @SuppressWarnings("unchecked")
    private static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        buckets = new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    public void put(K key, V value) {
        int index = getBucketIndex(key);

        if (buckets[index] == null) {
            buckets[index] = new Node<>(key, value);
            size++;
        } else {
            Node<K, V> currentNode = buckets[index];
            while (currentNode != null) {
                if (currentNode.key.equals(key)) {
                    currentNode.value = value;
                    return;
                }
                currentNode = currentNode.next;
            }

            Node<K, V> newNode = new Node<>(key, value);
            newNode.next = buckets[index];
            buckets[index] = newNode;
            size++;
        }

        if (size >= buckets.length * 0.75) {
            resizeArray();
        }
    }

    public void remove(K key) {
        int index = getBucketIndex(key);

        if (buckets[index] != null) {
            Node<K, V> previousNode = null;
            Node<K, V> currentNode = buckets[index];

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

    public V get(K key) {
        int index = getBucketIndex(key);

        Node<K, V> currentNode = buckets[index];
        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                return currentNode.value;
            }
            currentNode = currentNode.next;
        }

        return null;
    }

    private int getBucketIndex(K key) {
        if (key == null) {
            return 0;
        }

        int hashCode = key.hashCode();
        int index = hashCode & (buckets.length - 1);
        return index;
    }

    @SuppressWarnings("unchecked")
    private void resizeArray() {
        int newCapacity = buckets.length * 2;
        Node<K, V>[] newBuckets = new Node[newCapacity];

        for (Node<K, V> bucket : buckets) {
            Node<K, V> currentNode = bucket;
            while (currentNode != null) {
                int newIndex = getBucketIndex(currentNode.key);

                Node<K, V> newNode = new Node<>(currentNode.key, currentNode.value);
                newNode.next = newBuckets[newIndex];
                newBuckets[newIndex] = newNode;

                currentNode = currentNode.next;
            }
        }

        buckets = newBuckets;
    }
}

