package com.learning.recusion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintAllPermutationOfArray {
    public static void main(String[] args) {
        Integer[] arr = {1,2,3};
        List<List<Integer>> ans = new ArrayList<>();
        List<List<Integer>> ans1 = new ArrayList<>();

        int[] map = new int[arr.length];
        Arrays.fill(map,-1); // -1 means not taken and 1 means taken

        getAllPermutation(arr, new ArrayList<>(), ans, map);
        getAllPermutationOptimized(0, arr, ans1);
        System.out.println(ans);
        System.out.println(ans1);
    }

    // Brute force
    // Tc - O(n!) * n
    // Sc - O(n) + O(n)
    private static void getAllPermutation(Integer[] arr, List<Integer> ds, List<List<Integer>> ans, int[] map) {

        if(ds.size()==arr.length){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i=0; i< arr.length; i++){
            if(map[i]==-1){
                // I can take that element into my ans
                ds.add(arr[i]);
                map[i] = 1;
                getAllPermutation(arr, ds, ans, map);
                ds.remove(ds.size()-1);
                map[i] = -1;
            }
        }
    }


}
