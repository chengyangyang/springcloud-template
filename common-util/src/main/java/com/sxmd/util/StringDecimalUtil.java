package com.sxmd.util;

import com.sxmd.exception.SxmdException;

import java.math.BigDecimal;

/**
 * Description: 使用string 基本运算
 *
 * @author cy
 * @date 2020年06月04日 10:36
 * Version 1.0
 */
public class StringDecimalUtil {

    /**
     * Description:   参数相加计算结果  如  1+2+3   参数是  1 2 3
     *
     * @param params:
     * @return java.lang.String
     * @author cy
     * @date  2020/6/4 13:57
     */
    public static String plus(String ... params){
        BigDecimal startBig = new BigDecimal("0");
        for (int i = 0; i < params.length; i++) {
            // 判断是否为数字
            String param = params[i];
            if(!StringUtil.isNumber(param)){
                throw new SxmdException("含有非数字参数:" + param);
            }
            startBig = startBig.add(new BigDecimal(param));
        }
        return startBig.toPlainString();
    }

    /**
     * Description:   舍去   加法  数相加计算结果  如  1+2+3   参数是  1 2 3
     *
     * @param decimalNum: 保留几位小数
     * @param params:
     * @return java.lang.String
     * @author cy
     * @date  2020/6/4 11:05
     */
    public static String plus(int decimalNum,String ... params){
        BigDecimal startBig = new BigDecimal("0");
        for (int i = 0; i < params.length; i++) {
            // 判断是否为数据
            String param = params[i];
            if(!StringUtil.isNumber(param)){
                throw new SxmdException("含有非数字参数:" + param);
            }
            startBig = startBig.add(new BigDecimal(param));
        }
        return startBig.setScale(decimalNum,BigDecimal.ROUND_DOWN).toPlainString();
    }

    /**
     * Description:   减法  如 23-25-21,参数就是23、25、21
     *
     * @param params:
     * @return java.lang.String
     * @author cy
     * @date  2020/6/4 14:05
     */
    public static String subtract(String ... params){
        if(params.length == 1){
            throw new SxmdException("参数数量最少为2个");
        }
        if(!StringUtil.isNumber(params[0])){
            throw new SxmdException("含有非数字参数:" + params[0]);
        }
        BigDecimal startBig = new BigDecimal(params[0]);
        for (int i = 1; i < params.length; i++) {
            // 判断是否为数字
            String param = params[i];
            if(!StringUtil.isNumber(param)){
                throw new SxmdException("含有非数字参数:" + param);
            }
            startBig = startBig.subtract(new BigDecimal(param));
        }
        return startBig.toPlainString();
    }

    /**
     * Description:   舍去   减法   如 23-25-21,参数就是23、25、21
     *
     * @param decimalNum: 保留几位小数
     * @param params:
     * @return java.lang.String
     * @author cy
     * @date  2020/6/4 11:05
     */
    public static String subtract(int decimalNum,String ... params){
        if(params.length == 1){
            throw new SxmdException("参数数量最少为2个");
        }
        if(!StringUtil.isNumber(params[0])){
            throw new SxmdException("含有非数字参数:" + params[0]);
        }
        BigDecimal startBig = new BigDecimal(params[0]);
        for (int i = 1; i < params.length; i++) {
            // 判断是否为数字
            String param = params[i];
            if(!StringUtil.isNumber(param)){
                throw new SxmdException("含有非数字参数:" + param);
            }
            startBig = startBig.subtract(new BigDecimal(param));
        }
        return startBig.setScale(decimalNum,BigDecimal.ROUND_DOWN).toPlainString();
    }


    /**
     * Description:   乘法    如  1x2x3   参数是  1 2 3
     *
     * @param params:
     * @return java.lang.String
     * @author cy
     * @date  2020/6/4 14:01
     */
    public static String multiply(String ... params){
        BigDecimal startBig = new BigDecimal("1");
        for (int i = 0; i < params.length; i++) {
            // 判断是否为数据
            String param = params[i];
            if(!StringUtil.isNumber(param)){
                throw new SxmdException("含有非数字参数:" + param);
            }
            startBig = startBig.multiply(new BigDecimal(param));
        }
        return startBig.toPlainString();
    }

    /**
     * Description:   乘法  如  1x2x3   参数是  1 2 3
     *
     * @param decimalNum:  保留几位小数
     * @param params:
     * @return java.lang.String
     * @author cy
     * @date  2020/6/4 14:01
     */
    public static String multiply(int decimalNum,String ... params){
        BigDecimal startBig = new BigDecimal("1");
        for (int i = 0; i < params.length; i++) {
            // 判断是否为数据
            String param = params[i];
            if(!StringUtil.isNumber(param)){
                throw new SxmdException("含有非数字参数:" + param);
            }
            startBig = startBig.multiply(new BigDecimal(param));
        }
        return startBig.setScale(decimalNum,BigDecimal.ROUND_DOWN).toPlainString();
    }

