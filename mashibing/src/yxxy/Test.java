package yxxy;

import yxxy.c_013.T;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName Test
 * @Desctiption
 * @Author NingLang
 * @Date 2019/7/6 15:56
 * @Version 1.0
 **/
public class Test {

    public static void main(String[] args) {
        ExecutorService service = Executors.newWorkStealingPool();
        System.out.println(Runtime.getRuntime().availableProcessors());

    }
}
