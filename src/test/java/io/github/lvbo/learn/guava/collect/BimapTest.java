package io.github.lvbo.learn.guava.collect;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

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
