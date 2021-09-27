package ru.job4j;

import org.w3c.dom.ls.LSOutput;

import java.util.Iterator;

//
//}
class App {
    public static void main(String[] args) {
        int column = 0;
        int row = 0;

        int data[][] = {
                {1, 2, 3, 4},
                {6, 7, 8, 9},
                {10, 11, 12, 13}
        };


//        for (; row <= data.length - 1; row++) {
//            for (; column <= data[row].length - 1; column++) {
//                System.out.println(data[row][column]);
//            }
//            column = 0;
//            row++;
//        }
        while (row <= data.length - 1) {
            while (column <= data[row].length - 1) {
                System.out.println(data[row][column]);
            column++;
            }
        column = 0;
        row++;
        }
        System.out.println(column + " " + row);
    }

}