package yxxy.c_019;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName MyContainer5
 * @Desctiption 实现一个容器，提供两个方法，add和size
 * 写两个线程，线程1添加10个元素到容器中，线程2实现监控元素的个数，当个数到5个时，线程2给出提示并结束
 *
 * 给list台南佳volatile之后，t2能够接收到通知，但是，t2线程的死循环很浪费cpu，如果不用死循环，该怎么做呢
 *
 * 这里使用wait和notify做到，wait会释放锁，而notify不会释放锁，
 * 需要注意的是，使用这种方式必须保证t2先执行，也就是首先让t2监听才可以
 *
 * notify之后，t1必须要释放锁，t2退出后也必须要notify，通知t1继续运行，整个过程通信比较繁琐
 *
 * 使用Latch（门闩）替代wait notify来进行通知
 * 好处是通信方式简单，同时也可以指定等待时间
 * 使用await和countdown方法替代wait和notify
 * CountDownLatch不涉及锁定，当count的值为零时当前线程继续运行
 * 当不涉及同步，只是涉及线程通信的时候，用synchronized+ wait/notify就 显得太重了
 * 这时应该考虑用countDownLatch/cyclicBarrier/semaphore
 * @Author NingLang
 * @Date 2019/6/30 16:21
 * @Version 1.0
 **/
public class MyContainer5 {
    List list = new ArrayList();

    public void add(Object o){

        list.add(o);
    }
    public int  size(){
        return list.size();
    }

    public static void main(String[] args) {
        MyContainer5 container5 = new MyContainer5();

        CountDownLatch latch = new CountDownLatch(1);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("t2开始");
                if(container5.size()!=5){
                    try {
                        latch.await();
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                System.out.println("容量达到了5个");
            }
        };
        Thread thread = new Thread(runnable,"t2");
        thread.start();
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("t1 开始" );
                for (int i = 0; i < 10; i++) {
                    container5.add(new Object());
                    System.out.println("add " +i);
                    if (container5.size()==5){
                        latch.countDown();
                    }
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread1 = new Thread(runnable1,"t1");
        thread1.start();
    }
}
