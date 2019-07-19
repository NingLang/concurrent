package yxxy.c_024;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName TicketSeller1
 * @Desctiption 有N张火车票，每张都有一个编号
 * 同时有是个窗口对外售票
 * 请写一个模拟程序
 * @Author NingLang
 * @Date 2019/7/18 20:12
 * @Version 1.0
 **/
public class TicketSeller4 {
    static Queue<String> tickets = new ConcurrentLinkedDeque<>();

    static {
        for(int i = 0;i<10000;i++){
            tickets.add("票编号"+i);
        }
    }

    public static void main(String []args){
        for(int i=0;i<10;i++){
            new Thread( () ->{
                while (true) {
                    String s = tickets.poll();
                    if (s == null) break;
                    else System.out.println("销售了--" +s);
                }
            }).start();
        }
    }
}
