package com.gxc.singleton;

/**
 * 饿汉式 - 静态代码块 单例模式
 *
 * @author GongXincheng
 * @date 2020/12/16 21:57
 */
public class SingletonDemo2 {

    private static final SingletonDemo2 instance;

    static {
        instance = new SingletonDemo2();
    }

    private SingletonDemo2() {
    }

    public static SingletonDemo2 getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(SingletonDemo2.getInstance());
        System.out.println(SingletonDemo2.getInstance());
        System.out.println(SingletonDemo2.getInstance());
        System.out.println(SingletonDemo2.getInstance());
    }

}
