package com.ryan.atom.test.annotation;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/12/19.
 */
public class MyAnnotationTest {

    @MyAnnotation("lambo")
    public void test()
    {
        System.out.println("this's MyAnnotationTest - test");
    }

    public void analyze(){
        Method[] methods = this.getClass().getMethods();
        for (Method method:methods){
            if (method.isAnnotationPresent(MyAnnotation.class)){
                MyAnnotation annotation = method.getDeclaredAnnotation(MyAnnotation.class);
                System.out.println("name：" + annotation.name());
                System.out.println("value：" + annotation.value());
            }
        }
    }
}
