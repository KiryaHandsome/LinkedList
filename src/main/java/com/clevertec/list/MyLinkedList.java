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
            throw new IndexOutOfBoundsException();
        }
        Node<T> current;
        if(index < size / 2) {
            current = head;
            for(int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for(int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current.data;
    }

    public int size() {
        return size;
    }

}
