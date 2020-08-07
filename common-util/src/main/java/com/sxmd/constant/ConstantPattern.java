package com.sxmd.constant;

/**
 * Description:  Pattern 常量
 *
 * @author cy
 * @date 2020年07月03日 11:23
 * Version 1.0
 */
public interface ConstantPattern {

    /**
     * 正则表达式
     *
     */
    // 组成 数字 字母 下划线
    String REGEX_ALPHANUMERIC_UNDERLINE = "^[0-9a-zA-Z_]+$";


    /**
     * 时间
     */
    String DATE_PATTERN_DATE_TIME = "yyyy-MM-dd HH:mm:ss";
    String DATE_PATTERN_DATE = "yyyy-MM-dd";
    String DATE_PATTERN_TIME = "HH:mm:ss";

}
