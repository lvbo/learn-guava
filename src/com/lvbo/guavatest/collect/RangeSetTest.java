/**
 * �����������Ȩ�ͽ���Ȩ����˹����Ƽ���չ���޹�˾����
 * 1999,2014
 */
package com.lvbo.guavatest.collect;

import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeSet;
import org.junit.Test;

/**
 * �๦������:
 * <ul>
 * <li><br>
 * </ul>
 * �޸ļ�¼��<br>
 * <ul>
 * <li><br>
 * </ul>
 *
 * @author lvb-3274
 * @version 5.0 since 2014/9/2 14:44
 */
public class RangeSetTest {
    @Test
    public void rangeSetTest(){
        RangeSet<Integer> rangeSet = TreeRangeSet.create();
        rangeSet.add(Range.closed(1, 10));
        System.out.println("rangeSet:"+rangeSet);
        rangeSet.add(Range.closedOpen(11, 15));
        System.out.println("rangeSet:"+rangeSet);
        rangeSet.add(Range.open(15, 20));
        System.out.println("rangeSet:"+rangeSet);
        rangeSet.add(Range.openClosed(0, 0));
        System.out.println("rangeSet:"+rangeSet);
        rangeSet.remove(Range.open(5, 10));
        System.out.println("rangeSet:"+rangeSet);
    }
}
