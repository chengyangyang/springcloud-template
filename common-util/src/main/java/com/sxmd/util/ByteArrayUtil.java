package com.sxmd.util;

/**
 * Description:  字节数组工具类
 *
 * @author cy
 * @date 2020年06月23日 14:49
 * Version 1.0
 */
public class ByteArrayUtil {


    /**
     * Description:   byte 数组转换成二进制字符串
     *
     * @param b:
     * @return java.lang.String
     * @author cy
     * @date  2020/6/23 14:52
     */
    public static String converBinaryStr(byte[] b) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            result.append(StringUtil.addForStr(Long.toString(b[i] & 0xff, 2),8));
        }
        return result.toString();
    }

    /**
     * Description:   二进制转化为byte数组
     *
     * @param binaryString:
     * @return byte[]
     * @author cy
     * @date  2020/6/23 17:23
     */
    public static byte[] binaryStrToByteArray(String binaryString) {
        // 数组长度
        int len = 0;
        if(binaryString.length()%8 == 0){
            len = binaryString.length()/8;
        }else{
            len = binaryString.length()/8 + 1;
        }
        byte[] b = new byte[len];
        for (int i = 0; i < len - 1; i++) {
            b[i] = Long.valueOf(binaryString.substring(i * 8,8), 2).byteValue();
        }
        b[len-1] =  Long.valueOf(binaryString.substring((len-1) * 8), 2).byteValue();
        return b;
    }



    /**
     * Description:   十六进制转化位字节数组
     *
     * @param hexString:
     * @return byte[]
     * @author cy
     * @date  2020/6/23 15:44
     */
    public static byte[] hexToBytes(String hexString) {
        if (hexString == null || hexString.equals("")) {
            return null;
        }
        hexString = hexString.toUpperCase().trim();
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | (charToByte(hexChars[pos + 1]) & 0xff));
        }
        return d;
    }

    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

    /**
     * Description:   字节数组转化为16进制
     *
     * @param bytes:
     * @return java.lang.String
     * @author cy
     * @date  2020/6/24 10:23
     */
    public static String bytesToHexStr(byte[] bytes) {
        final char[] hexArray = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] hexChars = new char[bytes.length * 3];
        int v;
        for (int j = 0; j < bytes.length; j++) {
            v = bytes[j] & 0xFF;
            hexChars[j * 3] = hexArray[v >>> 4];
            hexChars[j * 3 + 1] = hexArray[v & 0x0F];
            hexChars[j * 3 + 2] = ' ';
        }
        return new String(hexChars);
    }

   /**
    * Description:   从字节数组中截取字节数组
    *
    * @param src:  数组
    * @param begin:  开始下表
    * @param len:  长度
    * @return byte[]
    * @author cy
    * @date  2020/6/24 15:53
    */
    public static byte[] subBytes(byte[] src, int begin, int len) {
        byte[] bs = new byte[len];
        for (int i = begin; i < begin + len; i++){
            bs[i - begin] = src[i];
        }
        return bs;
    }

    /**
     *
     * 将4个字节的字节数组转换为Int值 由高位到低位
     *
     * @param bytes
     * @return result 整型
     *
     *         方法添加日期: 2014年3月3日 创建者:刘源
     */
    public static int byte2Int(byte[] bytes) {
        int result = 0;
        for (int i = 0; i < bytes.length; i++) {
            result += ((int) (bytes[i] & 0xFF)) << (8 * (bytes.length - i - 1));
        }
        return result;
    }


    /**
     * @函数功能: BCD码转为10进制串(阿拉伯数据)
     * @输入参数: BCD码
     * @输出结果: 10进制串
     */
    public static String bcd2Str(byte[] bytes){
        StringBuffer temp=new StringBuffer(bytes.length*2);

        for(int i=0;i<bytes.length;i++){
            temp.append((byte)((bytes[i]& 0xf0)>>>4));
            temp.append((byte)(bytes[i]& 0x0f));
        }
        return temp.toString().substring(0,1).equalsIgnoreCase("0")?temp.toString().substring(1):temp.toString();
    }

    /**
     * @函数功能: 10进制串转为BCD码
     * @输入参数: 10进制串
     * @输出结果: BCD码
     */
    public static byte[] str2Bcd(String asc) {
        int len = asc.length();
        int mod = len % 2;

        if (mod != 0) {
            asc = "0" + asc;
            len = asc.length();
        }

        byte abt[] = new byte[len];
        if (len >= 2) {
            len = len / 2;
        }

        byte bbt[] = new byte[len];
        abt = asc.getBytes();
        int j, k;

        for (int p = 0; p < asc.length()/2; p++) {
            if ( (abt[2 * p] >= '0') && (abt[2 * p] <= '9')) {
                j = abt[2 * p] - '0';
            } else if ( (abt[2 * p] >= 'a') && (abt[2 * p] <= 'z')) {
                j = abt[2 * p] - 'a' + 0x0a;
            } else {
                j = abt[2 * p] - 'A' + 0x0a;
            }

            if ( (abt[2 * p + 1] >= '0') && (abt[2 * p + 1] <= '9')) {
                k = abt[2 * p + 1] - '0';
            } else if ( (abt[2 * p + 1] >= 'a') && (abt[2 * p + 1] <= 'z')) {
                k = abt[2 * p + 1] - 'a' + 0x0a;
            }else {
                k = abt[2 * p + 1] - 'A' + 0x0a;
            }

            int a = (j << 4) + k;
            byte b = (byte) a;
            bbt[p] = b;
        }
        return bbt;
    }








}
