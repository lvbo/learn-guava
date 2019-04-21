/**
 * 本代码的所有权和解释权归瑞斯康达科技发展有限公司所有
 * 1999,2014
 */
package com.lvbo.guavatest.basic;

import com.google.common.base.CharMatcher;
import org.junit.Test;

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
 * @version 5.0 since 2014/9/10 9:35
 */
public class CharMatcherTest {

    @Test
    public void testRemoveWhiteSpace(){
        String tabsAndSpaces = "String  with      spaces     and tabs";
        String scrubbed = CharMatcher.WHITESPACE.collapseFrom(tabsAndSpaces, ' ');
        System.out.println(scrubbed);
    }

    @Test
    public void testTrimRemoveWhiteSpace(){
        String tabsAndSpaces = "    String  with     spaces     and tabs";
        String scrubbed = CharMatcher.WHITESPACE. trimAndCollapseFrom(tabsAndSpaces, ' ');
        System.out.println(scrubbed);
    }

    @Test
    public void testRetainFrom(){
        String lettersAndNumbers = "foo989yxbar234";
        String retained = CharMatcher.JAVA_DIGIT.retainFrom(lettersAndNumbers);
        System.out.println(retained);

        String lettersAndNumbersAndWhitespace = "fff 908 dddd98 ";
        retained = CharMatcher.JAVA_DIGIT.or(CharMatcher.WHITESPACE).retainFrom(lettersAndNumbersAndWhitespace);
        System.out.println(retained);
    }
}
