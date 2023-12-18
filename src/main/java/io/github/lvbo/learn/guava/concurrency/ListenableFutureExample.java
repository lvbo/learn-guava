package io.github.lvbo.learn.guava.concurrency;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Executors;

/**
 * @author lvbo created on 2023-12-19 00:05
 */
public class ListenableFutureExample {

    public static void main(String[] args) {
        // 创建一个ListeningExecutorService实例
        ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));

        // 提交一个Callable任务
        ListenableFuture<String> future = service.submit(() -> {
            // 这里模拟一些长时间的计算
            Thread.sleep(1000);
            return "Task completed successfully";
        });

        // 添加回调
        Futures.addCallback(future, new FutureCallback<String>() {
            public void onSuccess(String result) {
                System.out.println(result);
            }

            public void onFailure(Throwable thrown) {
                thrown.printStackTrace();
            }
        }, service);

        // 关闭ExecutorService
//        service.shutdown();
    }
}
