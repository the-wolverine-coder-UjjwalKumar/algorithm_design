package com.learning.arrays;

public class PivotInteger {
    public static void main(String[] args) {
        int n = 8;
        System.out.println(pivotInteger(n));
    }

    public static int pivotInteger(int n) {
        // Linear search
        int rightSum = n * (n + 1) / 2;
        for (int i = 1, leftSum = 0; i <= n; ++i) {
            rightSum -= i;
            if (leftSum == rightSum) {
                return i;
            }else if (leftSum > rightSum) {
                return -1;
            }
            leftSum += i;
        }
        return -1;
    }

    public int pivotIntegerBs(int n) {
        // Binary Search
        int sum = n * (n + 1) / 2;
        int low = 1, high = n + 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int leftSum = (mid - 1) * mid / 2;
            int rightSum = sum - (mid + 1) * mid / 2;
            if (leftSum < rightSum) {
                low = mid + 1;
            }else {
                high = mid;
            }
        }
        return (low - 1) * low / 2 == sum - low * (low + 1) / 2 ? low : -1;
    }

}
