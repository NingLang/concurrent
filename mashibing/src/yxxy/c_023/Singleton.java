package yxxy.c_023;

/**
 * @ClassName Singleton
 * @Desctiption 线程安全的单例模式
 * 更好的时采用下面的方式。既不用加锁也能实现懒加载
 * @Author NingLang
 * @Date 2019/7/18 20:03
 * @Version 1.0
 **/
public class Singleton {

    private Singleton(){
        System.out.println("single");
    }

    private static class Inner {
        private static Singleton s = new Singleton();
    }

    public  static Singleton getSingle(){
        return Inner.s;
    }

    public static void main(String[] args) {
    }
}
