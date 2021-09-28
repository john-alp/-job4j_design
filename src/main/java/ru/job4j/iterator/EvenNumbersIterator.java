package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 28.09.2021
 * Создать итератор возвращающий только четные цифры.
 *
 * Итератор должен принимать список произвольных чисел.
 * Метод next должен возвращать верные значения вне зависимости от того вызвал ли перед этим программист метод hasNext. Аналогично для hasNext.
 * Результат работы ваших методов не должен зависеть от последовательности в которой программист вызывает методы.
 */

public class EvenNumbersIterator implements Iterator<Integer> {
    private final int[] data;
    private final int size;
    private int index = -1;
    private int evenIndex;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
        this.size = data.length;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        for (int i = index + 1; i < size; i++) {
            if (data[i] % 2 == 0) {
                evenIndex = i;
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public Integer next() throws NoSuchElementException {
        if (hasNext()) {
            index = evenIndex;
            return data[index];
        }
        throw new NoSuchElementException();
    }
}
