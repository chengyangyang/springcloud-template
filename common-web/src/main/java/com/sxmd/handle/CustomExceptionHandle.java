package com.sxmd.handle;

import com.sxmd.base.AjaxResult;
import com.sxmd.exception.SxmdException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * Description:  自定义异常handler
 *
 * @author cy
 * @date 2020年06月04日 11:29
 * Version 1.0
 */
@RestControllerAdvice
public class CustomExceptionHandle {

    @ExceptionHandler(SxmdException.class)
    public AjaxResult handlesxmdException(SxmdException e) {
        if (e.getResponseCodeEnum() != null) {
            return new AjaxResult().error(e.getResponseCodeEnum());
        } else {
            return new AjaxResult().error(e.getMessage());
        }
    }

    /**
     * Description:    jsr303  异常统一处理
     *
     * @param e:
     * @return com.sxmd.base.AjaxResult
     * @author cy
     * @date 2020/7/2 19:27
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public AjaxResult methodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        String errorMessage = "";
        for (int i = 0; i < fieldErrors.size(); i++) {
            errorMessage = errorMessage + "[" + fieldErrors.get(i).getDefaultMessage() + "]";
        }
        return new AjaxResult().error(errorMessage);
    }


}



