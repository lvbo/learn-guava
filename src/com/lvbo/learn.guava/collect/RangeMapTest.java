/**
 * �����������Ȩ�ͽ���Ȩ����˹����Ƽ���չ���޹�˾����
 * 1999,2014
 */
package com.lvbo.guavatest.collect;

import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;
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
 * @version 5.0 since 2014/9/2 14:50
 */
public class RangeMapTest {
    @Test
    public void RangeMapTest(){
        RangeMap<Integer, String> rangeMap = TreeRangeMap.create();
        rangeMap.put(Range.closed(1, 10), "foo");
        System.out.println("rangeMap:"+rangeMap);
        rangeMap.put(Range.open(3, 6), "bar");
        System.out.println("rangeMap:"+rangeMap);
        rangeMap.put(Range.open(10, 20), "foo");
        System.out.println("rangeMap:"+rangeMap);
        rangeMap.remove(Range.closed(5, 11));
        System.out.println("rangeMap:"+rangeMap);
        System.out.println(rangeMap.get(3));
    }

}
