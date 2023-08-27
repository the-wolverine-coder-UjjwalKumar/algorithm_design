package com.learning.arrays;

public class SplitArrayInTwoSubsetWithEqualSum {
    public static void main(String[] args) {
        int[] arr = {1, 5, 11, 5};
        boolean isPossible = isPartitionPossible(arr);
        System.out.println(isPossible);
    }

    private static boolean isPartitionPossible(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }

        //return sum % 2 == 0 && splitHelper(arr, arr.length, 0, sum / 2);

        // Memoized code
        int[][] dp = new int[arr.length][sum/2+1];
        return splitHelperMemoizedCode(arr, arr.length, 0, sum/2, dp);

    }

    private static boolean splitHelper(int[] arr, int length, int i, int target) {
        if (i >= length) return false;

        if (target == 0) return true;

        return splitHelper(arr, length, i+1, target - arr[i]) || splitHelper(arr, length, i+1, target);
    }

    private static boolean splitHelperMemoizedCode(int[] arr, int length, int i, int target, int[][] dp) {
        if (i >= length) return false;

        if (target == 0) return true;

        if (dp[i][target]!=-1) {
            return dp[i][target] == 1;
        }

        boolean ans = splitHelper(arr, length, i+1, target - arr[i]) || splitHelper(arr, length, i+1, target);

        dp[i][target] = ans ? 1 : 0;

        return ans;
    }

}
