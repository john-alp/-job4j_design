package ru.job4j;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.generics.store.Base;
import ru.job4j.generics.store.MemStore;
import ru.job4j.generics.store.Store;
import ru.job4j.generics.store.User;

import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author ESolomatin
 * @version 1.0
 * @since 06.10.2021
 **/
public class UserStoreTest {
    Store<Base> store = new MemStore<>();
    User user1 = new User("User1");
    User user2 = new User("User2");
    User user3 = new User("User3");

    @Before
    public void createStoreAndUsers() {
        store.add(user1);
        store.add(user2);
        store.add(user3);
    }

    @Test
    public void whenAddReplaceAndFindById() {
        Assert.assertEquals(user1, store.findById("User1"));
        assertThat(store.findById("User2"), is(user2));
        assertThat(store.findById("User3"), is(user3));
    }

    @Test
    public void whenReplaceModel() {
        store.replace("User1", user3);
        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);

        assertThat(store.findById("User1"), is(user3));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenDeleteModel() {
        store.delete("User2");

        assertThat(store.findById("User2"), is(user2));
    }
}
