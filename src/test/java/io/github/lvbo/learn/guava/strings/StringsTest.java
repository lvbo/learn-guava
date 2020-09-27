package io.github.lvbo.learn.guava.strings;

import com.google.common.base.Strings;
import org.junit.Test;

public class StringsTest {

    @Test
    public void test1() {
        System.out.println(Strings.padEnd("ddd", 5, 'x'));
    }
}
