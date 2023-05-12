package com.learning.recusion;

import java.util.Arrays;

public class SolveBrainStrom {

    public static void main(String[] args) {
        int[][] questions = {{3,2},{4,3},{4,4},{2,5}};
        int[][] questions1 = {{1,1},{2,2},{3,3},{4,4},{5,5}};
        int[][] questions2 = {{21,5},{92,3},{74,2},{39,4},{58,2},{5,5},{49,4},{65,3}};

        long ans = mostPoints(questions2);
        System.out.println(ans);
    }

    public static long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n+1];
        Arrays.fill(dp, -1);
        return mostPointHelper(0, questions, n, dp);
    }

    public static long mostPointHelper(int i, int[][] questions, int n, long[] dp) {

        if (dp[i] != -1) return dp[i];

        if (i == n-1) return questions[i][0];
        if (i >= n-1) return 0;


        // pick ith index value
        long pick = questions[i][0] + mostPointHelper(i + questions[i][1] + 1, questions, n, dp);
        // not pick ith index value
        long notPick = mostPointHelper(i + 1, questions, n, dp);

        return dp[i] = Math.max(pick,notPick);

    }


}
