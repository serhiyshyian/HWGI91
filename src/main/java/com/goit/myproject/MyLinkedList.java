package com.goit.myproject;

public class MyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    private class Node {
        private Object value;
        private Node previous;
        private Node next;

        public Node(Object value) {
            this.value = value;
            this.previous = null;
            this.next = null;
        }
    }

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(Object value) {
        Node newNode = new Node(value);

        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }

        size++;
    }

    public void remove(int index) {
        if (index >= 0 && index < size) {
            if (index == 0) {
                head = head.next;
                if (head != null) {
                    head.previous = null;
                }
            } else if (index == size - 1) {
                tail = tail.previous;
                tail.next = null;
            } else {
                Node currentNode = getNodeAtIndex(index);
                Node previousNode = currentNode.previous;
                Node nextNode = currentNode.next;

                previousNode.next = nextNode;
                nextNode.previous = previousNode;
            }

            size--;
        } else {
            throw new IndexOutOfBoundsException("Invalid index");
        }
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object get(int index) {
        if (index >= 0 && index < size) {
            Node node = getNodeAtIndex(index);
            return node.value;
        } else {
            throw new IndexOutOfBoundsException("Invalid index");
        }
    }

    private Node getNodeAtIndex(int index) {
        Node currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }
}

