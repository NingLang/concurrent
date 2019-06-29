package yxxy.c_009;

/**
 * @ClassName SiSuo
 * @Desctiption
 * @Author NingLang
 * @Date 2019/6/29 9:31
 * @Version 1.0
 **/
public class SiSuo {
    private Object object1 = "a";
    private Object object2 = "b";
    void m1(){
        synchronized (this.object1){
            System.out.println("m1得到对象1");
            try{
                Thread.sleep(10000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            synchronized (this.object2){
                System.out.println("m1得到对象2");
            }
        }
    }
    void m2(){
        synchronized (this.object2){
            System.out.println("m2得到对象2");
            try{
                Thread.sleep(10000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            synchronized (this.object1){
                System.out.println("m2得到对象1");
            }
        }
    }

    public static void main(String[] args) {
        SiSuo s = new SiSuo();
        new Thread(()->s.m1(),"t1").start();
        new Thread(()->s.m2(),"t2").start();
    }
}
