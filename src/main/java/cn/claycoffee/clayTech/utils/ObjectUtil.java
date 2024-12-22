package cn.claycoffee.clayTech.utils;

import java.util.List;

public class ObjectUtil {
    public static boolean ExistsInList(int a, int[] b) {
        for (int i : b) {
            if (i == a) {
                return true;
            }
        }
        return false;
    }

    public static boolean ExistsInList(int a, List<Integer> b) {
        for (int i : b) {
            if (i == a) {
                return true;
            }
        }
        return false;
    }

    public static boolean ExistsInList(Object a, List<Object> b) {
        for (Object o : b) {
            if (o.equals(a)) {
                return true;
            }
        }
        return false;
    }

    public static boolean ExistsInList(String a, List<String> b) {
        for (String s : b) {
            if (s.equals(a)) {
                return true;
            }
        }
        return false;
    }
}
