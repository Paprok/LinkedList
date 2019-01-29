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
            this.last.setNext(newNode);
            newNode.setPrevious(this.last);
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
            previous.setNext(newNode);
            newNode.setPrevious(previous);
            newNode.setNext(next);
            next.setPrevious(newNode);
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
        if (index == 0) {
            removeFirstNode();
        } else
            removeTailNode(index);
    }

    private void removeFirstNode() {
        this.first = this.first.getNext();
        --this.size;
    }



    private void removeTailNode(int index) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException();
        } else {
            DoubleLinkedNode<T> previous = getNode(index - 1);
            removeNextNode(previous);
        }
    }

    private void removeNextNode(DoubleLinkedNode<T> node) throws IndexOutOfBoundsException {
        node.setNext(node.getNext().getNext());
        --this.size;
        if(node.getNext() == null){
            this.last = node;
        }
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
