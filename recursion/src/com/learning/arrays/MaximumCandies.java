package com.learning.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumCandies {
    public static void main(String[] args) {
        int[] candies = {2,3,5,1,3};
        int extraCandies = 3;
        System.out.println(kidsWithCandies(candies, extraCandies));
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<>();
        int maxi = Arrays.stream(candies).max().getAsInt();

        for(int i : candies) {

            if (maxi <= (i+extraCandies)) ans.add(true);
            else ans.add(false);
        }
        return ans;
    }

    public List<Boolean> kidsWithCandiesOptimal(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<>();
        int maxi = Arrays.stream(candies).max().getAsInt();
        int gap = maxi - extraCandies; // value req. to get more than greatest

        for(int i : candies) {

            if (i >= gap) ans.add(true);
            else ans.add(false);
        }
        return ans;

    }
}
