package io.github.lvbo.learn.guava.concurrency;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

/**
 * Created by lvbo on 16/2/12.
 */
public class FutureCallbackTest {

    @Test
    public void testFutureCallback() {
        ListeningExecutorService executorService = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(5));
        ListenableFuture<String> futureTask = executorService.submit(new Callable<String>() {
            public String call() throws Exception {
                return null;
            }
        });

        FutureCallbackImpl callback = new FutureCallbackImpl();
//        Futures.addCallback(futureTask, callback);
        callback.getCallbackResult();
    }
}
