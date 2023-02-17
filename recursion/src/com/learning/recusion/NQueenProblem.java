package com.learning.recusion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NQueenProblem {

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

        placeNQueen(0, board, ans);
        for(String validSolution : ans)
            System.out.print(validSolution+"\n");

    }

    // TC : N! * 3N - N^2
    // SC : O(N^2)
    private static void placeNQueen(int col, char[][] board, List<String> ans) {

        if (col == board.length) {
            ans.add((getString(board)));
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if(isSafeToPlaceQueen(row, col, board)){
                board[row][col] = 'Q';
                placeNQueen(col+1, board, ans);
                board[row][col] = '*';
            }
        }

    }

    private static boolean isSafeToPlaceQueen(int row, int col, char[][] board) {

        // here will will check only upper left diagonal
        // left row
        // lower left diagonal
        // as we are filling Queens from left to right

        int R = row;
        int C = col;

        // upper left diagonal tp check
        while (row>=0 && col>=0){
            if(board[row][col]=='Q') return false;
            row--;
            col--;
        }

        // left row to check
        row = R;
        col = C;
        while (col>=0){
            if(board[row][col]=='Q') return false;
            col--;
        }

        // upper left diagonal tp check
        row = R;
        col = C;
        while (row>=0 && col>=0 && row<board.length){
            if(board[row][col]=='Q') return false;
            row++;
            col--;
        }

        return true;

    }

    public static String getString(char[][] board) {

        StringBuilder sb = new StringBuilder();

        for (char[] chars : board) {
            for (char aChar : chars) {
                sb.append(aChar);
                sb.append(" ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
