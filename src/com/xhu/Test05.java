package com.xhu;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ClassName:Test05
 * Package:com.xhu
 * Description:
 *
 * @Date:2020-09-07 21:06
 * @Author:yuhao@xhu.com
 */

public class Test05 {
    static class Servier {
        private Lock lock = new ReentrantLock();

        //定义锁对象
        public void serviceMethod() {
            try {//
                lock.lock();//获得锁定，即使调用了线程的 interrupt()方法，也没有真正的中断线程
                //lock.lockInterruptibly();//如果线程被中断了，不会获得锁，会产生异常
                System.out.println(Thread.currentThread().getName() + "-- begin lock");//执行一段耗时的操作
                for (int i = 0; i < Integer.MAX_VALUE; i++) {
                    //new StringBuilder();
                }
                System.out.println(Thread.currentThread().getName() + " -- end lock");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + " ***** 释放锁");
                lock.unlock();//释放锁
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Servier s = new Servier();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                s.serviceMethod();
            }
        };
        Thread t1 = new Thread(r);
        t1.start();
        Thread.sleep(50);
        Thread t2 = new Thread(r);
        t2.start();
        Thread.sleep(50);
        t2.interrupt();
//中断 t2 线程
    }
}

