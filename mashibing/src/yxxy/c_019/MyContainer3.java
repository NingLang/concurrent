package yxxy.c_019;

import yxxy.c_017.T;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName MyContainer3
 * @Desctiption
 * @Author NingLang
 * @Date 2019/6/29 13:59
 * @Version 1.0
 **/
public class MyContainer3 {
    List list = new ArrayList();

    public void add(Object o){

        list.add(o);
    }
    public int  size(){
        return list.size();
    }

    public static void main(String[] args) {
        MyContainer3 myContainer3 = new MyContainer3();
        final Object lock = new Object();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    if(myContainer3.size()!=5){
                        try {
                            lock.wait();
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                    System.out.println("容量达到了5个");
                    lock.notify();
                }
            }
        };
        Thread thread = new Thread(runnable,"t1");
        thread.start();
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    for (int i = 0; i < 10; i++) {
                        myContainer3.add(new Object());
                        System.out.println("add " +i);
                        if (myContainer3.size()==5){
                            lock.notify();
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        Thread thread1 = new Thread(runnable1,"t2");
        thread1.start();
    }
}
