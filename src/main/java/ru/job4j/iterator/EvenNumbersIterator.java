package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Создать итератор возвращающий только четные цифры.
 *
 * Итератор должен принимать список произвольных чисел.
 * Метод next должен возвращать верные значения вне зависимости от того вызвал ли перед этим программист метод hasNext. Аналогично для hasNext.
 * Результат работы ваших методов не должен зависеть от последовательности в которой программист вызывает методы.
 *
 * @author ESolomatin
 * @version 1.1
 * @since 28.09.2021
 *
 **/

public class EvenNumbersIterator implements Iterator<Integer> {
    private final int[] data;
    private int index;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        for (int i = index; i < data.length; i++) {
            if (data[i] % 2 == 0) {
                index = i;
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public Integer next() throws NoSuchElementException {
        if (hasNext()) {
            return data[index++];
        } else {
            throw new NoSuchElementException("There is no next element");
        }
    }
}
