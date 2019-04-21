package com.lvbo.guavatest.eventbus.trade.buysell;

import com.lvbo.guavatest.cache.model.TradeAccount;
import com.lvbo.guavatest.eventbus.trade.model.TradeAccountEvent;
import com.lvbo.guavatest.eventbus.trade.model.TradeType;

import java.util.Date;

/**
 * Created by lvbo on 16/2/12.
 */
public class BuyEvent extends TradeAccountEvent {
    public BuyEvent(TradeAccount tradeAccount, double amount, Date tradExecutionTime) {
        super(tradeAccount, amount, tradExecutionTime, TradeType.BUY);
    }
}
