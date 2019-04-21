/**
 * 本代码的所有权和解释权归瑞斯康达科技发展有限公司所有
 * 1999,2014
 */
package com.lvbo.guavatest.collect;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

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
 * @version 5.0 since 2014/9/2 11:31
 */
public class BimapTest {

    @Test
    public void testValueRepeat() {
        BiMap<String,String> biMap = HashBiMap.create();
        biMap.put("1","Tom");
        //This call causes an IllegalArgumentException to be thrown!
        biMap.put("2","Tom");
    }

    @Test
    public void testKeyRepeat() {
        BiMap<String,String> biMap = HashBiMap.create();
        biMap.put("1","Tom");
        biMap.put("1","Mt");
        System.out.println(biMap);
    }

    @Test
    public void testBiMapForcePut() throws Exception {
        BiMap<String,String> biMap = HashBiMap.create();
        biMap.put("1","Tom");
        biMap.forcePut("2","Tom");
        assertThat(biMap.containsKey("1"),is(false));
        assertThat(biMap.containsKey("2"),is(true));
    }

    @Test
    public void testBiMapInverse() throws Exception {
        BiMap<String,String> biMap = HashBiMap.create();
        biMap.put("1","Tom");
        biMap.put("2","Harry");
        assertThat(biMap.get("1"),is("Tom"));
        assertThat(biMap.get("2"),is("Harry"));
        BiMap<String,String> inverseMap = biMap.inverse();
        assertThat(inverseMap.get("Tom"),is("1"));
        assertThat(inverseMap.get("Harry"),is("2"));
    }
}
