package com.ryan.atom.filters;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerAspect {
    @Pointcut("execution(* com.ryan.atom.controller.TestController.*(..))")
    //@Pointcut("execution(public * com.ryan.atom.controller..*.*(..))")
    public void myPointcut(){
        return;
    }

    @Around("myPointcut()")
    public Object around(ProceedingJoinPoint joinPoint){
        Object res = null;
        try{

            System.out.println("before - controller aspect");

            res = joinPoint.proceed();

            System.out.println("after - controller aspect");
        }catch (Throwable e){
            System.out.println("error - controller aspect");
        }
        return res;
    }


}
