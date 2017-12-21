package com.ryan.atom.test.service;

/**
 * Created by Administrator on 2017/12/14.
 */
public class MyException extends RuntimeException {
    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }
}
