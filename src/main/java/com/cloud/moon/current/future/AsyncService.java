package com.cloud.moon.current.future;

import com.google.common.util.concurrent.SettableFuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author zhangyubo02
 * create time : 2018/5/22.
 */
public class AsyncService {

    public Future<Integer> asyncCalculate(int a, int b) {
        SettableFuture<Integer> future = SettableFuture.create();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        future.setException(new IllegalAccessException("test exception"));
        return future;
    }

    public static void main(String[] args) {
        AsyncService service = new AsyncService();
        Future<Integer> future = service.asyncCalculate(1, 2);
        Integer res = null;
        try {
            res = future.get();
        } catch (InterruptedException e) {
            System.out.println("interfupted");
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println("execution");
            e.printStackTrace();
            e.getCause().printStackTrace();
        }
        System.out.println(res);
    }
}
