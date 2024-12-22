package cn.claycoffee.clayTech.utils;

import org.jetbrains.annotations.Nullable;

public class StrUtil {
    public static String getLeftStr(@Nullable String str, @Nullable String separator) {
        if (str == null || separator == null) {
            return null;
        }
        int index = str.indexOf(separator);
        if (index == -1) {
            return str;
        }
        return str.substring(0, index);
    }

    public static String getRightStr(@Nullable String str, @Nullable String separator) {
        if (str == null || separator == null) {
            return null;
        }
        int index = str.lastIndexOf(separator);
        if (index == -1) {
            return str;
        }
        return str.substring(index + separator.length());
    }
}
