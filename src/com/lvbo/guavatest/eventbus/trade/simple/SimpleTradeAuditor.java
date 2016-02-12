package com.lvbo.guavatest.eventbus.trade.simple;

import com.google.common.collect.Lists;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.lvbo.guavatest.eventbus.trade.model.TradeAccountEvent;

import java.util.List;

/**
 * Created by lvbo on 16/2/12.
 */
public class SimpleTradeAuditor {
    private List<TradeAccountEvent> tradeEvents = Lists.newArrayList();

    public SimpleTradeAuditor(EventBus eventBus){
        eventBus.register(this);
    }

    @Subscribe
    public void auditTrade(TradeAccountEvent tradeAccountEvent){
        tradeEvents.add(tradeAccountEvent);
        System.out.println("Received trade "+tradeAccountEvent);
    }
}
