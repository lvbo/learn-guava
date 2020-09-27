package io.github.lvbo.learn.guava.basic;

import com.google.common.base.Optional;
import org.junit.Test;

public class OptionalTest {

    @Test
    public void testOptional() throws Exception {
        Optional<Integer> possible = Optional.of(6);
        Optional<Integer> absentOpt = Optional.absent();
        Optional<Integer> nullableOpt = Optional.fromNullable(null);
        Optional<Integer> noNullableOpt = Optional.fromNullable(10);
        System.out.println("possible isPresent:" + possible.isPresent());
        System.out.println("possible value:" + possible.get());
        System.out.println("absentOpt isPresent:" + absentOpt.isPresent());
        System.out.println("fromNullableOpt isPresent:" + nullableOpt.isPresent());
        System.out.println("NoNullableOpt isPresent:" + noNullableOpt.isPresent());
    }
}
