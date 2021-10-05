package ru.job4j.iterator;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Iterator;

/**
 * Класс FlatMap принимает объект вложенных итераторов.
 * В классе нужно реализовать два метода: next и hasNext.
 * Метод next должен последовательно вернуть числа из вложенных итераторов.
 * В этом задании нельзя копировать элементы во временный список.
 *
 * @author ESolomatin
 * @version 1.0
 * @since 29.09.2021
 **/

public class FlatMap<T> implements Iterator<T> {
    private final Iterator<Iterator<T>> data;

    private Iterator<T> cursor; // = Collections.emptyIterator();

    public FlatMap(Iterator<Iterator<T>> data) {
        this.data = data;
    }

/*    Т.Е. в данном случае итератор data проходит по другим итераторам.
    В next нужно пройтись по итературу <T> и получить данные.
    Итератор <T> получить с помощью data и cursor */

    @Override
    public boolean hasNext() {
        System.out.println(data.hasNext() + " - " + cursor.hasNext());
        while (data.hasNext() && !cursor.hasNext()) {
            cursor = data.next();
        }
        return cursor.hasNext();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return cursor.next();
    }

    public static void main(String[] args) {
        Iterator<Iterator<Integer>> data = List.of(
                List.of(1, 2, 3).iterator(),
                List.of(4, 5, 6).iterator(),
                List.of(7, 8, 9).iterator()
        ).iterator();

        FlatMap<Integer> flat = new FlatMap<>(data);
        while (flat.hasNext()) {
            System.out.println(flat.next());
        }
    }
}
