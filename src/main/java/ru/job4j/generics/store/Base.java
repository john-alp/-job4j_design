package ru.job4j.generics.store;

/**
 * @author ESolomatin
 * @version 1.0
 * @since 05.10.2021
 **/
public abstract class Base {

    private final String id;

    public Base(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
