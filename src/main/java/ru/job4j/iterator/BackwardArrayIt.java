package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/** 09.2021
 * Реализуйте итератор для массива. Итератор должен отдавать элементы в обратном порядке.
 */

public class BackwardArrayIt implements Iterator<Integer> {

    private final int[] data;
    private int point;

    public BackwardArrayIt(int[] data) {
        this.data = data;
        this.point = data.length - 1;
    }

    @Override
    public boolean hasNext() {
        return point >= 0;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[point--];
    }
}