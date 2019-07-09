package yxxy.c_022;

import yxxy.c_010.T;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName ThreadLocal1
 * @Desctiption
 * @Author NingLang
 * @Date 2019/7/9 14:17
 * @Version 1.0
 **/
class Person{
    String name = "zhangsan";
}
public class ThreadLocal1 {
    volatile static Person p = new Person();

    public static void main(String[] args) {
        new Thread(()->{
            try{
                TimeUnit.SECONDS.sleep(2);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(p.name);
        }).start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            p.name = "lisi";
        }).start();
    }
}
