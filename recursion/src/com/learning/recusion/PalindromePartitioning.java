package com.learning.recusion;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> ans = new ArrayList<>();

        doPalindromePartitioning(s, 0, new ArrayList<>(), ans);

        System.out.println(ans);
    }

    private static void doPalindromePartitioning(String s, int start, List<String> ds, List<List<String>> ans) {

        if(start >= s.length()){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for (int i = start; i < s.length(); i++){
            if(isValidPartition(s, start, i)) {
                String currentSubString = s.substring(start,i+1);
                ds.add(currentSubString);
                doPalindromePartitioning(s, i+1, ds, ans);
                ds.remove(currentSubString);
            }

        }


    }

    private static boolean isValidPartition(String s, int start, int end) {

        while (start < end) {
            if (s.charAt(start)!=s.charAt(end)) return false;
            start++;
            end--;
        }

        return true;
    }
}
