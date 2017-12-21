package com.ryan.atom.test.aop;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/12/1.
 */
@Aspect
@Component
public class LowAspectj {

    @Pointcut("execution(* com.ryan.atom.test.service.AopService.cout(..))")
    public void myPointCut(){
        return;
    }

    @Before("myPointCut()")
    public void before1(){
        System.out.println("aop before1");
    }

    @Before("myPointCut()")
    public void before2(){
        System.out.println("aop before2");
    }

    @AfterReturning("myPointCut()")
    public void after1(){
        System.out.println("aop after1");
    }

    @AfterReturning("myPointCut()")
    public void after2(){
        System.out.println("aop after2");
    }

    @AfterThrowing("myPointCut()")
    public void afterThrow(){
        System.out.println("aop afterThrow");
    }
}
