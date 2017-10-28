package com.cloud.moon.current.semaphore;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by zhangyubo02 on 2017/10/17.
 * 信号量Semaphore的Demo，流控中使用信号量很有用
 */
public class SemaphoreDemo {

    ExecutorService executorService;
    Semaphore semaphore;

    @Before
    public void init() {
        //1.建立一个有10个线程的线程池
        executorService = Executors.newFixedThreadPool(10);
        //2.创建信号量
        semaphore = new Semaphore(5);
    }

    /**
     * tryAcquire方法的使用，该方法获取到信号量返回true，获取不到返回false，不会阻塞
     * tryAcquire有一个重载的方法tryAcquire(long timeout, TimeUnit unit)，表示等待一段时间再返回false
     */
    @Test
    public void testTryAcquire() {
        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                boolean flag = false;
                flag = semaphore.tryAcquire();
                if (!flag) {
                    System.out.println(Thread.currentThread().getName() + "   没有获取到信号量");
                } else {
                    try {
                        Thread.sleep(1000L);
                        System.out.println(Thread.currentThread().getName() + "   获取到信号量");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        semaphore.release();
                    }
                }
            });
        }
    }

    @After
    public void after() {
        executorService.shutdown();
    }
}
