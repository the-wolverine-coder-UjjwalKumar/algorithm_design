package com.learning.arrays;

public class ArraysLearning {
    public static void main(String[] args) {
        System.out.println("Learning Arrays in depth !!");

        int a = 12;
        int b = 13;
        int c = 14;
        System.out.println("Value of a = "+a);
        System.out.println("Value of b = "+b);
        System.out.println("Value of c = "+c);

        // To store the homogenous data type we can use array :)
        int[] arr = new int[10];
        arr[0] = 1;
        arr[1] = 12;
        System.out.println(arr.getClass().getName());

        int[] arr1 = new int['a'];

        // for int array we can use byte, short, char, int for specifying the size :)
        System.out.println(arr1.length);

    }
}
