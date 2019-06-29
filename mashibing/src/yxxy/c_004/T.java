package yxxy.c_004;

/**
 * @ClassName T
 * @Desctiption
 * @Author NingLang
 * @Date 2019/6/29 7:39
 * @Version 1.0
 **/
public class T {
    private static int count = 10;

    //这里等同于synchronized（yxxy.c004.T.class）
    public synchronized static void m(){
        count --;
        System.out.println(Thread.currentThread().getName() + " count = "+count);
    }

    public static void mm() {
        //考虑一下这里写synchronized(this)是否可以
        synchronized (T.class){
            count --;
        }
    }
}
