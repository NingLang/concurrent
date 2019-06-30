package yxxy.c_019;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName MyContainer1
 * @Desctiption 实现一个容器，提供两个方法，add，size
 * 写两个线程，线程1添加10个元素到容器中，线程2实现监控元素的个数，当个数到5个时候，线程2给出提示并结束
 *
 * @Author NingLang
 * @Date 2019/6/29 13:23
 * @Version 1.0
 **/
public class MyContainer1 {
    volatile List list = new ArrayList();

    public void add(Object o){
        try {
            TimeUnit.SECONDS.sleep(2);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        list.add(o);
    }
    public int  size(){
        return list.size();
    }

    public static void main(String[] args) {
        MyContainer1 myContainer1 = new MyContainer1();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <10 ; i++) {
                    myContainer1.add(i);
                }
            }
        };
        Thread thread = new Thread(runnable,"t1");

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                while (true){
                    if(myContainer1.size()==5){
                        System.out.println("容量到达5个了");
                        break;
                    }
                }
            }
        };
        Thread thread1 = new Thread(runnable1,"t2");

        thread.start();
        thread1.start();
    }

}
