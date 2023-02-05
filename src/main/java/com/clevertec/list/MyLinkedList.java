package com.clevertec.list;

public class MyLinkedList<T>  {
    static class Node<T> {
        private Node<T> next;
        private Node<T> prev;
        private T data;

        Node(T data) {
            this.data = data;
        }

        Node() {
        }
    }

    private int size = 0;
    private Node<T> head;
    private Node<T> tail;

    public MyLinkedList() {
    }

    public void add(T item) {
        Node<T> newNode = new Node<>(item);
        if (tail == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        ++size;
    }

    //TODO: iterate in both directions
    public T get(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        Node<T> current = head;
        while(index > 0) {
            current = current.next;
            --index;
        }
        return current.data;
    }

    public int size() {
        return size;
    }

    public void remove(T item) {
        Node<T> current = head;
        while(current != null) {
            if(current.data.equals(item)) {
                if(current == head && current == tail) {
                    head = tail = null;
                } else if(current == head) {
                    head = head.next;
                } else if(current == tail) {
                    tail = tail.prev;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                return;
            }
            current = current.next;
        }
        throw new IndexOutOfBoundsException("No element with value " + item + "in list");
    }

    public void remove(int index) {

    }
}
