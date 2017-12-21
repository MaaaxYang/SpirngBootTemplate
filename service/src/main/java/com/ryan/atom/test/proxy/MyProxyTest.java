package com.ryan.atom.test.proxy;

/**
 * Created by Administrator on 2017/12/19.
 */
public class MyProxyTest implements MyProxyTestInterface{

    public String aaa;

    public MyProxyTest(String aaa) {
        this.aaa = aaa;
    }

    public void test()
    {
        System.out.println("this's MyProxyTest");
        System.out.println("aaa -> " + aaa);
    }
}
