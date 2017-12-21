package com.ryan.atom.test.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/12/7.
 */
public class MyDynamicProxy implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        System.out.println("this's proxy - "+methodName+"~");
        return null;
    }
}
