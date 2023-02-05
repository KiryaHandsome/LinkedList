package com.clevertec.list;

public class MyLinkedList<T> {
    private static class Node<T> {
        private Node<T> next;
        private Node<T> prev;
        private T data;

        Node(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }
    }

    private int length = 0;
    private Node<T> head;
    private Node<T> tail;
}
