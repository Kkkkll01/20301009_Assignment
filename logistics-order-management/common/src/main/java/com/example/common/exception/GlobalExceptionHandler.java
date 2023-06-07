package com.example.common.exception;

import cn.hutool.http.HttpStatus;
import com.example.common.result.HttpResult;
import com.example.common.result.ResultCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理
 * @author: Lumos
 * @date: 2023-05-21
 */
@ControllerAdvice
@Slf4j
@ConditionalOnProperty(value = "common.exception-handle", havingValue = "true", matchIfMissing = true)
public class GlobalExceptionHandler {

    @ExceptionHandler(CommonException.class)
    @ResponseBody
    public HttpResult commonException(CommonException e, HttpServletResponse response) {
        log.error("errCode:{}, outerMessage:{},innerMessage:",e.codeEnum, e.codeEnum.getMessage(), e);
        response.setStatus(e.codeEnum.getCode());
        return HttpResult.error(e.codeEnum);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public HttpResult exception(Exception e, HttpServletResponse response) {
        log.error("innerMessage:", e);
        response.setStatus(ResultCodeEnum.SYSTEM_EXCEPTION.getCode());
        return HttpResult.error(ResultCodeEnum.SYSTEM_EXCEPTION);
    }

    @ExceptionHandler(DefaultException.class)
    @ResponseBody
    public HttpResult defaultException(Exception e, HttpServletResponse response) {
        log.error("innerMessage:", e);
        return HttpResult.error(HttpStatus.HTTP_BAD_REQUEST, e.getMessage());
    }

}
