package com.ryan.atom.test.service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * Created by Administrator on 2017/12/14.
 */
public class MyTransactionService {

    @Transactional
    public static void funcA(){
        //TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        System.out.println("func - a start");
        funcB();
        //funcC();
        System.out.println("func - a end");
    }

    @Transactional
    public static void funcB(){
        System.out.println("func - b start");
        try {
            funcC();
        }catch (RuntimeException ex){
            System.out.println(ex.getMessage());
        }
        //throw new RuntimeException("func - b - error");
        System.out.println("func - b end");
    }

    public static void funcC(){
        System.out.println("func - c start");
        try{
            throw new MyException("func - b - myException");
        }catch (RuntimeException ex){
            System.out.println("this's RuntimeException");
            throw new MyException("func - b - myException2");
        }catch (Exception ex){
            System.out.println("this's Exception");
        }
    }
}
