/**
 * 本代码的所有权和解释权归瑞斯康达科技发展有限公司所有
 * 1999,2014
 */
package com.lvbo.guavatest.collect;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * 类功能描述:
 * <ul>
 * <li><br>
 * </ul>
 * 修改记录：<br>
 * <ul>
 * <li><br>
 * </ul>
 *
 * @author lvb-3274
 * @version 5.0 since 2014/9/10 14:54
 */
public class FluentIterableTest {
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
        personList = Lists.newArrayList(person1, person2, person3,
                person4);
    }
    @Test
    public void testFilter() throws Exception {
        Iterable<Person> personsFilteredByAge =
                FluentIterable.from(personList).filter(new Predicate<Person>() {
                    public boolean apply(Person input) {
                        return input.getAge() > 31;
                    }
                });
        assertThat(Iterables.contains(personsFilteredByAge, person2),
                is(true));
        assertThat(Iterables.contains(personsFilteredByAge, person4),
                is(true));
        assertThat(Iterables.contains(personsFilteredByAge, person1),
                is(false));
        assertThat(Iterables.contains(personsFilteredByAge, person3),
                is(false));
    }

    @Test
    public void testTransform() throws Exception {
        List<String> transformedPersonList =
                FluentIterable.from(personList).transform(new Function<Person, String>() {
                    public String apply(Person input) {
                        return Joiner.on('#').join(input.getLastName(),
                                input.getFirstName(), input.getAge());
                    }
                }).toList();
        assertThat(transformedPersonList.get(1), is("Flintstone#Fred#32"));
    }

    @Test
    public void testLists() {
        List<List<Person>> subList = Lists.partition(personList, 2);
        assertEquals(2, subList.size());
        System.out.println(subList);
    }
}
