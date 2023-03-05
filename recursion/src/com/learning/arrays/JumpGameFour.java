package com.learning.arrays;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class JumpGameFour {

    public static void main(String[] args) {
        int[] arr = {100, -23, -23, 404, 100, 23, 23, 23, 3, 404};
        int minSteps = minJumps(arr);
        System.out.println(minSteps);
    }

//    private static int minJumps(int[] arr) {
//        if (arr == null) return 0;
//        if (arr.length < 2) return arr.length - 1;
//
//        return helper(0, arr.length, arr);
//    }
//
//    private static int helper(int currentIndex, int n, int[] arr) {
//
//        if (currentIndex < 0) return Integer.MAX_VALUE;
//        if (currentIndex == n-1) return 1;
//
//        int step1 = 1 + helper(currentIndex + 1, n, arr);
//        int step2 = 1 + helper(currentIndex - 1, n, arr);
//        int step3 = Integer.MAX_VALUE;
//        for (int i = currentIndex + 1; i < n; i++) {
//            step3 = 1 + Math.min(step3, helper(i + 1, n, arr));
//        }
//
//        return Math.min(step1, Math.min(step2, step3));
//    }

    public static int minJumps(int[] arr) {
        int n = arr.length;
        HashMap<Integer, List<Integer>> indicesOfValue = new HashMap<>();
        for (int i = 0; i < n; i++)
            indicesOfValue.computeIfAbsent(arr[i], x -> new LinkedList<>()).add(i);
        boolean[] visited = new boolean[n]; visited[0] = true;
        Queue<Integer> q = new LinkedList<>(); q.offer(0);
        int step = 0;
        while (!q.isEmpty()) {
            for (int size = q.size(); size > 0; --size) {
                int i = q.poll();
                if (i == n - 1) return step; // Reached to last index
                List<Integer> next = indicesOfValue.get(arr[i]);
                next.add(i - 1); next.add(i + 1);
                for (int j : next) {
                    if (j >= 0 && j < n && !visited[j]) {
                        visited[j] = true;
                        q.offer(j);
                    }
                }
                next.clear(); // avoid later lookup indicesOfValue arr[i]
            }
            step++;
        }
        return 0;
    }
}
