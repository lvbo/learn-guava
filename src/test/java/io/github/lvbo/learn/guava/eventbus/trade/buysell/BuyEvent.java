package io.github.lvbo.learn.guava.eventbus.trade.buysell;

import io.github.lvbo.learn.guava.cache.model.TradeAccount;
import io.github.lvbo.learn.guava.eventbus.trade.model.TradeAccountEvent;
import io.github.lvbo.learn.guava.eventbus.trade.model.TradeType;

import java.util.Date;

/**
 * Created by lvbo on 16/2/12.
 */
public class BuyEvent extends TradeAccountEvent {
    public BuyEvent(TradeAccount tradeAccount, double amount, Date tradExecutionTime) {
        super(tradeAccount, amount, tradExecutionTime, TradeType.BUY);
    }
}
