package io.github.lvbo.learn.guava.eventbus.trade.buysell;

import com.google.common.collect.Lists;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import java.util.List;

/**
 * Created by lvbo on 16/2/12.
 */
public class TradeSellAuditor {
    private List<SellEvent> sellEvents = Lists.newArrayList();

    public TradeSellAuditor(EventBus eventBus) {
        eventBus.register(this);
    }

    @Subscribe
    public void auditSell(SellEvent sellEvent) {
        sellEvents.add(sellEvent);
        System.out.println("Received SellEvent " + sellEvent);
    }

    public List<SellEvent> getSellEvents() {
        return sellEvents;
    }
}
