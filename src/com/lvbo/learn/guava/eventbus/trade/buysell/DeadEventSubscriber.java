package com.lvbo.guavatest.eventbus.trade.buysell;

import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

/**
 * Created by lvbo on 16/2/12.
 */
public class DeadEventSubscriber {
    public DeadEventSubscriber(EventBus eventBus) {
        eventBus.register(this);
    }

    @Subscribe
    public void handleUnsubscribedEvent(DeadEvent deadEvent) {
        System.out.println("deadEvent");
    }
}
