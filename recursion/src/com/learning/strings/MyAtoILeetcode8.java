package com.learning.strings;

public class MyAtoILeetcode8 {

    public static void main(String[] args) {
        String s = "00432";

        String filterS = getFilterS(s);
        System.out.println(filterS);
        int sValue = getSValue(filterS);
        System.out.println(sValue);
    }

    private static String getFilterS(String s) {
        int i = 0;
        while (i<s.length()) {
            if (s.charAt(i)=='0')
                i++;
            else
                return s.substring(i);
        }

        return s;
    }

    private static int getSValue(String s) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            num += Integer.parseInt(String.valueOf(s.charAt(i))) * Math.pow(10,s.length()-1-i);
        }
        return num;
    }
}
