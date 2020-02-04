package pl.hollow.wallstreet.util;

import org.slf4j.helpers.MessageFormatter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StringUtil {

    public static String format(String msg, Object... objs) {
        return MessageFormatter.arrayFormat(msg, objs).getMessage();
    }

    public static LocalDateTime getDate(String date) {
        String pattern = "yyyyMMddHH";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDateTime.from(formatter.parse(date));
    }

    public static String getDate(LocalDateTime localDateTime) {
        String pattern = "yyyyMMddHH";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return formatter.format(localDateTime);
    }

    public static String formatToDate(String dateId) {
        LocalDateTime localDateTime = getDate(dateId);
        String pattern = "yyyy-MM-dd HH:mm";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return formatter.format(localDateTime);
    }

    public static String formatToDateId(String date) {
        return date.substring(0, 13).replace("-", "").replace(" ", "");
    }
}