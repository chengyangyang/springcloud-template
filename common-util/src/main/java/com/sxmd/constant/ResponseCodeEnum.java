package com.sxmd.constant;


/**
 * Description: 对象返回码
 *
 * @author cy
 * @date 2019年09月23日 14:30
 * Version 1.0
 */
public enum ResponseCodeEnum {

    CODE_0000("请求成功"),
    CODE_8881("token不正确"),
    CODE_8882("token过期"),
    CODE_8883("权限不足"),
    CODE_8884("认证失败"),

    CODE_9991("对象不存在"),
    CODE_9992("对象已存在"),
    CODE_9993("非法的请求参数"),
    CODE_9994("非法的文件类型"),
    CODE_9995("文件不能为空"),
    CODE_9996("暂无数据"),
    CODE_9999("请求失败"),
    ;

    private String message;

    ResponseCodeEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
