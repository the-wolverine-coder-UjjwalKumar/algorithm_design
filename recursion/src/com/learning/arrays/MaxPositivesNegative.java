package com.learning.arrays;

public class MaxPositivesNegative {
    public static void main(String[] args) {
        int[] nums = {-3,-2,-1,0,0,1,2};
        System.out.println(maximumCount(nums));
    }

    public static int maximumCount(int[] nums) {
        // linearly count positive and negative using two pointers and return max
        // but we have given sorted hence we may apply BS to get first positive int
        // then compute the count for negative and positive
        int indexOfFirstPositive = doBinarySearch(nums, 0, nums.length);
        // means when no positive integer present
        if (indexOfFirstPositive == -1) return nums.length;
        return Math.max((nums.length - indexOfFirstPositive), (indexOfFirstPositive));
    }

    public int maximumCountOp(int[] nums) {
        // All negative or all positive. We can be sure that the larger number will be array's length
        if (nums[0] > 0 || nums[nums.length - 1] < 0) return nums.length;

        // find 0
        int l = 0, r = nums.length - 1, mid;
        while (l < r) {
            mid = l + (r - l) / 2;
            if (nums[mid] < 0) l = mid + 1;
            else r = mid;
        }

        // currently, `l` is pointing to the left most position that nums[l] >= 0
        int neg = l;

        l = 0;
        r = nums.length;
        while (l < r) {
            mid = l + (r - l) / 2;
            if (nums[mid] > 0) r = mid;
            else l = mid + 1;
        }
        // This time, `l` is pointing to the left most position that nums[l] > 0
        int pos = nums.length - l;

        return Math.max(neg, pos);
    }

    private static int doBinarySearch(int[] nums, int low, int high) {
        while (low < high) {
            int mid = low + (high-low)/2;

            if (nums[mid-1] < 0 && nums[mid+1] > 0) {
                // we encounter first positive
                return mid;
            } else if (nums[mid-1] < 0 && nums[mid+1] < 0) {
                low = mid+1;
            } else {
                high = mid -1;
            }
        }

        return -1;
    }
}
