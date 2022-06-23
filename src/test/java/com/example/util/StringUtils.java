package com.example.util;

public class StringUtils {
    public static String getValueAfterColon(String string) {
        return string
                .lines()
                .findFirst()
                .get()
                .substring(string.lastIndexOf(':') + 1).strip();
    }

}
