package com.codecool.krk;

public class LinkedList<T> {
    private LinkedNode<T> first;
    private LinkedNode<T> last;
    private int size;

    public LinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public void append(T item) {
        if (size > 0) {
            LinkedNode<T> newNode = new LinkedNode<>(item);
            this.last.setNext(newNode);
            this.last = newNode;
            this.size++;
        } else {
            LinkedNode<T> newNode = new LinkedNode<>(item);
            this.first = newNode;
            this.last = newNode;
            this.size++;
        }
    }

    public void add(int index, T item) throws IndexOutOfBoundsException {
        LinkedNode<T> newNode = new LinkedNode<>(item);
        if (index == 0) {
            newNode.setNext(this.first);
            this.first = newNode;
            if(this.size == 0){
                this.last = newNode;
            }
        } else {
            LinkedNode<T> previous = getNode(index - 1);
            LinkedNode<T> next = previous.getNext();
            previous.setNext(newNode);
            newNode.setNext(next);
        }
        this.size++;
    }

    public void add(T item) {
        append(item);
    }

    public void remove(int index, T item) throws IndexOutOfBoundsException {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            LinkedNode<T> previous = getNode(index -1);
            removeNode(previous);
        }
    }

    private void removeNode(LinkedNode<T> node) {
            node.setNext(node.getNext().getNext());
            --this.size;
    }

    private LinkedNode<T> getNode(int index) throws IndexOutOfBoundsException {
        LinkedNode<T> node;
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            node = this.first;
            for (int i = 0; i < index; i++) {
                node = node.getNext();
            }
        }
        return node;
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        LinkedNode<T> node = this.first;
        while(node!=null){
            builder.append(node.getValue());
            builder.append(' ');
            node = node.getNext();
        }
        return builder.toString().trim();
    }
}
