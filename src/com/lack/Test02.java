package com.lack;

/**
 * ClassName:Test02
 * Package:com.lack
 * Description:
 *
 * @Date:2020-09-10 19:53
 * @Author:yuhao@xhu.com
 */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多个Condition实现通知部分线程, 使用更灵活
 */
public class Test02 {
    static class Service{
        private ReentrantLock lock = new ReentrantLock();       //定义锁对象
        //定义两个Condtion对象
        private Condition conditionA = lock.newCondition();
        private Condition conditionB = lock.newCondition();

        //定义方法,使用conditionA等待
        public void waitMethodA(){
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " begin wait:" + System.currentTimeMillis());
                conditionA.await();         //等待
                System.out.println(Thread.currentThread().getName() + " end wait:" + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        //定义方法,使用conditionB等待
        public void waitMethodB(){
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " begin wait:" + System.currentTimeMillis());
                conditionB.await();         //等待
                System.out.println(Thread.currentThread().getName() + " end wait:" + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        //定义方法唤醒conditionA对象上的等待
        public void signalA(){
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " sigal A time = " + System.currentTimeMillis());
                conditionA.signal();
                System.out.println(Thread.currentThread().getName() + " sigal A time = " + System.currentTimeMillis());
            } finally {
                lock.unlock();
            }
        }

        //定义方法唤醒conditionB对象上的等待
        public void signalB(){
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " sigal B time = " + System.currentTimeMillis());
                conditionB.signal();
                System.out.println(Thread.currentThread().getName() + " sigal B time = " + System.currentTimeMillis());
            } finally {
                lock.unlock();
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();

        //开启两个线程,分别调用waitMethodA(),waitMethodB()方法
        new Thread(new Runnable() {
            @Override
            public void run() {
                service.waitMethodA();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                service.waitMethodB();
            }
        }).start();

        Thread.sleep(3000);         //main线程睡眠3秒
//        service.signalA();          //唤醒 conditionA对象上的等待,conditionB上的等待依然继续等待
        service.signalB();
    }
}
