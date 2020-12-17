package com.gxc.singleton;

import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 懒汉式 - 解决线程安全问题 - 效率低
 *
 * @author GongXincheng
 * @date 2020/12/16 21:57
 */
public class SingletonDemo4 {

    private static SingletonDemo4 instance;

    private SingletonDemo4() {
    }

    public synchronized static SingletonDemo4 getInstance() throws InterruptedException {
        if (Objects.isNull(instance)) {
            Thread.sleep(1L);
            instance = new SingletonDemo4();
        }
        return instance;
    }

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(100, 200, 0, TimeUnit.MICROSECONDS,
                new ArrayBlockingQueue<>(500), Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0 ; i < 1000; i++) {
            threadPoolExecutor.execute(() -> {
                try {
                    System.out.println(SingletonDemo4.getInstance());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

}
