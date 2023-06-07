package com.example.common.exception;

import com.example.common.result.ResultCodeEnum;
import lombok.Data;

/**
 * 通用异常
 * 需要在{@link ResultCodeEnum} 对应枚举值
 * 异常类型有权限错误，恶意请求，系统错误等
 * 异常会真实响应对应错误码
 * @author: Lumos
 * @date: 2023-05-21
 */
@Data
public class CommonException extends RuntimeException {

    public final ResultCodeEnum codeEnum;

    public CommonException() {
        this.codeEnum = ResultCodeEnum.REQUEST_ERROR;
    }

    public CommonException(String message) {
        super(message);
        this.codeEnum = ResultCodeEnum.REQUEST_ERROR;
    }

    public CommonException(ResultCodeEnum codeEnum) {
        super(codeEnum.getMessage());
        this.codeEnum = codeEnum;
    }

    public CommonException(ResultCodeEnum codeEnum, String message) {
        super(message);
        this.codeEnum = codeEnum;
    }
}
