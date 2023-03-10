package com.clevertec.list;

import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T>{
    static class Node<T> {
        private Node<T> next;
        private Node<T> prev;
        private final T data;

        Node(T data) {
            this.data = data;
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

    public void add(T item, int index) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        Node<T> newNode = new Node<>(item);
        if(head == null) {
            head = tail = newNode;
        } else if(index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else if(index == size) {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        } else if(index < size / 2) {
            Node<T> current = head;
            for(int i = 0; i < index; i++) {
                current = current.next;
            }
            current.next.prev = newNode;
            newNode.next = current.next;
            newNode.prev = current;
            current.next = newNode;
        } else {
            Node<T> current = tail;
            for(int i = size - 1; i > index; i--) {
                current = current.prev;
            }
            current.prev.next = newNode;
            newNode.prev = current.prev;
            newNode.next = current;
            current.prev = newNode;
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
        --size;
    }

    private void shiftLinks(Node<T> current) {
        current.prev.next = current.next;
        current.next.prev = current.prev;
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
