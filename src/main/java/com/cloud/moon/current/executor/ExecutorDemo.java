package com.cloud.moon.current.executor;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by zhangyubo02 on 2017/10/14.
 * 使用Executor的Demo
 */
public class ExecutorDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> System.out.println(Thread.currentThread().getName() + " --- " + "Asynchronous task"));
        }
//        executorService.execute(() -> System.out.println(Thread.currentThread().getName() + " --- " + "Asynchronous task"));

//        executorService.execute(() -> System.out.println(Thread.currentThread().getName() + " --- " + "Asynchronous task2"));

        executorService.shutdown();
    }

    @Test
    public void test() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future future = executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName() + " --- " + "Asynchronous task");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        //阻塞，如果任务结束执行则返回 null
        System.out.println("future.get()=" + future.get());
        System.out.println(Thread.currentThread().getName() + " --- " + "hello");
    }
}
