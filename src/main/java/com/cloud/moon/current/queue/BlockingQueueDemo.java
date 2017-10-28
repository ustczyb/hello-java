package com.cloud.moon.current.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zhangyubo02 on 2017/10/14.
 * 阻塞队列Demo
 */
public class BlockingQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingDeque<>(5);
        AtomicInteger count = new AtomicInteger(0);

        Producer producer = new Producer(blockingQueue, count);
        Consumer consumer = new Consumer(blockingQueue, count);

        Thread producer1 = new Thread(producer);
        Thread producer2 = new Thread(producer);
        producer1.start();
        producer2.start();

        Thread consumer1 = new Thread(consumer);
        Thread consumer2 = new Thread(consumer);
        consumer1.start();
        consumer2.start();
    }
}

class Producer implements Runnable {

    private BlockingQueue<Integer> blockingQueue;

    private AtomicInteger count;

    public Producer(BlockingQueue<Integer> blockingQueue, AtomicInteger count) {
        this.blockingQueue = blockingQueue;
        this.count = count;
    }

    @Override
    public void run() {
        while (count.intValue() < 100) {
            if (blockingQueue.size() < 5) {
//                synchronized (this) {
                int i = count.incrementAndGet();
                    blockingQueue.add(i);
                    System.out.println(Thread.currentThread().getName() + "--- producer --- " + i);
//                }
            }
        }
        System.out.println(Thread.currentThread().getName() + " producer --- " + "end");
    }
}

class Consumer implements Runnable {

    private BlockingQueue<Integer> blockingQueue;

    private AtomicInteger count;

    public Consumer(BlockingQueue<Integer> blockingQueue, AtomicInteger count) {
        this.blockingQueue = blockingQueue;
        this.count = count;
    }

    @Override
    public void run() {
        while (count.intValue() < 100 || !blockingQueue.isEmpty()) {
            try {
//                synchronized (this) {
                    System.out.println(Thread.currentThread().getName() + " consumer --- " + blockingQueue.take());
//                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " consumer --- " + "end");
    }
}