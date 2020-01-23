package pl.hollow.wallstreet.util;

import org.slf4j.helpers.MessageFormatter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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

    public static String formatDate(String date) {
        LocalDateTime localDateTime = getDate(date);
        String pattern = "yyyy-MM-dd HH:mm";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return formatter.format(localDateTime);
    }
}