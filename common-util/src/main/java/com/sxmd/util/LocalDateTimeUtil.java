package com.sxmd.util;

import com.sxmd.constant.ConstantPattern;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Description:  时间工具
 *
 * @author cy
 * @date 2020年06月05日 16:42
 * Version 1.0
 */
public class LocalDateTimeUtil {


    public static String dateToString(LocalDateTime dateTime){
        return dateTime.format(DateTimeFormatter.ofPattern(ConstantPattern.DATE_PATTERN_DATE_TIME));
    }

    public static String dateToString(LocalDateTime dateTime,String pattern){
        return dateTime.format(DateTimeFormatter.ofPattern(pattern));
    }

    public static LocalDateTime stringToLocalDateTime(String localDateTimeStr){
        return LocalDateTime.parse(localDateTimeStr,DateTimeFormatter.ofPattern(ConstantPattern.DATE_PATTERN_DATE_TIME));
    }

    public static LocalDate stringToLocalDate(String localDateStr){
        return LocalDate.parse(localDateStr,DateTimeFormatter.ofPattern(ConstantPattern.DATE_PATTERN_DATE));
    }

    public static LocalTime stringToLocalTime(String localTimeStr){
        return LocalTime.parse(localTimeStr,DateTimeFormatter.ofPattern(ConstantPattern.DATE_PATTERN_TIME));
    }


}
