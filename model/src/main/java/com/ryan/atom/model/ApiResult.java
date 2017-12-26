package com.ryan.atom.model;

import java.io.Serializable;
import java.util.Date;

public class ApiResult<T> implements Serializable {
    private int code;
    private T data;
    private String message;
    private Date time;

    public static <T> ApiResult<T> success(T data)
    {
        return new ApiResult(200,data,"",new Date());
    }

    public static ApiResult error(int code,String message)
    {
        return new ApiResult(code,null,message,new Date());
    }

    private ApiResult(int code, T data, String message, Date time) {
        this.code = code;
        this.data = data;
        this.message = message;
        this.time = time;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
