package com.gxc.singleton;

import java.lang.reflect.Constructor;

/**
 * 饿汉式 单例模式
 *
 * @author GongXincheng
 * @date 2020/12/16 21:57
 */
public class SingletonDemo1 {

    private static final SingletonDemo1 instance = new SingletonDemo1();

    private SingletonDemo1() {
    }

    public static SingletonDemo1 getInstance() {
        return instance;
    }

}

//
//class Run {
//
//    public static void main(String[] args) throws Exception {
//
//        System.out.println(SingletonDemo1.getInstance());
//        System.out.println(SingletonDemo1.getInstance());
//        System.out.println(SingletonDemo1.getInstance());
//        System.out.println(SingletonDemo1.getInstance());
//
//        Class<SingletonDemo1> clazz = SingletonDemo1.class;
//        SingletonDemo1 instance = clazz.newInstance();
//        System.out.println(instance);
//
//    }
//
//}