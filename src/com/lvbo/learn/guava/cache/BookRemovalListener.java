package com.lvbo.guavatest.cache;

import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import com.lvbo.guavatest.cache.model.Book;

/**
 * Created by lvbo on 16/2/12.
 */
public class BookRemovalListener implements RemovalListener<String, Book> {
    @Override
    public void onRemoval(RemovalNotification<String, Book> removalNotification) {

    }
}
