package com.lvbo.guavatest.eventbus.trade.buysell;

import com.google.common.eventbus.EventBus;
import com.lvbo.guavatest.cache.model.TradeAccount;
import com.lvbo.guavatest.eventbus.trade.model.TradeType;
import org.junit.Test;

/**
 * Created by lvbo on 16/2/12.
 */
public class DeadEventTest {

    @Test
    public void test() {
        EventBus eventBus = new EventBus("buy sell");
        BuySellTradeExecutor buySellTradeExecutor = new BuySellTradeExecutor(eventBus);
        DeadEventSubscriber deadEventSubscriber = new DeadEventSubscriber(eventBus);

        buySellTradeExecutor.executeTrade(new TradeAccount("1", "dd", 3.0), 3.2, TradeType.BUY);
        buySellTradeExecutor.executeTrade(new TradeAccount("3", "dd", 3.2), 2.1, TradeType.SELL);
    }
}