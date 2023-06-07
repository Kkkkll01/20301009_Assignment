package com.example.common.result;

import cn.hutool.http.HttpStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 系统返回结果的状态枚举
 * @author: Lumos
 * @date: 2023-05-21
 */
@AllArgsConstructor
@Getter
public enum ResultCodeEnum {

    // 调用成功
    SUCCESS(HttpStatus.HTTP_OK, "调用成功"),

    // 调用错误
    REQUEST_ERROR(HttpStatus.HTTP_BAD_REQUEST , "调用错误"),

    // 系统错误
    SYSTEM_EXCEPTION(HttpStatus.HTTP_INTERNAL_ERROR, "系统错误"),

    // 用户未找到
    USER_NOT_FOUND(HttpStatus.HTTP_BAD_REQUEST , "用户名或密码错误"),

    // 密码错误
    PASSWORD_ERROR(HttpStatus.HTTP_BAD_REQUEST, "用户名或密码错误"),

    // 文件上传异常
    FILE_UPLOAD_EXCEPTION(HttpStatus.HTTP_INTERNAL_ERROR, "文件上传失败"),

    // 验证码过期
    CODE_EXPIRE(HttpStatus.HTTP_BAD_REQUEST, "验证码已过期"),

    // 验证码错误
    CODE_ERROR(HttpStatus.HTTP_BAD_REQUEST, "验证码错误，请稍后再试"),

    // 恶意请求接口
    DATA_BUSY(HttpStatus.HTTP_BAD_REQUEST, "请稍后尝试");

    /**
     * 外部响应码
     */
    private final int code;

    /**
     * 提示内容
     */
    private final String message;
}
