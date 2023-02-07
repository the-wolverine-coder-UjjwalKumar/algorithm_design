package com.learning.recusion;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubsequence {
    public static void main(String[] args) {
        int[] arr = {3,2,1};
        printAllSubsequence(0, arr, new ArrayList<Integer>());
    }

    // TC : O(2^n x n) since for each index we have 2 option take and not take and n is for printing the subsequence
    // SC : O(n) since at max the depth of recursion stack space is n which is waiting, hence space is O(n)
    public static void printAllSubsequence(int index, int[] arr, List<Integer> ans){
        if(index == arr.length){
            System.out.println(ans.toString());
            return;
        }

        // take
        ans.add(arr[index]);
        printAllSubsequence(index+1, arr,ans);
        ans.remove(ans.size()-1); // backtrack

        //not take
        printAllSubsequence(index+1, arr, ans);

    }
}
