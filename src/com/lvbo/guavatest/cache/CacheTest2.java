/**
 * �����������Ȩ�ͽ���Ȩ����˹����Ƽ���չ���޹�˾����
 * 1999,2014
 */
package com.lvbo.guavatest.cache;

import com.google.common.cache.*;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

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
 * @version 5.0 since 2014/9/2 15:16
 */
public class CacheTest2 {
    /**
     * ����Ҫ�ӳٴ���(���͵ķ�ʽ��װ)
     *
     * @return
     */
    public <K, V> LoadingCache<K, V> cached(CacheLoader<K, V> cacheLoader) {
        LoadingCache<K, V> cache = CacheBuilder
                .newBuilder()
                .maximumSize(2)
                .weakKeys()
                .softValues()
                .refreshAfterWrite(120, TimeUnit.SECONDS)
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .removalListener(new RemovalListener<K, V>() {
                    public void onRemoval(RemovalNotification<K, V> rn) {
                        System.out.println(rn.getKey() + "���Ƴ�");

                    }
                })
                .build(cacheLoader);
        return cache;
    }

    /**
     * ͨ��key��ȡvalue
     * ���÷�ʽ commonCache.get(key) ; return String
     *
     * @param key
     * @return
     * @throws Exception
     */

    public LoadingCache<String, String> commonCache(final String key) throws Exception {
        LoadingCache<String, String> commonCache = cached(new CacheLoader<String, String>() {
            @Override
            public String load(String key) throws Exception {
                return "hello " + key + "!";
            }
        });
        return commonCache;
    }

    @Test
    public void testCache() throws Exception {
        LoadingCache<String, String> commonCache = commonCache("peida");
        System.out.println("peida:" + commonCache.get("peida"));
        commonCache.apply("harry");
        System.out.println("harry:" + commonCache.get("harry"));
        commonCache.apply("lisa");
        System.out.println("lisa:" + commonCache.get("lisa"));
    }
}
