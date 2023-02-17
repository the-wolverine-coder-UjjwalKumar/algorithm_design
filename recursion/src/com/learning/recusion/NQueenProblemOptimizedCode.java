package com.learning.recusion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueenProblemOptimizedCode {

    public static void main(String[] args) {
        // given n, we have to return all possible solution
        // where we can place queen such that it will not attack each other
        int n = 4;

        // building empty board
        char[][] board = new char[n][n];
        for (char[] row : board)
            Arrays.fill(row, '*');

        // to collect final answer
        List<String> ans = new ArrayList<>();
        int leftRow[] = new int[n];
        int upperDiagonal[] = new int[2 * n - 1];
        int lowerDiagonal[] = new int[2 * n - 1];

        placeNQueen(0, board, ans, leftRow, upperDiagonal, lowerDiagonal);
        for(String validSolution : ans)
            System.out.print(validSolution+"\n");

    }

    private static void placeNQueen(int col, char[][] board, List<String> ans, int leftRow[], int lowerDiagonal[], int upperDiagonal[]) {

        if (col == board.length) {
            ans.add((NQueenProblem.getString(board)));
            return;
        }

        for (int row = 0; row < board.length; row++) {

            if (leftRow[row] == 0 && lowerDiagonal[row + col] == 0 && upperDiagonal[board.length - 1 + col - row] == 0) {

                board[row][col] = 'Q';

                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[board.length - 1 + col - row] = 1;

                placeNQueen(col + 1, board, ans, leftRow, lowerDiagonal, upperDiagonal);

                board[row][col] = '*';
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[board.length - 1 + col - row] = 0;
            }
        }
    }
}
