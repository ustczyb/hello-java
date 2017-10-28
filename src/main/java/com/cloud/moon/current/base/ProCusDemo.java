package com.cloud.moon.current.base;

/**
 * Created by zhangyubo02 on 2017/9/28.
 * 生产者消费者Demo
 */
public class ProCusDemo {
    public static void main(String[] args) {
        Resource resource = new Resource();
        Producer producer = new Producer(resource);
        Consumer consumer = new Consumer(resource);

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

class Resource {
    private int limit = 0;
    private boolean flag = false;

    public boolean isFlag() {
        return flag;
    }

    public int getLimit() {
        return limit;
    }

    public void add() {
        limit++;
        System.out.println(Thread.currentThread().getName() + "  produce --- " + limit);
        flag = true;
    }

    public void minus() {
        System.out.println(Thread.currentThread().getName() + "  consume --- " + limit);
        flag = false;
    }
}

class Producer implements Runnable {

    public Producer(Resource resource) {
        this.resource = resource;
    }

    private Resource resource;

    @Override
    public void run() {
        while (true) {
            synchronized (resource) {
                if(resource.getLimit() >= 100) {
                    resource.notifyAll();
                    System.out.println(Thread.currentThread().getName() + "producer break");
                    break;
                }
                if (!resource.isFlag()) {
                    resource.add();
//                    resource.notify();
                }
                resource.notify();
                try {
                    resource.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(Thread.currentThread().getName() + "producer break");
    }

}

class Consumer implements Runnable {
    private Resource resource;

    public Consumer(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (resource) {
                if(resource.getLimit() >= 100) {
                    resource.notifyAll();
                    System.out.println(Thread.currentThread().getName() + "consumer break");
                    break;
                }
                if(resource.isFlag()) {
                    resource.minus();
//                    resource.notify();
                }
                resource.notify();
                try {
                    resource.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(Thread.currentThread().getName() + "consumer break");
    }
}