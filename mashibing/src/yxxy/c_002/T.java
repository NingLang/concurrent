package yxxy.c_002;

/**
 * @ClassName T
 * @Desctiption synchronized关键字对某个对象加锁
 * @Author NingLang
 * @Date 2019/6/29 7:32
 * @Version 1.0
 **/
public class T {
    private int count = 10;

    public void m(){
        //任何线程要执行下面的代码，必须先拿到this的锁
        synchronized (this){
            count--;
            System.out.println(Thread.currentThread().getName()+"count = " + count);
        }
    }
}
