package io.github.lvbo.learn.guava.cache;

import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import io.github.lvbo.learn.guava.cache.model.TradeAccount;

/**
 * Created by lvbo on 16/2/12.
 */
public class TradeAccountRemovalListener implements RemovalListener<String, TradeAccount> {

    public void onRemoval(RemovalNotification<String, TradeAccount> removalNotification) {

    }
}
