package com.sxmd.util;

import com.sxmd.constant.ConstantPattern;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;

/**
 * Description: 时间处理类
 *
 * @author cy
 * @date 2020年06月24日 17:21
 * Version 1.0
 */
public class DateFormatUtil extends DateFormatUtils {


    public static String formatDateToString(Date date){
        return format(date, ConstantPattern.DATE_PATTERN_DATE_TIME);
    }

}
