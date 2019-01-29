package com.codecool.krk;

public class LinkedNode<T> {
//    private int index;
    private LinkedNode next;
    private T value;

    public LinkedNode(T value) {
        this.value = value;
    }

    public LinkedNode getNext() {
        return next;
    }

    public void setNext(LinkedNode next) {
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}