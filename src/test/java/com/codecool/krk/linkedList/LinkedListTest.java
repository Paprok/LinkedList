package com.codecool.krk.linkedList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

    private void fillListWithNumbers(LinkedList<Integer> list, int last) {
        for (int i = 0; i <= last; i++) {
            list.append(i);
        }
    }

    @Test
    void testToStringOnEmptyList() {
        LinkedList<Integer> list = new LinkedList<>();

        String expected = "";
        String actual = list.toString();

        assertEquals(expected, actual);
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
    void testGetSize() {
        LinkedList<Integer> list = new LinkedList<>();
        fillListWithNumbers(list, 5);

        int expected = 6;
        int actual = list.getSize();

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
    void testAddToNegativeIndexThrowsException() {
        LinkedList<Integer> list = new LinkedList<>();

        assertThrows(IndexOutOfBoundsException.class,

                () -> list.add(-1, 1)
        );
    }

    @Test
    void testAddToIndexHigherThanSizeThrowsException() {
        LinkedList<Integer> list = new LinkedList<>();
        list.append(1);

        assertThrows(IndexOutOfBoundsException.class,

                () -> list.add(99, 1)
        );
    }

    @Test
    void testAddToMidIndex() {
        LinkedList<Integer> list = new LinkedList<>();
        fillListWithNumbers(list, 6);
        list.add(3, 666);

        String expected = "0 1 2 666 3 4 5 6";
        String actual = list.toString();

        assertEquals(expected, actual);
    }

    @Test
    void testAddToLastIndex() {
        LinkedList<Integer> list = new LinkedList<>();
        fillListWithNumbers(list, 6);
        list.add(7, 666);

        String expected = "0 1 2 3 4 5 6 666";
        String actual = list.toString();

        assertEquals(expected, actual);
    }

    @Test
    void testRemoveNegativeIndexThrowsException() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0);

        assertThrows(IndexOutOfBoundsException.class,

                () -> list.remove(-1)
        );
    }

    @Test
    void testRemoveIndexHigherThanLastThrowsException() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0);

        assertThrows(IndexOutOfBoundsException.class,

                () -> list.remove(list.getSize())
        );
    }

    @Test
    void testRemoveOnlyItem() {
        LinkedList<Integer> list = removeOnlyItem();

        String expected = "";
        String actual = list.toString();

        assertEquals(expected, actual);
    }

    private LinkedList<Integer> removeOnlyItem() {
        LinkedList<Integer> list = new LinkedList<>();
        list.append(0);
        list.remove(0);
        return list;
    }

    @Test
    void testAppendAfterRemoveOnlyItem() {
        LinkedList<Integer> list = removeOnlyItem();

        list.append(666);
        String expected = "666";
        String actual = list.toString();

        assertEquals(expected, actual);
    }

    @Test
    void testRemoveMidItem() {
        LinkedList<Integer> list = new LinkedList<>();
        fillListWithNumbers(list, 4);
        list.remove(2);
        list.append(5);

        String expected = "0 1 3 4 5";
        String actual = list.toString();

        assertEquals(expected, actual);
    }

    @Test
    void testRemoveLastItem() {
        LinkedList<Integer> list = new LinkedList<>();
        fillListWithNumbers(list, 4);
        list.remove(4);
        list.append(777);

        String expected = "0 1 2 3 777";
        String actual = list.toString();

        assertEquals(actual, expected);
        assertEquals(5, list.getSize());     //TODO ask if this assert makes sense
    }

    @Test
    void testGetOnEmptyThrowsException(){
        LinkedList<Integer> list = new LinkedList<>();

        assertThrows(IndexOutOfBoundsException.class,
                ()->list.get(0)
        );
    }

    @Test
    void testGetOnlyElement(){
        LinkedList<Integer> list = new LinkedList<>();
        fillListWithNumbers(list, 0);

        int expected = 0;
        int actual = list.get(0);

        assertEquals(expected, actual);
    }

    @Test
    void testGetFirstElement(){
        LinkedList<Integer> list = new LinkedList<>();
        fillListWithNumbers(list, 6);

        int expected = 0;
        int actual = list.get(0);

        assertEquals(expected, actual);
    }

    @Test
    void testGetMidtElement(){
        LinkedList<Integer> list = new LinkedList<>();
        fillListWithNumbers(list, 6);

        int expected = 3;
        int actual = list.get(3);

        assertEquals(expected, actual);
    }

    @Test
    void testGetLasttElement(){
        LinkedList<Integer> list = new LinkedList<>();
        fillListWithNumbers(list, 6);

        int expected = 6;
        int actual = list.get(6);

        assertEquals(expected, actual);
    }
}
