package com.lvbo.guavatest.collect;

import com.google.common.collect.Range;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * 类功能描述：<br>
 * <ul>
 * <li><br>
 * </ul>
 * 修改记录：<br>
 * <ul>
 * <li><br>
 * </ul>
 *
 * @author lvb-3274
 * @version 5.0 since 2015/11/10 17:40
 */
public class RangTest {

    @Test
    public void testRangOperation() {
        Range<Integer> numberRange = Range.closed(1,10);
        //both return true meaning inclusive
        assertEquals(true, numberRange.contains(10));
        assertEquals(true, numberRange.contains(1));

        numberRange = Range.open(1,10);
        //both return false meaning exclusive
        assertEquals(false, numberRange.contains(10));
        assertEquals(false, numberRange.contains(1));
    }
}
