package com.sxmd.exception;

import com.sxmd.constant.ResponseCodeEnum;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * Description: 自定义异常
 *
 * @author cy
 * @date 2019年06月19日 18:13
 * Version 1.0
 */
@Slf4j
@Data
public class SxmdException extends RuntimeException {

    private static final long serialVersionUID = -3781325637548014389L;
    private String message;
    private ResponseCodeEnum responseCodeEnum;

    private SxmdException() {

    }

    public SxmdException(String message) {
        log.warn(message);
        this.message = message;
    }

    public SxmdException(ResponseCodeEnum responseCodeEnum) {
        log.warn(responseCodeEnum.getMessage());
        this.responseCodeEnum = responseCodeEnum;
    }

    public SxmdException(String message, Throwable cause) {
        log.warn(message, cause);
        this.message = message;
    }

}
