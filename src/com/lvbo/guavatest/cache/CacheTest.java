/**
 * �����������Ȩ�ͽ���Ȩ����˹����Ƽ���չ���޹�˾����
 * 1999,2014
 */
package com.lvbo.guavatest.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
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
 * @version 5.0 since 2014/9/2 14:55
 */
public class CacheTest {
    @Test
    public void testLoadingCache() throws Exception {
        LoadingCache<String, String> cahceBuilder = CacheBuilder
                .newBuilder()
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String key) throws Exception {
                        String strProValue = "hello " + key + "!";
                        return strProValue;
                    }

                });

        cahceBuilder.refresh("jerry");
        System.out.println("jerry value:" + cahceBuilder.get("jerry"));
        System.out.println("peida value:" + cahceBuilder.get("peida"));
        System.out.println("peida value:" + cahceBuilder.apply("peida"));
        System.out.println("lisa value:" + cahceBuilder.apply("lisa"));
        cahceBuilder.put("harry", "ssdded");
        System.out.println("harry value:" + cahceBuilder.get("harry"));
    }
}
