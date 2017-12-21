package com.ryan.atom.test.utils;

import com.ryan.atom.test.aop.MyDynamicProxy;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2017/12/1.
 */
@Component
public class BeanUtil implements ApplicationContextAware {

    private static ApplicationContext beanFactory;

    public static ApplicationContext getBeanFactory() {
        return beanFactory;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        beanFactory = applicationContext;
    }

    public static <T> T getBean(Class<T> beanClass){
        if (beanFactory==null){
            return null;
        }
        return beanFactory.getBean(beanClass);
    }

    public static <T> T getBean(String beanName,Class<T> resultClass){
        if (beanFactory==null){
            return null;
        }
        if (!beanFactory.containsBean(beanName)){
            return null;
        }
        return beanFactory.getBean(beanName,resultClass);
    }

    public static <T> T newInstance(Class<T> type){
        T test = (T)(Proxy.newProxyInstance(type.getClassLoader(),new Class[]{type},new MyDynamicProxy()));
        return test;
    }

    public static void test(){

    }
}
