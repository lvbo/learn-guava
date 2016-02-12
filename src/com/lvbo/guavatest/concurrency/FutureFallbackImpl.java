package com.lvbo.guavatest.concurrency;

import com.google.common.util.concurrent.FutureFallback;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;

import java.io.FileNotFoundException;

/**
 * Created by lvbo on 16/2/12.
 */
public class FutureFallbackImpl implements FutureFallback<String> {
    @Override
    public ListenableFuture<String> create(Throwable t) throws
            Exception {
        if (t instanceof FileNotFoundException) {
            SettableFuture<String> settableFuture = SettableFuture.create();
            settableFuture.set("Not Found");
            return settableFuture;
        } else {
            throw new Exception(t);
        }
    }
}
