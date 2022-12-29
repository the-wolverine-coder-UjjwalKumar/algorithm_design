package com.learning.recusion;

import java.util.ArrayList;
import java.util.Arrays;

public class ArraySubsequence {
    public static void main(String[] args) {
        System.out.println("Printing all subsequence of a given array using recursion !!");
        System.out.println("Subsequence :: any sequence which are contiguous or non contiguous and follows the insertion order, are subsequence");
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(4,3,1,2));
        printSubsequence(0, arr, new ArrayList<Integer>());
    }

    private static void printSubsequence(int i, ArrayList<Integer> arr, ArrayList<Integer> ans) {
        if(i >= arr.size()){
            System.out.println(ans.toString());
            return;
        }

        ans.add(arr.get(i));
        printSubsequence(i+1, arr, ans);
        ans.remove(arr.get(i));
        printSubsequence(i+1, arr, ans);

    }
}
