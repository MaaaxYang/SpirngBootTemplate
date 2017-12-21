package com.ryan.atom.test.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by Administrator on 2017/12/1.
 */
@Aspect
public class HighAspectJ {

    @Pointcut("execution(* com.ryan.atom.test.service.AopService.aopAround(int)) && args(num)")
    public void myPointcut(int num){
        return;
    }

    @Around("myPointcut(num)")
    public void around(ProceedingJoinPoint joinPoint,int num){
        try{
            System.out.println("before " + num);
            ++num;
            joinPoint.proceed(new Integer[]{num});
            ++num;
            System.out.println("after " + num);
        }catch (Throwable e){
            System.out.println("error");
        }
    }
}
