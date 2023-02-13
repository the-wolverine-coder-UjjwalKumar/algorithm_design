package com.learning.recusion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintOnlyOneSubsequence {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(3,1));

        printOnlyOneSubsequence(arr);

    }

    public static void printOnlyOneSubsequence(List<Integer> arr) {
        printSubsequenceHelper(0, arr, new ArrayList<Integer>());
    }

    private static boolean printSubsequenceHelper(int i, List<Integer> arr, ArrayList<Integer> ans) {

        if(i>=arr.size()){
            System.out.println(ans.toString());
            return true;
        }

        boolean leftCall = false;
        boolean rightCall = false;

        //pick
        ans.add(arr.get(i));
        leftCall = printSubsequenceHelper(i+1, arr, ans);
        ans.remove(arr.get(i));

        if(!leftCall){
            rightCall = printSubsequenceHelper(i+1, arr, ans);
        }

        return leftCall || rightCall;

    }
}
