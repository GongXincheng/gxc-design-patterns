package com.gxc.singleton;

import java.util.Objects;
import java.util.concurrent.*;

/**
 * 懒汉式 - 线程不安全
 *
 * @author GongXincheng
 * @date 2020/12/16 21:57
 */
public class SingletonDemo3 {

    private static SingletonDemo3 instance;

    private SingletonDemo3() {
    }

    public static SingletonDemo3 getInstance() throws InterruptedException {
        if (Objects.isNull(instance)) {
            Thread.sleep(1L);
            instance = new SingletonDemo3();
        }
        return instance;
    }

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(100, 200, 0, TimeUnit.MICROSECONDS,
                new ArrayBlockingQueue<>(500), Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0 ; i < 1000; i++) {
            threadPoolExecutor.execute(() -> {
                try {
                    System.out.println(SingletonDemo3.getInstance());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

}
