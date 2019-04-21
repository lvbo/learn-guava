package com.lvbo.guavatest.cache;

import com.google.common.base.Ticker;
import com.google.common.cache.*;
import com.lvbo.guavatest.cache.model.Book;
import com.lvbo.guavatest.cache.model.TradeAccount;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by lvbo on 16/2/12.
 */
public class CacheBuilderTest {

    @Test
    public void test1() {
        LoadingCache<String,TradeAccount> tradeAccountCache = CacheBuilder
                .newBuilder()
                .expireAfterWrite(5L, TimeUnit.MINUTES)
                .maximumSize(5000L)
                .removalListener(new TradeAccountRemovalListener())
                .ticker(Ticker.systemTicker())
                .build(new CacheLoader<String, TradeAccount>() {
                    @Override
                    public TradeAccount load(String key) throws Exception {
//                        return tradeAccountService.getTradeAccountById(key);
                        return new TradeAccount("1", "lvbo", 4.0);

                    }
                });
    }

    @Test
    public void test2() {
        LoadingCache<String,Book> bookCache = CacheBuilder.newBuilder()
                .expireAfterAccess(20L,TimeUnit.MINUTES)
                .softValues()
                .removalListener(new BookRemovalListener())
                .build(new CacheLoader<String, Book>() {
                    @Override
                    public Book load(String key) throws Exception {
//                    return  bookService.getBookByIsbn(key);
                        return new Book();
                }
        });
    }

    @Test
    public void test3() {
        LoadingCache<String,TradeAccount> tradeAccountCache = CacheBuilder.newBuilder()
                .concurrencyLevel(10)
                .refreshAfterWrite(5L,TimeUnit.SECONDS)
                .ticker(Ticker.systemTicker())
                .build(new CacheLoader<String, TradeAccount>() {
                    @Override
                    public TradeAccount load(String key) throws Exception {
//                return tradeAccountService.getTradeAccountById(key)key;
                        return new TradeAccount("4", "lvbo", 3.4);
                    }
                });
    }

    @Test
    public void test4() {
        String spec = "concurrencyLevel=10,expireAfterAccess=5m,softValues";
        CacheBuilderSpec cacheBuilderSpec = CacheBuilderSpec.parse(spec);
        CacheBuilder cacheBuilder = CacheBuilder.from(cacheBuilderSpec);
        LoadingCache<String, TradeAccount> tradeAccountCache = cacheBuilder.ticker(Ticker.systemTicker())
                .removalListener(new TradeAccountRemovalListener())
                .recordStats()
                .build(new CacheLoader<String, TradeAccount>() {
                    @Override
                    public TradeAccount load(String key) throws Exception {
//                        return tradeAccountService.getTradeAccountById(key);
                        return new TradeAccount("3", "lvbo", 3.4);
                    }
                });
        CacheStats cacheStats = tradeAccountCache.stats();
    }
}
