package io.github.lvbo.learn.guava.concurrency;

import com.google.common.util.concurrent.*;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class GuavaFuturesExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));

        // 创建SettableFuture实例
        SettableFuture<Integer> settableFuture = SettableFuture.create();

        // 在未来某个时刻成功设置值
        new Thread(() -> {
            // 假设这是一个长时间运行的异步操作
            try {
                Thread.sleep(2000);
                settableFuture.set(42);
            } catch (InterruptedException e) {
                settableFuture.setException(e);
            }
        }).start();

        // Futures.transform，变换Future的结果
        ListenableFuture<String> transformedFuture = Futures.transform(
                settableFuture,
                input -> "Transformed result: " + input,
                service
        );

        // 添加回调来处理变换后的结果
        Futures.addCallback(transformedFuture, new FutureCallback<String>() {
            @Override
            public void onSuccess(String result) {
                System.out.println("Transformed future onSuccess: " + result);
            }

            @Override
            public void onFailure(Throwable t) {
                System.err.println("Transformed future onFailure: " + t.getMessage());
            }
        }, service);

        // 组合多个异步计算的结果
        ListenableFuture<Integer> future1 = service.submit(() -> {
            // Do some computation
            return 1;
        });
        ListenableFuture<Integer> future2 = service.submit(() -> {
            // Do another computation
            return 2;
        });

        // 创建一个Future, 在所有的Future对象完成后返回一个包含所有结果的List
        ListenableFuture<List<Integer>> allFutures = Futures.allAsList(future1, future2);

        List<Integer> integers = allFutures.get();
        System.out.println("get result:" + integers);

        // 添加回调来处理组合后的结果
        Futures.addCallback(allFutures, new FutureCallback<List<Integer>>() {
            @Override
            public void onSuccess(List<Integer> result) {
                System.out.println("All futures onSuccess: " + result);
            }

            @Override
            public void onFailure(Throwable t) {
                System.err.println("All futures onFailure: " + t.getMessage());
            }
        }, service);

        // 关闭ExecutorService
//        service.shutdown();
    }
}
