package io.github.lvbo.learn.guava.concurrency;

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
            public Long call() throws Exception {
                return null;
            }
        });

        FutureCallbackSample callback = new FutureCallbackSample();
        Futures.addCallback(futureTask, callback, executorService);
    }
}

class FutureCallbackSample implements FutureCallback<Long> {
    private Long count = 100L;
    public void onSuccess(Long aLong) {
        count += aLong;
    }

    public void onFailure(Throwable throwable) {
    }

    public Long getCallbackResult() {
        return count;
    }
}
