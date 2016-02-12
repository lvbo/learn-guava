package com.lvbo.guavatest.eventbus.trade.simple;

import com.google.common.eventbus.EventBus;
import com.lvbo.guavatest.cache.model.TradeAccount;
import com.lvbo.guavatest.eventbus.trade.model.TradeAccountEvent;
import com.lvbo.guavatest.eventbus.trade.model.TradeType;

import java.util.Date;

/**
 * Created by lvbo on 16/2/12.
 */
public class SimpleTradeExecutor {
    private EventBus eventBus;

    public SimpleTradeExecutor(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void executeTrade(TradeAccount tradeAccount, double amount, TradeType tradeType) {
        TradeAccountEvent tradeAccountEvent = processTrade(tradeAccount, amount, tradeType);
        eventBus.post(tradeAccountEvent);
    }

    private TradeAccountEvent processTrade(TradeAccount tradeAccount, double amount, TradeType tradeType) {
        Date executionTime = new Date();
        String message = String.format("Processed trade for %s of amount %n type %s @ %s", tradeAccount, amount, tradeType, executionTime);
        TradeAccountEvent tradeAccountEvent = new TradeAccountEvent(tradeAccount, amount, executionTime, tradeType);
        System.out.println(message);
        return tradeAccountEvent;
    }
}
