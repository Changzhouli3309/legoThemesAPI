package com.example.legoThemesAPI.util;

public class Checker {

    public static boolean isAllowedNumber(String s) {
        int n = 0;
        try {
            n = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return n > 0;
    }
}
