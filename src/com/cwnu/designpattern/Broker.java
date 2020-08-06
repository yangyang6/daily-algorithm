package com.cwnu.designpattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk实现动态代理
 */
public class Broker implements InvocationHandler {

    private Object target;

    public Broker(Object object) {
        this.target = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object object = method.invoke(target, args);
        System.out.println("after");
        return object;
    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        IAct star = new Star();

        IAct broker = (IAct) Proxy.newProxyInstance(IAct.class.getClassLoader(), star.getClass().getInterfaces(), new Broker(star));
        System.out.println("A老板演出需求");
        broker.doDance();

        System.out.println("B老板唱歌需求");
        broker.doSing();
        long end = System.currentTimeMillis();
        System.out.println("花费时间：" + (end - start));
    }
}
