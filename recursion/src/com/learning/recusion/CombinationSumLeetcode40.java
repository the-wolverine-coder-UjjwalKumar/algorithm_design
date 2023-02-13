package com.learning.recusion;

import java.util.*;

public class CombinationSumLeetcode40 {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(10,1,2,7,6,1,5));
        int target = 8;
        Set<List<Integer>> ans = new HashSet<>();

        Collections.sort(arr);

        getCombinationSum(0, arr, new ArrayList<>(), ans, target);

        System.out.println(ans);

    }

    private static void getCombinationSum(int index, List<Integer> arr, List<Integer> tmpAns, Set<List<Integer>> ans, int target) {


        if(target==0){
            ans.add(new ArrayList<>(tmpAns));
            return;
        }

        //pick with duplicates avoid
        for(int i = index; i < arr.size(); i++){
            if(i > index && Objects.equals(arr.get(i), arr.get(i - 1))) continue;

            if(arr.get(i) > target) break;

            tmpAns.add(arr.get(i));
            getCombinationSum(i+1, arr, tmpAns, ans, target-arr.get(i));
            tmpAns.remove(arr.get(i));
        }

    }
}
