package com.learning.arrays;

import java.util.Arrays;

public class LargestNumber {
    public static void main(String[] args) {
        int[] arr = {2,1,3,7,4,5};
        System.out.println(getLargestNumber(arr));
        System.out.println(getLargestOptimal(arr));
    }

    private static int getLargestOptimal(int[] arr) {
        // TC O(n)
        int largest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest)
                largest = arr[i];
        }
        return largest;
    }

    private static int getLargestNumber(int[] arr) {
        // TC O(nlogn)
        Arrays.sort(arr);
        return arr[arr.length-1];
    }
}
