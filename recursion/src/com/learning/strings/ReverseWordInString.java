package com.learning.strings;

public class ReverseWordInString {
    public static void main(String[] args) {
        String s = "this is an amazing program";
        String ans = getReverseWordFromString(s);
        System.out.println(s);
        System.out.println(ans);
    }

    private static String getReverseWordFromString(String s) {
        String[] words = s.split(" ");
        int n = words.length;
        StringBuilder sb = new StringBuilder();

        for (int i = n-1; i>=0; i--) {
            sb.append(words[i]).append(" ");
        }
        return sb.toString();
    }
}
