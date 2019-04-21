/**
 * 本代码的所有权和解释权归瑞斯康达科技发展有限公司所有
 * 1999,2014
 */
package com.lvbo.guavatest.basic;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;
import org.junit.Test;

import java.util.Comparator;

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
 * @version 5.0 since 2014/9/1 17:12
 */
public class ObjectsTest {
    @Test
    public void equalTest() {
        System.out.println(Objects.equal("a", "a"));
        System.out.println(Objects.equal(null, "a"));
        System.out.println(Objects.equal("a", null));
        System.out.println(Objects.equal(null, null));
    }

    @Test
    public void equalPersonTest() {
        System.out.println(Objects.equal(new Person("peida", 23), new Person("peida", 23)));
        Person person = new Person("peida", 23);
        System.out.println(Objects.equal(person, person));
    }


    @Test
    public void hashcodeTest() {
        System.out.println(Objects.hashCode("a"));
        System.out.println(Objects.hashCode("a"));
        System.out.println(Objects.hashCode("a", "b"));
        System.out.println(Objects.hashCode("b", "a"));
        System.out.println(Objects.hashCode("a", "b", "c"));

        Person person = new Person("peida", 23);
        System.out.println(Objects.hashCode(person));
        System.out.println(Objects.hashCode(person));
    }

    @Test
    public void toStringTest() {
        System.out.println(MoreObjects.toStringHelper(this).add("x", 1).toString());
        System.out.println(MoreObjects.toStringHelper(Person.class).add("x", 1).toString());

        Person person = new Person("peida", 23);
        String result = MoreObjects.toStringHelper(Person.class)
                .add("name", person.name)
                .add("age", person.age).toString();
        System.out.print(result);
    }

}

class Person {
    public String name;
    public int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Student implements Comparable<Student> {
    public String name;
    public int age;
    public int score;


    Student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, age);
    }


    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            Student that = (Student) obj;
            return Objects.equal(name, that.name)
                    && Objects.equal(age, that.age)
                    && Objects.equal(score, that.score);
        }
        return false;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .addValue(name)
                .addValue(age)
                .addValue(score)
                .toString();
    }


    public int compareTo(Student other) {
        return ComparisonChain.start()
                .compare(name, other.name)
                .compare(age, other.age)
                .compare(score, other.score, Ordering.natural().nullsLast())
                .result();
    }
}


class StudentComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        return ComparisonChain.start()
                .compare(s1.name, s2.name)
                .compare(s1.age, s2.age)
                .compare(s1.score, s2.score)
                .result();
    }
}
