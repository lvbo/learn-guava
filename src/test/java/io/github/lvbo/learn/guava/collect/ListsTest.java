package io.github.lvbo.learn.guava.collect;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ListsTest {
    private Person person1;
    private Person person2;
    private Person person3;
    private Person person4;
    List<Person> personList;

    @Before
    public void setUp() {
        person1 = new Person("Wilma", "Flintstone", 30, "F");
        person2 = new Person("Fred", "Flintstone", 32, "M");
        person3 = new Person("Betty", "Rubble", 31, "F");
        person4 = new Person("Barney", "Rubble", 33, "M");
        personList = Lists.newArrayList(person1, person2, person3, person4);
    }

    @Test
    public void testLists() {
        List<List<Person>> subList = Lists.partition(personList, 2);
        assertEquals(2, subList.size());
        assertEquals(2, subList.get(0).size());
    }
}
