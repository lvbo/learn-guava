package io.github.lvbo.learn.guava.range;

import com.google.common.collect.BoundType;
import com.google.common.collect.Range;
import com.google.common.primitives.Ints;
import org.junit.Test;

import static junit.framework.TestCase.*;

/**
 * @author lvbo
 * @version V1.0
 * @date 2020/9/24 11:23
 */
public class RangeTest {

    @Test
    public void testOperations() {
        assertTrue(Range.closed(1, 3).contains(2));
        assertFalse(Range.closed(1, 3).contains(4));
        assertFalse(Range.lessThan(5).contains(5));
        assertTrue(Range.closed(1, 4).containsAll(Ints.asList(1, 2, 3)));
    }

    @Test
    public void testQueryOperations() {
        assertTrue(Range.closedOpen(4, 4).isEmpty());
        assertTrue(Range.openClosed(4, 4).isEmpty());
        assertFalse(Range.closed(4, 4).isEmpty());
        assertEquals(3, Range.closed(3, 10).lowerEndpoint().intValue());
        assertEquals(3, Range.open(3, 10).lowerEndpoint().intValue());
        assertEquals(BoundType.CLOSED, Range.closed(3, 10).lowerBoundType());
        assertEquals(BoundType.OPEN, Range.open(3, 10).upperBoundType());
    }

    @Test
    public void testIsConnected() {
        assertTrue(Range.closed(3, 5).isConnected(Range.open(5, 10)));
        assertTrue(Range.closed(0, 9).isConnected(Range.closed(3, 4)));
        assertTrue(Range.closed(0, 5).isConnected(Range.closed(3, 9)));
        assertFalse(Range.open(3, 5).isConnected(Range.open(5, 10)));
        assertFalse(Range.closed(1, 5).isConnected(Range.closed(6, 10)));
    }

    @Test
    public void testIntersection() {
        Range.closed(3, 5).intersection(Range.open(5, 10)); // returns (5, 5]
        Range.closed(0, 9).intersection(Range.closed(3, 4)); // returns [3, 4]
        Range.closed(0, 5).intersection(Range.closed(3, 9)); // returns [3, 5]
        Range.open(3, 5).intersection(Range.open(5, 10)); // throws IAE
        Range.closed(1, 5).intersection(Range.closed(6, 10)); // throws IAE
    }

    @Test
    public void teetSpan() {
        Range.closed(3, 5).span(Range.open(5, 10)); // returns [3, 10)
        Range.closed(0, 9).span(Range.closed(3, 4)); // returns [0, 9]
        Range.closed(0, 5).span(Range.closed(3, 9)); // returns [0, 9]
        Range.open(3, 5).span(Range.open(5, 10)); // returns (3, 10)
        Range.closed(1, 5).span(Range.closed(6, 10)); // returns [1, 10]
    }
}
