package com.sxmd.util;

/**
 * Description:
 *
 * @author cy
 * @date 2020年06月24日 10:22
 * Version 1.0
 */
public class ByteUtil {


    /**
     * Description:   字节转化为十六进制
     *
     * @param s:
     * @return java.lang.String
     * @author cy
     * @date  2020/6/24 10:22
     */
    public static String byteToHex(byte s) {
        String result = Integer.toHexString(s & 0xFF);
        result = StringUtil.addForStr(result,2);
        return result.toUpperCase();
    }



}
