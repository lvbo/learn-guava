package io.github.lvbo.learn.guava.eventbus.trade.simple;

import com.google.common.eventbus.EventBus;
import io.github.lvbo.learn.guava.cache.model.TradeAccount;
import io.github.lvbo.learn.guava.eventbus.trade.model.TradeType;
import org.junit.Test;

/**
 * Created by lvbo on 16/2/12.
 */
public class SimpleTradeTest {

    @Test
    public void test() {
        EventBus eventBus = new EventBus("test trade");
        SimpleTradeExecutor simpleTradeExecutor = new SimpleTradeExecutor(eventBus);
        SimpleTradeAuditor simpleTradeAuditor = new SimpleTradeAuditor(eventBus);
        simpleTradeExecutor.executeTrade(new TradeAccount("3", "lvbo", 3.0), 3.0, TradeType.BUY);
    }
}
