/**
 * �����������Ȩ�ͽ���Ȩ����˹����Ƽ���չ���޹�˾����
 * 1999,2014
 */
package com.lvbo.guavatest.collect;

import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.MutableClassToInstanceMap;
import org.junit.Test;

/**
 * �๦������:
 * <ul>
 * <li><br>
 * </ul>
 * �޸ļ�¼��<br>
 * <ul>
 * <li><br>
 * </ul>
 *
 * @author lvb-3274
 * @version 5.0 since 2014/9/2 14:10
 */
public class ClassToInstanceMapTest {
    @Test
    public  void ClassToInstanceMapTest() {
        ClassToInstanceMap classToInstanceMapString = MutableClassToInstanceMap.create();
        ClassToInstanceMap<Person> classToInstanceMap =MutableClassToInstanceMap.create();
        Person person= new Person("peida",20);
        System.out.println("person name :"+person.name+" age:"+person.age);
        classToInstanceMapString.put(String.class, "peida");
        classToInstanceMapString.put(Integer.class, 1);
        System.out.println("string:"+classToInstanceMapString.getInstance(String.class));
        System.out.println("integer:"+classToInstanceMapString.getInstance(Integer.class));

        classToInstanceMap.putInstance(Person.class,person);
        Person person1=classToInstanceMap.getInstance(Person.class);
        System.out.println("person1 name :"+person1.name+" age:"+person1.age);
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
