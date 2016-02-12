package com.lvbo.guavatest.eventbus.trade.model;

import com.lvbo.guavatest.cache.model.TradeAccount;

import java.util.Date;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by lvbo on 16/2/12.
 */
public class TradeAccountEvent {
    private double amount;
    private Date tradeExecutionTime;
    private TradeType tradeType;
    private TradeAccount tradeAccount;
    public TradeAccountEvent(TradeAccount account, double amount, Date tradeExecutionTime, TradeType tradeType) {
        checkArgument(amount > 0.0, "Trade can't be less than zero");
        this.amount = amount;
        this.tradeExecutionTime = checkNotNull(tradeExecutionTime,"ExecutionTime can't be null");
        this.tradeAccount = checkNotNull(account,"Account can't be null");
        this.tradeType = checkNotNull(tradeType,"TradeType can't be null");
    }
}
