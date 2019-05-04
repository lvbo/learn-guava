package io.github.lvbo.learn.guava.concurrency;

import com.google.common.collect.Maps;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.SettableFuture;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;

public class AsyncFuntionSample implements AsyncFunction<Long, String> {
    private ConcurrentMap<Long, String> map = Maps.newConcurrentMap();
    private ListeningExecutorService listeningExecutorService;

    public ListenableFuture<String> apply(final Long input) throws Exception {
        if (map.containsKey(input)) {
            SettableFuture<String> listenableFuture = SettableFuture.create();
            listenableFuture.set(map.get(input));
            return listenableFuture;
        } else {
            return listeningExecutorService.submit(new Callable<String>() {
                public String call() throws Exception {
//                    String retrieved = service.get(input);
                    String retrieved = "test";
                    map.putIfAbsent(input, retrieved);
                    return retrieved;
                }
            });
        }
    }
}
