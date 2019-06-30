package yxxy.c_013;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName T
 * @Desctiption volatile并不能保证多个线程共同修改running变量时所带来的不一致的问题，也就是说，volatile不饿能替代synchronized
 * 下面这个程序说明
 * @Author NingLang
 * @Date 2019/6/29 11:31
 * @Version 1.0
 **/
public class T {
    /*volatile*/ int count = 0;
    /*synchronized*/ void m(){
        for (int i = 0; i <10000 ; i++) {
            count++;
        }
    }

    public static void main(String[] args) {
        T t = new T();
        List<Thread> threads = new ArrayList<Thread>();
        for (int i=0;i<10;i++){
            threads.add(new Thread(t::m,"thread-"+i));
        }
        threads.forEach((o)->o.start());
        threads.forEach((o)->{
            try {
                o.join();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        });
        System.out.println(t.count);
    }
}
