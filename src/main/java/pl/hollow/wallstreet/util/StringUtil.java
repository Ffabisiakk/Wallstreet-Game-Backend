package pl.hollow.wallstreet.util;

import org.slf4j.helpers.MessageFormatter;

public class StringUtil {

    public static String format(String msg, Object... objs) {
        return MessageFormatter.arrayFormat(msg, objs).getMessage();
    }
}