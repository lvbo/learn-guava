package io.github.lvbo.learn.guava.concurrency;

import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;

import java.util.concurrent.Executors;

public class ListenableFutureTaskExample {

    public static void main(String[] args) {
        // 创建一个线程池
        ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newSingleThreadExecutor());

        // 创建ListenableFutureTask
        ListenableFutureTask<String> task = ListenableFutureTask.create(() -> {
            // 模拟一些长时间运行的任务
            Thread.sleep(2000);
            return "Task completed!";
        });

        // 提交任务到线程池
        service.submit(task);

        // 为ListenableFutureTask添加回调
        Futures.addCallback(task, new FutureCallback<String>() {
            @Override
            public void onSuccess(String result) {
                System.out.println("Callback - Task success: " + result);
            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
            }
        }, service);

        // 关闭线程池
//        service.shutdown();
    }
}
