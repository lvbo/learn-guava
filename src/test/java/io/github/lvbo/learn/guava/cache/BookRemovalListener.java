package io.github.lvbo.learn.guava.cache;

import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import io.github.lvbo.learn.guava.cache.model.Book;

/**
 * Created by lvbo on 16/2/12.
 */
public class BookRemovalListener implements RemovalListener<String, Book> {
    public void onRemoval(RemovalNotification<String, Book> removalNotification) {

    }
}
