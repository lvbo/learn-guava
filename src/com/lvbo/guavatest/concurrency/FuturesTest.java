package com.lvbo.guavatest.concurrency;

import com.google.common.util.concurrent.*;
import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

/**
 * Created by lvbo on 16/2/12.
 */
public class FuturesTest {

    @Test
    public void testFutureCallback() throws ExecutionException, InterruptedException {
        ListeningExecutorService executorService = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(5));
        ListenableFuture<Long> futureTask = executorService.submit(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                return null;
            }
        });

        FutureCallbackSample callback = new FutureCallbackSample();
        Futures.addCallback(futureTask, callback);
        ListenableFuture<String> lf = Futures.transform(futureTask, new AsyncFuntionSample());
        ListenableFuture<String> dd = Futures.withFallback(lf, new FutureFallbackImpl());
        System.out.println(dd.get());
    }
}

class FutureCallbackSample implements FutureCallback<Long> {
    private Long count = 100L;
    @Override
    public void onSuccess(Long aLong) {
        count += aLong;
    }

    @Override
    public void onFailure(Throwable throwable) {
    }

    public Long getCallbackResult() {
        return count;
    }
}
