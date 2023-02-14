package com.learning.recusion;

import java.util.*;

public class SubsetSumOne {
    public static void main(String[] args) {
        // generate the subset sum in inc order
        int[] arr = {3,2,1};
        List<Integer> ans = new ArrayList<>();
        getSubsetSumMethod2(0, 0,  arr, ans);
        Collections.sort(ans);
        System.out.println(ans);
    }

    public static void getSubsetSumMethod2(int i, int sum, int[] arr, List<Integer> subSetSum){
        if(i >= arr.length){
            subSetSum.add(sum);
            return;
        }

        // pick
        getSubsetSumMethod2(i+1, sum+arr[i], arr, subSetSum);

        //not pick
        getSubsetSumMethod2(i+1, sum, arr, subSetSum);
    }
    private static void getSubsetSum(int i, int[] arr, List<Integer> ds, List<Integer> ans) {
        if(i >= arr.length){
            ans.add(getSum(ds));
            return;
        }

        // pick
        ds.add(arr[i]);
        getSubsetSum(i+1, arr, ds, ans);
        ds.remove(ds.size()-1);

        // not pick
        getSubsetSum(i+1, arr, ds, ans);
    }

    private static Integer getSum(List<Integer> ds) {
        if (ds.size()==0)
            return 0;

        int sum = 0;
        for(int i : ds){
            sum+=i;
        }
        return sum;
    }
}
