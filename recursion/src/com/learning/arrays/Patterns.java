package com.learning.arrays;

public class Patterns {
    public static void main(String[] args) {
        int row = 5, col = 5;
        printPattern1(row, col);
        System.out.println();
        printPattern2(row, col);
        System.out.println();
        printPattern3(row, col);
        System.out.println();
        printPattern4(row, col);
        System.out.println();
        printPattern5(row, col);
        System.out.println();
        printPattern6(row, col);
        System.out.println();
        printPattern7(row, col);
    }

    private static void printPattern7(int row, int col) {
        // print the * in right-angled triangle
        for (int i = 0; i < row; i++) {
            // print space
            for (int space = 0; space < (row-i) ; space++) {
                System.out.print(" ");
            }
            // print star
            for (int j = 0; j < (2*i+1) ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void printPattern6(int row, int col) {
        // print the * in right-angled triangle
        for (int i = 0; i < row; i++) {
            for (int j = 0; j<(col-i) ; j++) {
                System.out.print(" "+(j+1)+" ");
            }
            System.out.println();
        }
    }

    private static void printPattern5(int row, int col) {
        // print the * in right-angled triangle
        for (int i = 0; i < row; i++) {
            for (int j = col - 1 - i; j >= 0; j--) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }

    private static void printPattern4(int row, int col) {
        // print the n -> 1 to n in right-angled triangle
        for (int i = 0; i < row; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(" " + (i + 1) + " ");
            }
            System.out.println();
        }
    }

    private static void printPattern3(int row, int col) {
        // print the n -> 1 to n in right-angled triangle
        for (int i = 0; i < row; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(" " + (j + 1) + " ");
            }
            System.out.println();
        }
    }

    private static void printPattern2(int row, int col) {
        // print the * in right-angled triangle
        for (int i = 0; i < row; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }

    private static void printPattern1(int row, int col) {
        // square matrix having * in each cell
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }
}
