package com.sxmd.util;

/**
 * Description: 字符串处理
 *
 * @author cy
 * @date 2019年06月20日 14:27
 * Version 1.0
 */
public class StringUtil extends org.apache.commons.lang3.StringUtils {

    public StringUtil() {
        throw new com.sxmd.exception.SxmdException("工具类不能进行实例化");
    }

    /**
     * Description:   驼峰式转化为下划线字符
     * @author cy
     * @param camelCaseName:
     * @return java.lang.String
     * @date  2019/6/20 14:27
     */
    public static String underscoreName(String camelCaseName) {
        StringBuilder result = new StringBuilder();
        if (camelCaseName != null && camelCaseName.length() > 0) {
            result.append(camelCaseName.substring(0, 1).toLowerCase());
            for (int i = 1; i < camelCaseName.length(); i++) {
                char ch = camelCaseName.charAt(i);
                if (Character.isUpperCase(ch)) {
                    result.append("_");
                    result.append(Character.toLowerCase(ch));
                } else {
                    result.append(ch);
                }
            }
        }
        return result.toString();
    }


    /**
     * Description:   转化为驼峰式
     * @author cy
     * @param underscoreName:
     * @return java.lang.String
     * @date  2019/6/20 14:30
     */
    public static String camelCaseName(String underscoreName) {
        StringBuilder result = new StringBuilder();
        if (underscoreName != null && underscoreName.length() > 0) {
            boolean flag = false;
            for (int i = 0; i < underscoreName.length(); i++) {
                char ch = underscoreName.charAt(i);
                if ("_".charAt(0) == ch) {
                    flag = true;
                } else {
                    if (flag) {
                        result.append(Character.toUpperCase(ch));
                        flag = false;
                    } else {
                        result.append(ch);
                    }
                }
            }
        }
        return result.toString();
    }


    /**
     * Description:   字符串空判断
     * @author cy
     * @param str:
     * @return boolean
     * @date  2019/6/25 11:03
     */
    public static boolean isBlank(String str) {
        int strLen;
        if (str != null && (strLen = str.length()) != 0) {
            for(int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }
            return true;
        } else {
            return true;
        }
    }

    /**
     * Description:   给字符串前面添加0
     *
     * @param str:
     * @param strLength:  固定长度
     * @return java.lang.String
     * @author cy
     * @date  2020/6/23 18:08
     */
    public static String addForStr(String str, int strLength) {
        int strLen = str.length();
        if(strLen >= strLength){
            return str;
        }
        StringBuffer sb = new StringBuffer(strLength - strLen);
        for (int i = 0; i < strLength - strLen; i++) {
            sb.append("0");
        }
        return sb.toString() + str;
    }

    /**
     * Description:   给字符串前面添加设定值
     *
     * @param str:
     * @param strLength:  固定长度
     * @return java.lang.String
     * @author cy
     * @date  2020/6/23 18:08
     */
    public static String addForStr(String str, int strLength,String defalut) {
        int strLen = str.length();
        if(strLen >= strLength){
            return str;
        }
        StringBuffer sb = new StringBuffer(strLength - strLen);
        for (int i = 0; i < strLength - strLen; i++) {
            sb.append(defalut);
        }
        return sb.toString() + str;
    }

    /**
     * Description:   判断一个字符串是否是数字
     *
     * @param str:
     * @return boolean
     * @author cy
     * @date  2020/6/28 15:32
     */
    public static boolean isNumber(String str){
        return str.matches("(\\s)*([+-])?(([0-9]*\\.)?([0-9]+)|([0-9]+)(\\.[0-9]*)?)([eE][\\+-]?[0-9]+)?(\\s)*");
    }

}
