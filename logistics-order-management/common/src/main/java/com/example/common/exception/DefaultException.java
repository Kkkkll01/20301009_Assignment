package com.example.common.exception;

/**
 * 默认的异常，只需要说明异常理由
 * 大多数情况下，都是参数不合法而导致的异常，并不会真实响应错误码
 * @author: Lumos
 * @date: 2023-05-21
 */
public class DefaultException extends RuntimeException {

    public DefaultException() {

    }

    public DefaultException(String message) {
        super(message);
    }
}
