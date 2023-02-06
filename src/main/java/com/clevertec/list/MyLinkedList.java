package com.clevertec.list;

import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T>{

    static class Node<T> {
        private Node<T> next;
        private Node<T> prev;
        private T data;

        Node(T data) {
            this.data = data;
        }

        Node() {
        }

        public T getData() {
            return data;
        }

        public Node<T> getNext() {
            return next;
        }
    }

    private int size = 0;
    private Node<T> head;
    private Node<T> tail;
    private Node<T> current;

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

    @Override
    public Iterator<T> iterator() {
        return new MyListIterator<>(this);
    }

    Node<T> getHead() {
        return head;
    }
}

class MyListIterator<T> implements Iterator<T> {
    private MyLinkedList.Node<T> current;

    MyListIterator(MyLinkedList<T> list) {
        current = list.getHead();
    }

    @Override
    public boolean hasNext() {
        return current.getNext() != null;
    }

    @Override
    public T next() {
        T data = current.getData();
        current = current.getNext();
        return data;
    }
}
