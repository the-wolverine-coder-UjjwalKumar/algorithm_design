package com.learning.recusion;

public class SumOfFirstnNumbers {

    public static void main(String[] args) {
        System.out.println("Sum Of first n number using recursion :: "+String.valueOf(getSum(3)));
        printSum(3,0);
        System.out.println("Sum Of first n number using recursion :: "+String.valueOf(findSum(3)));
        System.out.println("Sum Of first n number using recursion :: "+String.valueOf(factorial(5)));

    }

    public static int getSum(int n){
        return getSum(1, n, 0);
    }

    // getting sum in linear order 1 + 2 + 3 ... n
    public static int getSum(int i, int n, int sum){
        if( i> n) return sum;

        sum+=i;
        return getSum(i+1, n, sum);
    }

    // parametrized recursion
    // getting sum in reverse order i.e 3 + 2 + 1
    public static void printSum(int i, int sum){
        if(i < 1) {
            System.out.println("Sum :: "+sum);
            return;
        }

        printSum(i-1, sum+i);
    }

    // functional recursion
    // f(n) sum of n numbers
    // f(n-1) sum of n-1 numbers
    public static int findSum(int n){
        if (n<1) return 0;

        return n + findSum(n-1);
    }

    // Functional Recursion
    public static int factorial(int n){
        if(n==0) return 1;
        return  n * factorial(n-1);
    }
}
