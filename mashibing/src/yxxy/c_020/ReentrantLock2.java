package yxxy.c_020;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName ReentrantLock2
 * @Desctiption reentrantlock用于替代synchronized
 * 由于m1锁定this，只有m1执行完毕的时候，m2才能执行
 * 这里是复习synchronized最原始的语义
 *
 * 使用reentrantlock可以完成同样的功能
 * 需要注意的是，必须要必须要必须要手动释放锁
 * 使用syn锁定的话如果遇到异常，jvm自动释放锁，但是lock必须手动释放锁，因此经常在finally中进行锁的释放
 * @Author NingLang
 * @Date 2019/7/8 20:51
 * @Version 1.0
 **/
public class ReentrantLock2 {
    Lock lock = new ReentrantLock();

    void m1(){
        lock.lock();
        try{
            for (int i = 0; i < 10; i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(i);
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    void m2(){
        lock.lock();
        System.out.println("m2 ...");
        lock.unlock();
    }

    public static void main(String[] args) {
        ReentrantLock2 r = new ReentrantLock2();
        new Thread(r::m1).start();
        try {
            TimeUnit.SECONDS.sleep(2);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        new Thread(r::m2).start();
    }

}
