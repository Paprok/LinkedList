package com.codecool.krk.doubleLinkedList;

import com.codecool.krk.linkedList.LinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DoubleLinkedListTest {

    private void fillListWithNumbers(DoubleLinkedList<Integer> list, int last) {
        for (int i = 0; i <= last; i++) {
            list.append(i);
        }
    }

    @Test
    void testToStringOnEmptyList() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

        String expected = "";
        String actual = list.toString();

        assertEquals(expected, actual);
    }

    @Test
    void testAppendOneItem() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.append(1);

        String expected = "1";
        String actual = list.toString();

        assertEquals(expected, actual);
    }

    @Test
    void testGetSize() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        fillListWithNumbers(list, 5);

        int expected = 6;
        int actual = list.getSize();

        assertEquals(expected, actual);
    }

    @Test
    void testAppendMultipleItems() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        fillListWithNumbers(list, 5);
        list.append(100);
        list.append(200);

        String expected = "0 1 2 3 4 5 100 200";
        String actual = list.toString();

        assertEquals(expected, actual);
    }

    @Test
    void testAddTo0IndexEmptyList() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.add(0, 666);

        String expected = "666";
        String actual = list.toString();

        assertEquals(expected, actual);
    }

    @Test
    void testAddTo0IndexFilledList() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        fillListWithNumbers(list, 6);
        list.add(0, 666);

        String expected = "666 0 1 2 3 4 5 6";
        String actual = list.toString();

        assertEquals(expected, actual);
    }

    @Test
    void testAddToNegativeIndexThrowsException() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

        assertThrows(IndexOutOfBoundsException.class,

                () -> list.add(-1, 1)
        );
    }

    @Test
    void testAddToIndexHigherThanSizeThrowsException() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.append(1);

        assertThrows(IndexOutOfBoundsException.class,

                () -> list.add(99, 1)
        );
    }

    @Test
    void testAddToMidIndex() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        fillListWithNumbers(list, 6);
        list.add(3, 666);

        String expected = "0 1 2 666 3 4 5 6";
        String actual = list.toString();

        assertEquals(expected, actual);
    }

    @Test
    void testAddToLastIndex() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        fillListWithNumbers(list, 6);
        list.add(7, 666);

        String expected = "0 1 2 3 4 5 6 666";
        String actual = list.toString();

        assertEquals(expected, actual);
    }

    @Test
    void testRemoveNegativeIndexThrowsException() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.add(0);

        assertThrows(IndexOutOfBoundsException.class,

                () -> list.remove(-1)
        );
    }

    @Test
    void testRemoveIndexHigherThanLastThrowsException() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.add(0);

        assertThrows(IndexOutOfBoundsException.class,

                () -> list.remove(list.getSize())
        );
    }

    @Test
    void testRemoveOnlyItem() {
        DoubleLinkedList<Integer> list = removeOnlyItem();

        String expected = "";
        String actual = list.toString();

        assertEquals(expected, actual);
    }

    private DoubleLinkedList<Integer> removeOnlyItem() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.append(0);
        list.remove(0);
        return list;
    }

    @Test
    void testAppendAfterRemoveOnlyItem() {
        DoubleLinkedList<Integer> list = removeOnlyItem();

        list.append(666);
        String expected = "666";
        String actual = list.toString();

        assertEquals(expected, actual);
    }

    @Test
    void testRemoveMidItem() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        fillListWithNumbers(list, 4);
        list.remove(2);
        list.append(5);

        String expected = "0 1 3 4 5";
        String actual = list.toString();

        assertEquals(expected, actual);
    }

    @Test
    void testRemoveLastItem() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
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
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

        assertThrows(IndexOutOfBoundsException.class,
                ()->list.get(0)
        );
    }

    @Test
    void testGetOnlyElement(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        fillListWithNumbers(list, 0);

        int expected = 0;
        int actual = list.get(0);

        assertEquals(expected, actual);
    }

    @Test
    void testGetFirstElement(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        fillListWithNumbers(list, 6);

        int expected = 0;
        int actual = list.get(0);

        assertEquals(expected, actual);
    }

    @Test
    void testGetMidtElement(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        fillListWithNumbers(list, 6);

        int expected = 3;
        int actual = list.get(3);

        assertEquals(expected, actual);
    }

    @Test
    void testGetLasttElement(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        fillListWithNumbers(list, 6);

        int expected = 6;
        int actual = list.get(6);

        assertEquals(expected, actual);
    }
}
