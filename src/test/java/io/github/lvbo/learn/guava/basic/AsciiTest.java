package io.github.lvbo.learn.guava.basic;

import com.google.common.base.Ascii;
import org.junit.Test;

public class AsciiTest {

    @Test
    public void testTruncate() {
        System.out.println(Ascii.truncate("who am i", 7, "...."));
    }
}
