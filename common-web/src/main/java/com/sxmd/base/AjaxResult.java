package com.sxmd.base;

import com.sxmd.constant.ResponseCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Description: 返回数据对象，如果返回结果指定泛型，swagger 就会显示
 *
 * @author cy
 * @date 2019年08月06日 15:52
 * Version 1.0
 */
@Data
@ApiModel(value = "返回信息")
public class AjaxResult<T> implements Serializable {

    @ApiModelProperty(value = "请求结果返回码")
    private String code;
    @ApiModelProperty(value = "请求结果描述")
    private String message;
    @ApiModelProperty(value = "数据内容")
    private T data;

    public AjaxResult() {
        ResponseCodeEnum success = ResponseCodeEnum.CODE_0000;
        this.code = success.name();
        this.message = success.getMessage();
    }

    public AjaxResult(ResponseCodeEnum responseEnum,T data) {
        this.code = responseEnum.name();
        this.message = responseEnum.getMessage();
        this.data = data;
    }
    
    public AjaxResult(T data) {
        ResponseCodeEnum success = ResponseCodeEnum.CODE_0000;
        this.code = success.name();
        this.message = success.getMessage();
        this.data = data;
    }

    public AjaxResult error(ResponseCodeEnum responseEnum) {
        this.code = responseEnum.name();
        this.message = responseEnum.getMessage();
        return this;
    }

    public AjaxResult error(String message) {
        this.code = ResponseCodeEnum.CODE_9999.name();
        this.message = message;
        return this;
    }

    public AjaxResult error(ResponseCodeEnum responseEnum,String message) {
        this.code = responseEnum.name();
        this.message = message;
        return this;
    }

}
