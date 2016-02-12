package com.lvbo.guavatest.eventbus.trade.buysell;

import com.google.common.collect.Lists;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import java.util.List;

/**
 * Created by lvbo on 16/2/12.
 */
public class TradeBuyAuditor {
    private List<BuyEvent> buyEvents = Lists.newArrayList();

    public TradeBuyAuditor(EventBus eventBus) {
        eventBus.register(this);
    }

    @Subscribe
    public void auditBuy(BuyEvent buyEvent){
        buyEvents.add(buyEvent);
        System.out.println("Received TradeBuyEvent "+buyEvent);
    }

    public List<BuyEvent> getBuyEvents() {
        return buyEvents;
    }
}
