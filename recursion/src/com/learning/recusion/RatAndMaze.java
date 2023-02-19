package com.learning.recusion;

import java.util.ArrayList;
import java.util.List;

public class RatAndMaze {
    public static void main(String[] args) {
        int[][] maze = {{1,0,0,0},
                        {1,1,0,1},
                        {1,1,0,0},
                        {0,1,1,1}};
        // rat can move up, down, left, right
        // and reach n-1,m-1
        List<String> ans = findPath(maze, maze.length);
        System.out.println(ans);
    }

    private static void solve(int i, int j, int[][] maze, int n, ArrayList < String > ans, String move,
                              int[][] vis) {
        if (i == n - 1 && j == n - 1) {
            ans.add(move);
            return;
        }

        // downward
        if (i + 1 < n && vis[i + 1][j] == 0 && maze[i + 1][j] == 1) {
            vis[i][j] = 1;
            solve(i + 1, j, maze, n, ans, move + 'D', vis);
            vis[i][j] = 0;
        }

        // left
        if (j - 1 >= 0 && vis[i][j - 1] == 0 && maze[i][j - 1] == 1) {
            vis[i][j] = 1;
            solve(i, j - 1, maze, n, ans, move + 'L', vis);
            vis[i][j] = 0;
        }

        // right
        if (j + 1 < n && vis[i][j + 1] == 0 && maze[i][j + 1] == 1) {
            vis[i][j] = 1;
            solve(i, j + 1, maze, n, ans, move + 'R', vis);
            vis[i][j] = 0;
        }

        // upward
        if (i - 1 >= 0 && vis[i - 1][j] == 0 && maze[i - 1][j] == 1) {
            vis[i][j] = 1;
            solve(i - 1, j, maze, n, ans, move + 'U', vis);
            vis[i][j] = 0;
        }
    }
    public static ArrayList < String > findPath(int[][] m, int n) {
        int[][] vis = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                vis[i][j] = 0;
            }
        }

        ArrayList < String > ans = new ArrayList < > ();
        if (m[0][0] == 1) solve(0, 0, m, n, ans, "", vis);
        return ans;
    }

}
