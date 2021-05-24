package com.spring.cloud.web.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * description
 *
 * @author qinchao
 * @date 2020/12/8 10:57
 */
public class DateUtils {

    private final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    private final static String DATE_PATTERN = "yyyy-MM-dd";

    public static String dateString(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern(DATE_PATTERN));
    }

    public static String dateString(LocalDate date, String pattern) {
        return date.format(DateTimeFormatter.ofPattern(pattern));
    }

    public static String datetimeString(LocalDateTime datetime) {
        return datetime.format(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN));
    }

    public static String datetimeString(LocalDateTime datetime, String pattern) {
        return datetime.format(DateTimeFormatter.ofPattern(pattern));
    }

    public static LocalDateTime datetime(String datetime, String pattern) {
        return LocalDateTime.parse(datetime, DateTimeFormatter.ofPattern(pattern));
    }

    public static LocalDateTime datetime(String datetime) {
        return LocalDateTime.parse(datetime, DateTimeFormatter.ofPattern(DATE_TIME_PATTERN));
    }

    public static LocalDate date(String date, String pattern) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern(pattern));
    }

    public static LocalDate date(String date) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern(DATE_PATTERN));
    }

}
