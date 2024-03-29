package yxxy.c_001;

/**
 * @ClassName T
 * @Desctiption synchronized关键字
 * 对某个对象加锁
 * @Author NingLang
 * @Date 2019/6/29 7:22
 * @Version 1.0
 **/
public class T {
    private int count = 10;
    private Object o = new Object();

    public void m(){
        // 任何线程要执行下面的代码，必须先拿到o的锁
        synchronized (o){
            count--;
            System.out.println(Thread.currentThread().getName()+"count = " + count);
        }
    }
}
