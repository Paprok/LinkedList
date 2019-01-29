package com.codecool.krk;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

    @Test
    void testAppendOneItem() {
        String expected = "1";
        LinkedList<Integer> list = new LinkedList<>();

        list.append(1);
        String actual = list.toString();

        assertEquals(expected, actual);
    }

    @Test
    void testAppendMultipleItems() {
        String expected = "0 1 2 3 4 5 100 200";
        LinkedList<Integer> list = new LinkedList<>();

        int i = 5;
        fillListWithNumbers(list, i);
        list.append(100);
        list.append(200);
        String actual = list.toString();

        assertEquals(expected, actual);
    }

    private void fillListWithNumbers(LinkedList<Integer> list, int last) {
        for (int i = 0; i <= last; i++) {
            list.append(i);
        }
    }
}
