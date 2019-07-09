package yxxy.c_020;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName ReentrantLock3
 * @Desctiption 使用reentrantlock可以进行“尝试锁定”tryLock，这样无法锁定，或者在指定时间内无法锁定，线程可以决定是否继续等待
 * @Author NingLang
 * @Date 2019/7/9 8:51
 * @Version 1.0
 **/
public class ReentrantLock3 {
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

    /**
     * 使用tryLock进行尝试锁定，不管锁定与否，方法都继续执行
     * 可以根据tryLock的返回值来判定是否锁定
     * 也可以指定tryLock的时间，由于tryLock(time) 抛出异常，所以要注意unclock的处理，必须放到finally中
     */

    void m2(){
//        boolean locked = lock.tryLock();
//        System.out.println("m2 ..." + locked);
//        if (locked) lock.unlock();
        boolean locked = false ;
        try {
            locked = lock.tryLock(5,TimeUnit.SECONDS);
            System.out.println("m2 ..." + locked);
        } catch (InterruptedException e){
            e.printStackTrace();
        } finally {
            if (locked) lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLock3 r = new ReentrantLock3();
        new Thread(r::m1).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        new Thread(r::m2).start();
    }
}
