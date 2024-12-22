package cn.claycoffee.clayTech.utils;

public class StrUtils {
    public static String getLeftStr(String str, String separator) {
        if (str == null || separator == null) {
            return null;
        }
        int index = str.indexOf(separator);
        if (index == -1) {
            return str;
        }
        return str.substring(0, index);
    }

    public static String getRightStr(String str, String separator) {
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
