package ru.job4j.generics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Добавьте 3 модели данных, которые образуют иерархию наследования: Animal - Predator - Tiger.
 * 1-ый метод - работает без ограничений, т.е. в него можно передавать коллекцию, которая хранит любые типы.
 * 2-ой метод - должен иметь ограничение сверху и ограничиваться классом Predator.
 * 3-ий метод - должен иметь ограничение снизу и ограничиваться классом Predator.
 *
 * @author ESolomatin
 * @version 1.0
 * @since 29.09.2021
 **/

public class Generics {
    public static void main(String[] args) {
        Generics generics = new Generics();
        List<Animal> first = new ArrayList<>();
        List<Predator> second = new ArrayList<>();
        List<Tiger> third = new ArrayList<>();

        first.add(new Animal());
        second.add(new Predator());
        third.add(new Tiger());
        final Animal animal = first.get(1);

        generics.printObject(first);
        generics.printObject(second);
        generics.printObject(third);
        System.out.println();

        //  gen.printBoundedWildCard(first);
        generics.printBoundedWildCard(second);
        generics.printBoundedWildCard(third);
        System.out.println();

        generics.printLowerBoundedWildCard(first);
        generics.printLowerBoundedWildCard(second);
        // gen.printLowerBoundedWildCard(third);
    }

    public void printObject(List<? extends Animal> list) {
        for (Iterator<? extends Animal> it = list.iterator(); it.hasNext();) {
            Animal next = it.next();
            System.out.println("Текущий элемент: " + next);
        }
    }

    public void printBoundedWildCard(List<? extends Predator> list) {
        for (Iterator<? extends Predator> it = list.iterator(); it.hasNext();) {
            Predator next = it.next();
            System.out.println("Текущий элемент: " + next);
        }
    }

    public void printLowerBoundedWildCard(List<? super Predator> list) {
        for (Iterator<? super Predator> it = list.iterator(); it.hasNext();) {
            Object next = it.next();
            System.out.println("Текущий элемент: " + next);
        }
    }
}
