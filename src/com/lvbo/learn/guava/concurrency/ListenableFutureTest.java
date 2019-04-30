package com.lvbo.guavatest.concurrency;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * Created by lvbo on 16/2/12.
 */
public class ListenableFutureTest {

    @Test
    public void test1() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Integer> future = executor.submit(new Callable<Integer>(){
            public Integer call() throws Exception{
//                return service.getCount();
                return 0;
            } });
        //Retrieve the value of computation
        Integer count = future.get();

        ListeningExecutorService service = MoreExecutors.listeningDecorator(executor);

    }

    @Test
    public void testListenableFuture() {
        ListeningExecutorService executorService = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(5));
        ListenableFuture<String> listenableFuture = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return null;
            }
        });

        listenableFuture.addListener(new Runnable() {
            @Override
            public void run() {
//                methodToRunOnFutureTaskCompletion();
            }
        }, executorService);
    }
}
