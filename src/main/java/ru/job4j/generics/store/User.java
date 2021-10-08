package ru.job4j.generics.store;

/**
 * @author ESolomatin
 * @version 1.0
 * @since 06.10.2021
 **/
public class User extends Base {
    public User(String id) {
        super(id);
    }

    @Override
    public String toString() {
        return getId();
    }
}
