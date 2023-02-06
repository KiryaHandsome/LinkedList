package com.clevertec.list;

public class MyLinkedList<T> {
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

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        Node<T> current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current.data;
    }

    public int size() {
        return size;
    }

    public void remove(T item) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(item)) {
                if (current == head && current == tail) {
                    head = tail = null;
                } else if (current == head) {
                    head = head.next;
                } else if (current == tail) {
                    tail = tail.prev;
                } else {
                    shiftLinks(current);
                }
                --size;
                return;
            }
            current = current.next;
        }
        throw new IndexOutOfBoundsException("No element with value " + item + "in list");
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (index == 0) {
            head = head.next;
        } else if (index == size - 1) {
            tail = tail.prev;
        } else if (index < size / 2) {
            Node<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            shiftLinks(current);
        } else {
            Node<T> current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
            shiftLinks(current);
        }
    }

    private void shiftLinks(Node<T> current) {
        current.prev.next = current.next;
        current.next.prev = current.prev;
    }
}
