package com.gxc.singleton;

import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 懒汉式 - 解决线程安全问题 - 完美
 *
 * @author GongXincheng
 * @date 2020/12/16 21:57
 */
public class SingletonDemo5 {

    private static volatile SingletonDemo5 instance;

    private SingletonDemo5() {
    }

    public synchronized static SingletonDemo5 getInstance() throws InterruptedException {
        if (Objects.isNull(instance)) {
            synchronized (SingletonDemo5.class) {
                if (Objects.isNull(instance)) {
                    instance = new SingletonDemo5();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) throws Exception {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(100, 200, 0, TimeUnit.MICROSECONDS,
                new ArrayBlockingQueue<>(500), Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0 ; i < 1000; i++) {
            threadPoolExecutor.execute(() -> {
                try {
                    System.out.println(SingletonDemo5.getInstance());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        Thread.sleep(1000L);
        threadPoolExecutor.shutdown();
    }

}
