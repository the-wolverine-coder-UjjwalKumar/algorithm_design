package com.learning.recusion;

import java.util.Objects;

public class SudokuSolver {

    public static void main(String[] args) {
        String[][]  board = {
                                {"5","3","*","*","7","*","*","*","*"},
                                {"6","*","*","1","9","5","*","*","*"},
                                {"*","9","8","*","*","*","*","6","*"},
                                {"8","*","*","*","6","*","*","*","3"},
                                {"4","*","*","8","*","3","*","*","1"},
                                {"7","*","*","*","2","*","*","*","6"},
                                {"*","6","*","*","*","*","2","8","*"},
                                {"*","*","*","4","1","9","*","*","5"},
                                {"*","*","*","*","8","*","*","7","9"}
                            };

        String[][]  board1 = {
                {"5","3","*","*","7","*","*","*","*"},
                {"6","*","*","1","9","5","*","*","*"},
                {"*","9","8","*","*","*","*","6","*"},
                {"8","*","*","*","6","*","*","*","3"},
                {"4","*","*","8","*","3","*","*","1"},
                {"7","*","*","*","2","*","*","*","6"},
                {"*","6","*","*","*","*","2","8","*"},
                {"*","*","*","4","1","9","*","*","5"},
                {"*","*","*","*","8","*","*","7","9"}
        };

        System.out.println("Sudoku before solving !! \n");
        printSudoku(board);
        System.out.println("\nSudoku After solving !! \n");
        solveSudoku(board1);
        printSudoku(board1);

    }

    private static boolean solveSudoku(String[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (Objects.equals(board[i][j], "*")) {

                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = ""+c;

                            if (solveSudoku(board))
                                return true;
                            else
                                board[i][j] = "*";
                        }
                    }

                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValid(String[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (Objects.equals(board[i][col], "" + c))
                return false;

            if (Objects.equals(board[row][i], "" + c))
                return false;

            if (Objects.equals(board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3], "" + c))
                return false;
        }
        return true;
    }

    private static void printSudoku(String[][] board) {
        int row = 0;
        int col = 0;
        for (String[] strings : board) {

            for (String string : strings) {

                if(col==2 || col==5)
                    System.out.print(string+"  ");
                else
                    System.out.print(string+" ");

                col++;
            }
            if (row == 2 || row==5)
                System.out.println("\n");
            else
                System.out.println();
            row++;
            col = 0;
        }
    }
}
