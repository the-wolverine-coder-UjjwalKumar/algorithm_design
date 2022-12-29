package com.learning.recusion;

public class PalindromicString {

    public static void main(String[] args) {
        String s = "abba";
        System.out.println("Input String  :: " + s);
        System.out.println("Given string is palindromic string :: " + isPalindromic(s));
    }

    public static boolean isPalindromic(String s) {
        return helper(0, s);
    }

    public static boolean helper(int i, String s) {
        if (i >= s.length() / 2) return true;

        if (s.charAt(i) != s.charAt(s.length() - i - 1)) return false;

        return helper(i + 1, s);
    }
}
