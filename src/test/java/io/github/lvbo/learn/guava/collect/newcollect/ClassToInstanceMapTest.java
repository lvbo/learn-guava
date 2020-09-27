package io.github.lvbo.learn.guava.collect.newcollect;

import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.MutableClassToInstanceMap;
import org.junit.Test;

public class ClassToInstanceMapTest {
    @Test
    public void classToInstanceMapTest() {
        ClassToInstanceMap classToInstanceMapString = MutableClassToInstanceMap.create();
        ClassToInstanceMap<Person> classToInstanceMap = MutableClassToInstanceMap.create();
        Person person = new Person("peida", 20);
        System.out.println("person name :" + person.name + " age:" + person.age);
        classToInstanceMapString.put(String.class, "peida");
        classToInstanceMapString.put(Integer.class, 1);
        System.out.println("string:" + classToInstanceMapString.getInstance(String.class));
        System.out.println("integer:" + classToInstanceMapString.getInstance(Integer.class));

        classToInstanceMap.putInstance(Person.class, person);
        Person person1 = classToInstanceMap.getInstance(Person.class);
        System.out.println("person1 name :" + person1.name + " age:" + person1.age);
    }

    class Person {
        public String name;
        public int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}
