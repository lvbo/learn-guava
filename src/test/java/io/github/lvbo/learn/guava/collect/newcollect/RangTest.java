package io.github.lvbo.learn.guava.collect.newcollect;

import com.google.common.collect.Range;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
