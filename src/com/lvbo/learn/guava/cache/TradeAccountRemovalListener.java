package com.lvbo.guavatest.cache;

import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import com.lvbo.guavatest.cache.model.TradeAccount;

/**
 * Created by lvbo on 16/2/12.
 */
public class TradeAccountRemovalListener implements RemovalListener<String, TradeAccount> {

    @Override
    public void onRemoval(RemovalNotification<String, TradeAccount> removalNotification) {

    }
}
