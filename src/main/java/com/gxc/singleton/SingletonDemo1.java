package com.gxc.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.List;

/**
 * 饿汉式 单例模式
 *
 * @author GongXincheng
 * @date 2020/12/16 21:57
 */
public class SingletonDemo1 {

    /**
     * 用于测试泛型
     */
    private List<SingletonDemo1> list;

    private static final SingletonDemo1 instance = new SingletonDemo1();

    private SingletonDemo1() {
    }

    public static SingletonDemo1 getInstance() {
        return instance;
    }

}


class Run {

    public static void main(String[] args) throws Exception {
        Constructor<SingletonDemo1> constructor = SingletonDemo1.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        SingletonDemo1 singletonDemo1 = constructor.newInstance();

        System.out.println(singletonDemo1);
        System.out.println(SingletonDemo1.getInstance());

        Class<SingletonDemo1> singletonDemo1Class = SingletonDemo1.class;

        Field listField = singletonDemo1Class.getDeclaredField("list");
        listField.setAccessible(true);

        Class<?> type = listField.getType();

        Type genericType = listField.getGenericType();
        String typeName = genericType.getTypeName();
        System.out.println(typeName);


    }

}