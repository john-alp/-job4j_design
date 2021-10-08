package ru.job4j.generics.store;

/**
 * @author ESolomatin
 * @version 1.0
 * @since 05.10.2021
 **/
public interface Store<T extends Base> {

    void add(T model);

    boolean replace(String id, T model);

    boolean delete(String id);

    T findById(String id);
}
