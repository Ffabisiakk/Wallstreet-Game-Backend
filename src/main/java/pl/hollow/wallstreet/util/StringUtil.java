package pl.hollow.wallstreet.util;

import org.slf4j.helpers.MessageFormatter;

import java.time.LocalDate;

public class StringUtil {

    public static String format(String msg, Object... objs) {
        return MessageFormatter.arrayFormat(msg, objs).getMessage();
    }

    public static LocalDate getDate(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(4, 6));
        int day = Integer.parseInt(date.substring(6, 8));
        return LocalDate.of(year, month, day);
    }
}