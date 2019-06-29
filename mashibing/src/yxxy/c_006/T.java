package yxxy.c_006;

/**
 * @ClassName T
 * @Desctiption
 * @Author NingLang
 * @Date 2019/6/29 8:24
 * @Version 1.0
 **/
public class T implements Runnable {
    private int count = 10;

    public synchronized void run(){
        count --;
        System.out.println(Thread.currentThread().getName() + " count = "+count);
    }

    public static void main(String []args){
        T t = new T();
        for (int i = 0; i<5;i++){
            new Thread(t,"THREAD"+i).start();
        }
    }
}
