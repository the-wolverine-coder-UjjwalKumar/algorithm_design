package com.learning.recusion;

import java.util.List;
import java.util.ArrayList;

public class GenerateAllSubSetOfArray {
    public static void main(String[] args) {
        int[] arr = {3,2,1};
        printAllSubset(0, arr, new ArrayList<>());

    }

    private static void printAllSubset(int i, int[] arr, List<Integer> ds) {
        if(i >= arr.length){
            System.out.println(ds.toString());
            return;
        }

        // pick
        ds.add(arr[i]);
        printAllSubset(i+1, arr, ds);
        ds.remove(ds.size()-1);

        // not pick
        printAllSubset(i+1, arr, ds);
    }


}
