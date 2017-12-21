package com.ryan.atom.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/12/19.
 */
public class MyProxyHandler implements InvocationHandler {

    private Object obj;

    public MyProxyHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("this's MyProxyHandler - begin");
        // 这个obj 参数，用来传入 被代理的类的实体，如果是静态类 可以传null 或者 构造函数只有默认的 也可传null，否则如果调用的方法有依赖被代理类的成员变量 就会报错
        method.invoke(obj,args);
        System.out.println("this's MyProxyHandler - end");
        return proxy;
    }
}
