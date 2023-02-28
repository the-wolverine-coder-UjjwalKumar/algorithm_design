package com.learning.graph;

public class CollectingGems {
    public static void main(String[] args) {
        // take input as provided
        int r = 3; // rows
        int n = 3; // columns
        // grid
        int[][] grid = {{2, 2, 2},
                {2, 2, 2},
                {2, 2, 2}};

        int gems = getCollectedGems(r, n, grid);
        System.out.println(gems);
    }

    private static int getCollectedGems(int r, int n, int[][] grid) {
        // allowed moves
        // from (x, y) to (x+1, y), (x-1, y), (x,y+1).
        // starting 1,1 -> row-1,col-1
        // exit 3,n -> 2,n-1
        // default value is false
        boolean[][] visited = new boolean[r][n];
        int gems = 0;
        gems = helper(0, 0, r, n, grid, gems, visited);
        return gems;

    }

    private static int helper(int currentRow, int currentCol, int row, int col, int[][] grid, int gems, boolean[][] visited) {

        if (currentRow >= 0 && currentRow < row
                && currentCol >= 0 && currentCol < col) {
            visited[currentRow][currentCol] = true;
            gems += grid[currentRow][currentCol];

            if (currentRow==row-1 && currentCol==col-1){
                return gems;
            }
        } else {
            return 0;
        }

        int[] delRow = {1, -1, 0};
        int[] delCol = {0, 0, 1};

        for (int i = 0; i < 3; i++) {
            int nR = currentRow + delRow[i];
            int nC = currentCol + delCol[i];

            if (nR >= 0 && nR < row && nC >= 0 && nC < col && !visited[nR][nC])
                return helper(nR, nC, row, col, grid, gems, visited);
        }
        return 0;
    }
}
