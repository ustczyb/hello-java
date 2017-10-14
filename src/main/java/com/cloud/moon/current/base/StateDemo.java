package com.cloud.moon.current.base;

/**
 * Created by zhangyubo02 on 2017/9/28.
 * 展示对象状态的Demo
 */
public class StateDemo {

    public static void main(String[] args) {
        Seller seller = new Seller(100);
        Thread t1 = new Thread(seller);
        Thread t2 = new Thread(seller);
        Thread t3 = new Thread(seller);
        Thread t4 = new Thread(seller);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class Seller implements Runnable {

    private int count;

    @Override
    public void run() {
        while (count > 0) {
            System.out.println(Thread.currentThread().getName() + " " + count--);
        }
    }

    public Seller(int num) {
        this.count = num;
    }

}
