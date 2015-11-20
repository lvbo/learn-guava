/**
 * �����������Ȩ�ͽ���Ȩ����˹����Ƽ���չ���޹�˾����
 * 1999,2014
 */
package com.lvbo.guavatest.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
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
 * @version 5.0 since 2014/9/2 15:20
 */
public class CacheTest3 {
    private static Cache<String, String> cacheFormCallable = null;


    /**
     * ����Ҫ�ӳٴ���Ŀ��Բ���������ƣ�(���͵ķ�ʽ��װ)
     * @param <K>
     * @param <V>
     * @param key
     * @param callable
     * @return V
     * @throws Exception
     */
    public static <K,V> Cache<K , V> callableCached() throws Exception {
        Cache<K, V> cache = CacheBuilder
                .newBuilder()
                .maximumSize(10000)
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .build();
        return cache;
    }


    private String getCallableCache(final String userName) {
        try {
            //Callableֻ���ڻ���ֵ������ʱ���Ż����
            return cacheFormCallable.get(userName, new Callable<String>() {
                public String call() throws Exception {
                    System.out.println(userName+" from db");
                    return "hello "+userName+"!";
                }
            });
        } catch (ExecutionException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Test
    public void testCallableCache() throws Exception{
        final String u1name = "peida";
        final String u2name = "jerry";
        final String u3name = "lisa";
        cacheFormCallable=callableCached();
        System.out.println("peida:"+getCallableCache(u1name));
        System.out.println("jerry:"+getCallableCache(u2name));
        System.out.println("lisa:"+getCallableCache(u3name));
        System.out.println("peida:"+getCallableCache(u1name));

    }
}
