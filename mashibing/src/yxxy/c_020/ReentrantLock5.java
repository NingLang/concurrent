package yxxy.c_020;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName ReentrantLock5
 * @Desctiption ReentrantLock还可以指定为公平锁
 * @Author NingLang
 * @Date 2019/7/9 10:21
 * @Version 1.0
 **/
public class ReentrantLock5 extends Thread{
    private static ReentrantLock lock = new ReentrantLock(true);
    public void run(){
        for (int i=0;i<100;i++){
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "获得锁");
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLock5 r = new ReentrantLock5();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);

        t1.start();
        t2.start();
    }
}
