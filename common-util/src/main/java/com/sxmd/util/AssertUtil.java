package com.sxmd.util;

import com.sxmd.constant.ResponseCodeEnum;
import com.sxmd.exception.SxmdException;

/**
 * Description:  自定义断言工具类  抛出自定义异常
 *
 * @author cy
 * @date 2020年08月14日 16:59
 * Version 1.0
 */
public class AssertUtil {

    /**
     * Description:   断言非空
     *
     * @param object:
     * @param message:
     * @return void
     * @author cy
     * @date 2020/8/14 17:02
     */
    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new SxmdException(message);
        }
    }

    /**
     * Description:   断言非空
     *
     * @param object:
     * @param responseCodeEnum:
     * @return void
     * @author cy
     * @date 2020/8/14 17:02
     */
    public static void notNull(Object object, ResponseCodeEnum responseCodeEnum) {
        if (object == null) {
            throw new SxmdException(responseCodeEnum);
        }
    }


    /**
     * Description:   断言非空
     *
     * @param object:
     * @param message:
     * @return void
     * @author cy
     * @date 2020/8/14 17:02
     */
    public static void isNull(Object object, String message) {
        if (object != null) {
            throw new SxmdException(message);
        }
    }

    /**
     * Description:   断言非空
     *
     * @param object:
     * @param responseCodeEnum:
     * @return void
     * @author cy
     * @date 2020/8/14 17:02
     */
    public static void isNull(Object object, ResponseCodeEnum responseCodeEnum) {
        if (object != null) {
            throw new SxmdException(responseCodeEnum);
        }
    }

    /**
     * Description:   断言字符串非空
     *
     * @param str:
     * @param message:
     * @return void
     * @author cy
     * @date 2020/8/14 17:02
     */
    public static void hasLength(String str, String message) {
        if (StringUtil.isBlank(str)) {
            throw new SxmdException(message);
        }
    }

    /**
     * Description:   断言字符串非空
     *
     * @param str:
     * @param responseCodeEnum:
     * @return void
     * @author cy
     * @date 2020/8/14 17:02
     */
    public static void hasLength(String str, ResponseCodeEnum responseCodeEnum) {
        if (StringUtil.isBlank(str)) {
            throw new SxmdException(responseCodeEnum);
        }
    }

}
