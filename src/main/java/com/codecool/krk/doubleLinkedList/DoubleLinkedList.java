package com.codecool.krk.doubleLinkedList;


public class DoubleLinkedList<T> {
    private DoubleLinkedNode<T> first;
    private DoubleLinkedNode<T> last;
    private int size;

    public DoubleLinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public void append(T item) {
        if (size > 0) {
            DoubleLinkedNode<T> newNode = new DoubleLinkedNode<>(item);
            connectNodes(this.last, newNode);
            this.last = newNode;
            this.size++;
        } else {
            DoubleLinkedNode<T> newNode = new DoubleLinkedNode<>(item);
            this.first = newNode;
            this.last = newNode;
            this.size++;
        }
    }

    public void add(int index, T item) throws IndexOutOfBoundsException {
        //TODO refactor using getNode(index)
        DoubleLinkedNode<T> newNode = new DoubleLinkedNode<>(item);
        if (index == 0) {
            DoubleLinkedNode<T> next = this.first;
            this.first = newNode;
            newNode.setNext(next);
            if(next != null) {
                next.setPrevious(newNode);
            }
        } else if (index == size) {
            DoubleLinkedNode<T> previous = this.last;
            this.last = newNode;
            newNode.setPrevious(previous);
            if(previous != null) {
                previous.setNext(newNode);
            }

        } else {
            DoubleLinkedNode<T> previous = getNode(index - 1);
            DoubleLinkedNode<T> next = previous.getNext();
            connectNodes(previous, newNode);
            connectNodes(newNode, next);
        }
        this.size++;
    }

    public void add(T item) {
        append(item);
    }

    private DoubleLinkedNode<T> getNode(int index) throws IndexOutOfBoundsException {
        DoubleLinkedNode<T> node;
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            node = findNode(index);
        }
        return node;
    }

    private DoubleLinkedNode<T> findNode(int index) {
        DoubleLinkedNode<T> node;
        if(index<size/2) {
            node = searchFromFirst(index);
        } else {
            node = searchFromLast(index);
        }
        return node;
    }

    private DoubleLinkedNode<T> searchFromLast(int index) {
        DoubleLinkedNode<T> node;
        node = this.last;
        for (int i = size -1; i > index; i--) {
            node = node.getPrevious();
        }
        return node;
    }

    private DoubleLinkedNode<T> searchFromFirst(int index) {
        DoubleLinkedNode<T> node;
        node = this.first;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node;
    }

    public void remove(int index) throws IndexOutOfBoundsException {
        DoubleLinkedNode<T> toRemove = getNode(index);
        DoubleLinkedNode<T> previous = toRemove.getPrevious();
        DoubleLinkedNode<T> next = toRemove.getNext();
        if (size == 1) {
            this.first = null;
            this.last = null;
        } else if (previous == null) {
            this.first = next;
            next.setPrevious(null);
        } else if (next == null) {
            this.last = previous;
            previous.setNext(null);
        } else {
            connectNodes(previous, next);
        }
        --this.size;
    }

    private void connectNodes(DoubleLinkedNode<T> previous, DoubleLinkedNode<T> next) {
        previous.setNext(next);
        next.setPrevious(previous);
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        DoubleLinkedNode<T> node = this.first;
        while (node != null) {
            builder.append(node.getValue());
            builder.append(' ');
            node = node.getNext();
        }
        return builder.toString().trim();
    }
}
