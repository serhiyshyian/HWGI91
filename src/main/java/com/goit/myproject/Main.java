package com.goit.myproject;

public class Main {
    public static void main(String[] args) {

        testArrayList();
        testLinkedList();
        testQueue();
        testStack();
        testHashMap();
    }

    private static void testArrayList() {
        MyArrayList<Integer> arrayList = new MyArrayList<>();

        for (int i = 1; i <= 1000000; i++) {
            arrayList.add(i);
        }

        System.out.println("ArrayList size: " + arrayList.size());

        arrayList.remove(0);

        System.out.println("ArrayList size after removal: " + arrayList.size());

        arrayList.clear();

        System.out.println("ArrayList size after clearing: " + arrayList.size());
    }

    private static void testLinkedList() {
        MyLinkedList<String> linkedList = new MyLinkedList<>();

        for (int i = 1; i <= 1000000; i++) {
            linkedList.add("Node_" + i);
        }

        System.out.println("LinkedList size: " + linkedList.size());

        linkedList.remove(0);

        System.out.println("LinkedList size after removal: " + linkedList.size());

        linkedList.clear();

        System.out.println("LinkedList size after clearing: " + linkedList.size());
    }

    private static void testQueue() {
        MyQueue<Character> queue = new MyQueue<>();

        for (char c = 'A'; c <= 'Z'; c++) {
            queue.add(c);
        }

        System.out.println("Queue size: " + queue.size());

        char firstElement = queue.peek();
        System.out.println("First element: " + firstElement);

        queue.poll();
        System.out.println("Queue size after poll: " + queue.size());
    }

    private static void testStack() {
        MyStack<Double> stack = new MyStack<>();

        for (int i = 1; i <= 1000000; i++) {
            stack.push(Math.sqrt(i));
        }

        System.out.println("Stack size: " + stack.size());

        double topElement = stack.peek();
        System.out.println("Top element: " + topElement);

        stack.pop();
        System.out.println("Stack size after pop: " + stack.size());
    }

    private static void testHashMap() {
        MyHashMap<String, Integer> hashMap = new MyHashMap<>();

        for (int i = 1; i <= 1000000; i++) {
            hashMap.put("Key_" + i, i);
        }

        System.out.println("HashMap size: " + hashMap.size());

        Integer value = hashMap.get("Key_500000");
        System.out.println("Value for key 'Key_500000': " + value);

        hashMap.remove("Key_100000");
        System.out.println("HashMap size after removal: " + hashMap.size());

        hashMap.clear();
        System.out.println("HashMap size after clearing: " + hashMap.size());
    }
}

