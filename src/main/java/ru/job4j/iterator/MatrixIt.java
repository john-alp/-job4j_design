package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *  Итератор, который последовательно вернет элементы
 *  Реализуйте методы next и hasNext.
 *
 * Копировать двухмерный в одномерный массив не нужно. Это не верное решение.
 * Нужно с помощью чисел row и column двигать указатель.
 *
 */

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        while (row < data.length && column == data[row].length) {
            row++;
            column = 0;
        }
        return row < data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[row][column++];
    }
}

