package com.codecool.krk;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

    private void fillListWithNumbers(LinkedList<Integer> list, int last) {
        for (int i = 0; i <= last; i++) {
            list.append(i);
        }
    }

    @Test
    void testAppendOneItem() {
        LinkedList<Integer> list = new LinkedList<>();
        list.append(1);

        String expected = "1";
        String actual = list.toString();

        assertEquals(expected, actual);
    }

    @Test
    void testAppendMultipleItems() {
        LinkedList<Integer> list = new LinkedList<>();
        fillListWithNumbers(list, 5);
        list.append(100);
        list.append(200);

        String expected = "0 1 2 3 4 5 100 200";
        String actual = list.toString();

        assertEquals(expected, actual);
    }

    @Test
    void testAddTo0IndexEmptyList() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0, 666);

        String expected = "666";
        String actual = list.toString();

        assertEquals(expected, actual);
    }

    @Test
    void testAddTo0IndexFilledList() {
        LinkedList<Integer> list = new LinkedList<>();
        fillListWithNumbers(list, 6);
        list.add(0, 666);

        String expected = "666 0 1 2 3 4 5 6";
        String actual = list.toString();

        assertEquals(expected, actual);
    }

    @Test
    void testAddToNegativeIndexThrowsException(){
        LinkedList<Integer> list = new LinkedList<>();

        assertThrows(IndexOutOfBoundsException.class,

                ()-> list.add(-1, 1));
    }

    @Test
    void testAddToIndexHigherThanSizeThrowsException(){
        LinkedList<Integer> list = new LinkedList<>();
        list.append(1);

        assertThrows(IndexOutOfBoundsException.class,

                ()-> list.add(99, 1));
    }

    @Test
    void testAddToMidIndex(){
        LinkedList<Integer> list = new LinkedList<>();
        fillListWithNumbers(list, 6);
        list.add(3, 666);

        String expected = "0 1 2 666 3 4 5 6";
        String actual = list.toString();

        assertEquals(expected, actual);
    }

    @Test
    void testAddToLastIndex(){
        LinkedList<Integer> list = new LinkedList<>();
        fillListWithNumbers(list, 6);
        list.add(7, 666);

        String expected = "0 1 2 3 4 5 6 666";
        String actual = list.toString();

        assertEquals(expected, actual);
    }

    
}
