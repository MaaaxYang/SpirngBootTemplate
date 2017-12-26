package com.ryan.atom.model;

import java.io.Serializable;

public class ServiceException extends RuntimeException implements Serializable {
    public ServiceException(String msg) {
        super(msg);
    }
}
