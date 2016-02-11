/**
 * 本代码的所有权和解释权归瑞斯康达科技发展有限公司所有
 * 1999,2014
 */
package com.lvbo.guavatest.collect;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

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
 * @version 5.0 since 2014/9/2 11:13
 */
public class MultimapTest {

    @Test
    public void testArrayListMultiMap(){
        ArrayListMultimap<String,String> multiMap = ArrayListMultimap.create();
        multiMap.put("Foo","1");
        multiMap.put("Foo","2");
        multiMap.put("Foo","3");
        List<String> expected = Lists.newArrayList("1", "2", "3");
        assertEquals(multiMap.get("Foo"),expected);
    }

    @Test
    public void testArrayListMultimapSameKeyValue(){
        ArrayListMultimap<String,String> multiMap = ArrayListMultimap.create();
        multiMap.put("Bar","1");
        multiMap.put("Bar","2");
        multiMap.put("Bar","3");
        multiMap.put("Bar","3");
        multiMap.put("Bar","3");
        List<String> expected = Lists. newArrayList("1","2","3","3","3");
        assertEquals(multiMap.get("Bar"),expected);
    }

    @Test
    public void testHashMultimapKeyValue() {
        HashMultimap<String,String> multiMap = HashMultimap.create();
        multiMap.put("Bar","1");
        multiMap.put("Bar","2");
        multiMap.put("Bar","3");
        multiMap.put("Bar","3");
        multiMap.put("Bar","3");
        System.out.println(multiMap.get("Bar"));
    }

}
