package com.codecool.krk.doubleLinkedList;

public class DoubleLinkedNode<T> {
    private DoubleLinkedNode next;
    private DoubleLinkedNode previous;
    private T value;

    public DoubleLinkedNode(T value) {
        this.value = value;
        this.previous = null;
        this.next = null;
    }

    public DoubleLinkedNode getNext() {
        return next;
    }

    public void setNext(DoubleLinkedNode next) {
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public DoubleLinkedNode getPrevious() {
        return previous;
    }

    public void setPrevious(DoubleLinkedNode previous) {
        this.previous = previous;
    }
}
