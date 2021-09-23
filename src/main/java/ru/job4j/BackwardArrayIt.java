package ru.job4j;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BackwardArrayIt implements Iterator<Integer> {

    private final int[] data;
    private int point = 0;

    public BackwardArrayIt(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return point < data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int[] result = new int[data.length];
        for (int i = data.length - 1, j = 0; i >= 0; i--, j++) {
            result[j] = data[i];
        }
        return result[point++];
    }
}


