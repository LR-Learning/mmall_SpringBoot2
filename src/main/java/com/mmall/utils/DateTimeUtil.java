package com.mmall.utils;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;


import java.util.Date;
/**
 * @Author: LR
 * @Descriprition:
 * @Date: Created in 15:37 2021/1/16
 * @Modified By:
 **/
public class DateTimeUtil {

    public static final String STAMDARD_FORMAT = "yyyy-MM-dd HH:mm:ss";

    // str -> date
    public static Date strToDate(String dateTimeStr){
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(STAMDARD_FORMAT);
        DateTime dateTime = dateTimeFormatter.parseDateTime(dateTimeStr);
        return dateTime.toDate();
    }

    // date -> str
    public static String dateToStr(Date date){
        if (date == null){
            return StringUtils.EMPTY;
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(STAMDARD_FORMAT);
    }
}
