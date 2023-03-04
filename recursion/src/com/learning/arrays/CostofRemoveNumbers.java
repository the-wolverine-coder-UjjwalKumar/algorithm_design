package com.learning.arrays;

public class CostofRemoveNumbers {
    public static void main(String[] args) {
        int[] arr = {1, 17, 18, 17, 1};
        int[] arr2 = {3, 2, 2, 1};
        int[] arr3 = {2, 2, 2, 3};
        long m = 1000000007;

        long ans = getRemovalCost(arr3, m);
        System.out.println(ans);
    }

    private static long getRemovalCost(int[] arr, long m) {
        if (arr == null || arr.length <= 2) return 0;

        long ans = 0;
        for (int i = 1; i <= arr.length - 2; i++) {
            ans += (Math.min(arr[i - 1], arr[i + 1])) % m;
        }
        return ans % m;
    }
}
