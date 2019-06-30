package yxxy.c_012;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName T
 * @Desctiption volatile 关键字，使一个变量在多个线程之间可见
 * A B 线程都用到一个变量，Java默认是A线程中保留一份copy，这样如果B线程修改了该变量，则A线程未必知道
 * 使用volatile 关键字，会让所有线程都会督导变量的修改值
 *
 * 在下面的代码中，running是存在于堆内存的t对象中
 * 当线程t1开始运行的时候，会把running值从内存中读到ti线程的工作区，在运行过程总直接使用这个copy，并不会每次都去
 * 读取堆内存，这样，当主线程修改running的值之后，ti线程感知不到，所以不会停止运行
 *
 * 使用volatile ，将会强制所有线程都去堆内存中读取running的值
 *
 * volatile并不能保证多个线程共同修改running变量时所带来的不一致的问题，也就是说volatile不能代替synchronized
 * @Author NingLang
 * @Date 2019/6/29 10:42
 * @Version 1.0
 **/
public class T {
    volatile boolean running = true;//对比一下有无volatile的情况下，整个程序运行结果的区别
    void m(){
        System.out.println("m start");
        while (running){

        }
        System.out.println("m end!");
    }

    public static void main(String[] args) {
        T t = new T();
        new Thread(t::m,"t1").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        t.running = false;
    }
}
