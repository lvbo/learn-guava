package io.github.lvbo.learn.guava.functional.function;

import org.junit.Test;

import java.util.Date;

public class FunctionTest {

    @Test
    public void test() {
        System.out.print(new DateFormatFunction().apply(new Date()));
    }
}
