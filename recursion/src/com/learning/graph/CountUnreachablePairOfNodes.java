package com.learning.graph;

import java.util.Arrays;

public class CountUnreachablePairOfNodes {

    public static void main(String[] args) {
        // undirected graph
        int n = 3;
        int[][] edeges_1 = {{0,1},{0,2},{1,2}};
        long ans = countPairs(n, edeges_1);
        System.out.println(ans);
    }

    public static long countPairs(int n, int[][] edges) {
        int[][] edgesMatrix = new int[n][n];
        for (int[] edgeRow : edgesMatrix)
            Arrays.fill(edgeRow, 0);

        for (int[] row : edges) {
            int u = row[0];
            int v = row[1];

            edgesMatrix[u][v] = 1;
            edgesMatrix[v][u] = 1;
        }
        long count = 0L;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (edgesMatrix[i][j]!=1){
                    count++;
                }
            }
        }

        return count;
    }
}
