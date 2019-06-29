package yxxy.c_003;

/**
 * @ClassName T
 * @Desctiption synchronized 关键字对某个对象加锁
 * @Author NingLang
 * @Date 2019/6/29 7:36
 * @Version 1.0
 **/
public class T {
    private int count = 10;

    //等同于在方法的代码执行时要synchronized(this)
    public synchronized void m(){
        count --;
        System.out.println(Thread.currentThread().getName()+"count = " + count);
    }
}