    /**
     * Description:   除法  如 23/25/21,参数就是23、25、21
     *
     * @param params:
     * @return java.lang.String
     * @author cy
     * @date  2020/6/4 14:05
     */
    public static String divide(String ... params){
        if(params.length == 1){
            throw new SxmdException("参数数量最少为2个");
        }
        if(!StringUtil.isNumber(params[0])){
            throw new SxmdException("含有非数字参数:" + params[0]);
        }
        BigDecimal startBig = new BigDecimal(params[0]);
        for (int i = 1; i < params.length; i++) {
            // 判断是否为数字
            String param = params[i];
            if(!StringUtil.isNumber(param)){
                throw new SxmdException("含有非数字参数:" + param);
            }
            startBig = startBig.divide(new BigDecimal(param));
        }
        return startBig.toPlainString();
    }

    /**
     * Description:   舍去  除法  如 23/25/21,参数就是23、25、21
     *
     * @param decimalNum: 保留几位小数
     * @param params:
     * @return java.lang.String
     * @author cy
     * @date  2020/6/4 11:05
     */
    public static String divide(int decimalNum,String ... params){
        if(params.length == 1){
            throw new SxmdException("参数数量最少为2个");
        }
        if(!StringUtil.isNumber(params[0])){
            throw new SxmdException("含有非数字参数:" + params[0]);
        }
        BigDecimal startBig = new BigDecimal(params[0]);
        for (int i = 1; i < params.length; i++) {
            // 判断是否为数字
            String param = params[i];
            if(!StringUtil.isNumber(param)){
                throw new SxmdException("含有非数字参数:" + param);
            }
            startBig = startBig.divide(new BigDecimal(param));
        }
        return startBig.setScale(decimalNum,BigDecimal.ROUND_DOWN).toPlainString();
    }

    /**
     * Description:  比较大小   2>1 true
     *
     * @param param1: 2
     * @param param2:  1
     * @return boolean
     * @author cy
     * @date  2020/6/5 9:59
     */
    public static boolean compareGt(String param1,String param2){
        if(!StringUtil.isNumber(param1)){
            throw new SxmdException("含有非数字参数:" + param1);
        }
        if(!StringUtil.isNumber(param2)){
            throw new SxmdException("含有非数字参数:" + param2);
        }
        BigDecimal bigDecimal1 = new BigDecimal(param1);
        BigDecimal bigDecimal2 = new BigDecimal(param2);
        return bigDecimal1.compareTo(bigDecimal2) > 0;
    }

    /**
     * Description:  比较大小   1<2 true
     *
     * @param param1: 2
     * @param param2:  1
     * @return boolean
     * @author cy
     * @date  2020/6/5 9:59
     */
    public static boolean compareLt(String param1,String param2){
        if(!StringUtil.isNumber(param1)){
            throw new SxmdException("含有非数字参数:" + param1);
        }
        if(!StringUtil.isNumber(param2)){
            throw new SxmdException("含有非数字参数:" + param2);
        }
        BigDecimal bigDecimal1 = new BigDecimal(param1);
        BigDecimal bigDecimal2 = new BigDecimal(param2);
        return bigDecimal1.compareTo(bigDecimal2) < 0;
    }

    /**
     * Description:  比较大小   1=2 true
     *
     * @param param1: 2
     * @param param2:  1
     * @return boolean
     * @author cy
     * @date  2020/6/5 9:59
     */
    public static boolean compareEq(String param1,String param2){
        if(!StringUtil.isNumber(param1)){
            throw new SxmdException("含有非数字参数:" + param1);
        }
        if(!StringUtil.isNumber(param2)){
            throw new SxmdException("含有非数字参数:" + param2);
        }
        BigDecimal bigDecimal1 = new BigDecimal(param1);
        BigDecimal bigDecimal2 = new BigDecimal(param2);
        return bigDecimal1.compareTo(bigDecimal2) == 0;
    }


    /**
     * Description:   获得最大值
     *
     * @param params:
     * @return java.lang.String
     * @author cy
     * @date  2020/6/5 13:56
     */
    public static String max(String ... params){
        if(params.length == 1){
            throw new SxmdException("参数数量最少为2个");
        }
        if(!StringUtil.isNumber(params[0])){
            throw new SxmdException("含有非数字参数:" + params[0]);
        }
        String startBig = params[0];
        for (int i = 1; i < params.length; i++) {
            // 判断是否为数字
            String param = params[i];
            if(!StringUtil.isNumber(param)){
                throw new SxmdException("含有非数字参数:" + param);
            }
            if(compareGt(param,startBig)){
                startBig = param;
            }
        }
        return startBig;
    }

    /**
     * Description:   获得最小值
     *
     * @param params:
     * @return java.lang.String
     * @author cy
     * @date  2020/6/5 13:56
     */
    public static String min(String ... params){
        if(params.length == 1){
            throw new SxmdException("参数数量最少为2个");
        }
        if(!StringUtil.isNumber(params[0])){
            throw new SxmdException("含有非数字参数:" + params[0]);
        }
        String startBig = params[0];
        for (int i = 1; i < params.length; i++) {
            // 判断是否为数字
            String param = params[i];
            if(!StringUtil.isNumber(param)){
                throw new SxmdException("含有非数字参数:" + param);
            }
            if(compareLt(param,startBig)){
                startBig = param;
            }
        }
        return startBig;
    }




    public static void main(String[] args) {
        System.out.println(plus(2,"0.0000"));
    }


}
