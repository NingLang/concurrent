package yxxy.c_024;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TicketSeller1
 * @Desctiption 有N张火车票，每张都有一个编号
 * 同时有是个窗口对外售票
 * 请写一个模拟程序
 * @Author NingLang
 * @Date 2019/7/18 20:12
 * @Version 1.0
 **/
public class TicketSeller1 {
    static List<String> tickets = new ArrayList<>();

    static {
        for(int i = 0;i<10000;i++){
            tickets.add("票编号"+i);
        }
    }

    public static void main(String []args){
        for(int i=0;i<10;i++){
            new Thread( () ->{
                while (tickets.size()>0){
                    System.out.println("销售了--"+tickets.remove(0));
                }
            }).start();
        }
    }
}
