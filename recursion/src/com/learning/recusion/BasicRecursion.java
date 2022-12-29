package com.learning.recusion;

public class BasicRecursion {

    public static void main(String[] args) {
        System.out.println("Hello in the world of recursion !!");
        System.out.println("Calling a recursive function");
        printName(0);
        System.out.println("Control returned from function to main !!");
    }

    public static void printName(int count) {

        //Base case
        if (count > 5) return;

        System.out.println("Hello Ujjwal !!");
        count++;
        printName(count);
    }
}
