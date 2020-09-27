package io.github.lvbo.learn.guava.strings;

import com.google.common.base.CharMatcher;
import org.junit.Test;

public class CharMatcherTest {

    @Test
    public void testRemoveWhiteSpace() {
        String tabsAndSpaces = "String  with      spaces     and tabs";
        String scrubbed = CharMatcher.whitespace().collapseFrom(tabsAndSpaces, ' ');
        System.out.println(scrubbed);
    }

    @Test
    public void testTrimRemoveWhiteSpace() {
        String tabsAndSpaces = "    String  with     spaces     and tabs";
        String scrubbed = CharMatcher.whitespace().trimAndCollapseFrom(tabsAndSpaces, ' ');
        System.out.println(scrubbed);
    }

    @Test
    public void testRetainFrom() {
        String lettersAndNumbers = "foo989yxbar234";
        String retained = CharMatcher.javaDigit().retainFrom(lettersAndNumbers);
        System.out.println(retained);

        String lettersAndNumbersAndWhitespace = "fff 908 dddd98 ";
        retained = CharMatcher.javaDigit().or(CharMatcher.whitespace()).retainFrom(lettersAndNumbersAndWhitespace);
        System.out.println(retained);
    }
}
