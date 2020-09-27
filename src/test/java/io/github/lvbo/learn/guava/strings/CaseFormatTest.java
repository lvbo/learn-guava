package io.github.lvbo.learn.guava.strings;

import com.google.common.base.CaseFormat;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author lvbo
 * @version V1.0
 * @date 2020/9/24 11:05
 */
public class CaseFormatTest {

    @Test
    public void test() {
        assertEquals("constantName", CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "CONSTANT_NAME"));
    }
}
