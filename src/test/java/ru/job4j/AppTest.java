package ru.job4j;

import java.util.Iterator;
import java.util.NoSuchElementException;

//package ru.job4j;
//
//import junit.framework.Test;
//import junit.framework.TestCase;
//import junit.framework.TestSuite;
//
///**
// * Unit test for simple App.
// */
public class AppTest implements Iterator {
    private final int[] array;
    private final int len;
    private int index = -1;
    private int evenIndex;

    public AppTest(int[] array) {
        this.array = array;
        this.len = array.length;
    }

    /**
     * возвращает true, только если в массиве есть четные перед указателем.
     *
     * @return boolean
     */
    @Override
    public boolean hasNext() {
        boolean has = false;
        for (int i = index + 1; i < len; i++) {
            if (0 == array[i] % 2) {
                has = true;
                evenIndex = i;
                break;
            }
        }
        return has;
    }

    /**
     * it.next() - возвращают только четные числа.
     * метод next в случае отсутствия элементов к возврату генерирует NoSuchElementException.
     * метод next должен возвращать верные значения вне зависимости от того вызвал ли перед этим программист метод hasNext.
     * Аналогично для hasNext.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public Integer next() throws NoSuchElementException {
        if (hasNext()) {
            index = evenIndex;
            return array[index];
        }
        throw new NoSuchElementException();
    }
}
//        extends TestCase {
//    /**
//     * Create the test case
//     *
//     * @param testName name of the test case
//     */
//    public AppTest(String testName) {
//        super(testName);
//    }
//
//    /**
//     * @return the suite of tests being tested
//     */
//    public static Test suite() {
//        return new TestSuite(AppTest.class);
//    }
//
//    /**
//     * Rigourous Test :-)
//     */
//    public void testApp() {
//        assertTrue(true);
//    }
//}
