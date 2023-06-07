package com.example.common.result;

import java.io.Serializable;

/**
 * 封装http请求的实体类
 * @author: Lumos
 * @date: 2023-05-21
 */
public class HttpResult<T> implements Serializable {

    private int code;

    private String message;

    private T data;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public HttpResult() {
        // 默认赋值为成功
        this.code = ResultCodeEnum.SUCCESS.getCode();
        this.message = ResultCodeEnum.SUCCESS.getMessage();
    }

    public HttpResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> HttpResult<T> success() {
        return new HttpResult<>();
    }

    public static <T> HttpResult<T> success(T data) {
        HttpResult<T> res = new HttpResult<>();
        res.data = data;
        return res;
    }

    public static <T> HttpResult<T> success(String message, T data) {
        HttpResult<T> res = new HttpResult<>();
        res.message = message;
        res.data = data;
        return res;
    }

    public static <T> HttpResult<T> error() {
        HttpResult<T> res = new HttpResult<>();
        res.code = ResultCodeEnum.SYSTEM_EXCEPTION.getCode();
        res.message = ResultCodeEnum.SYSTEM_EXCEPTION.getMessage();
        return res;
    }

    public static <T> HttpResult<T> error(ResultCodeEnum codeEnum) {
        HttpResult<T> res = new HttpResult<>();
        res.code = codeEnum.getCode();
        res.message = codeEnum.getMessage();
        return res;
    }

    public static <T> HttpResult<T> error(int code, String message) {
        HttpResult<T> res = new HttpResult<>();
        res.code = code;
        res.message = message;
        return res;
    }

    @Override
    public String toString() {
        return "HttpResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

}
