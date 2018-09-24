/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modul5;

import java.util.Scanner;

/**
 *
 * @author Mathias
 */
public class opgD8 {

    public static void main(String[] args) {
        int[][] sudoku = new int[9][9];
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a solution for sudoku");
        for (int h = 0; h < 9; h++) {
            System.out.println("Line " + (h + 1));
            for (int j = 0; j < 9; j++) {
                sudoku[h][j] = input.nextInt();
            }
        }
        /*int[][] sudoku = {
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {2, 3, 4, 5, 6, 7, 8, 9, 1},
            {4, 5, 6, 7, 8, 9, 1, 2, 3},
            {7, 8, 9, 1, 2, 3, 4, 5, 6},
            {5, 6, 7, 8, 9, 1, 2, 3, 4},
            {8, 9, 1, 2, 3, 4, 5, 6, 7},
            {3, 4, 5, 6, 7, 8, 9, 1, 2},
            {6, 7, 8, 9, 1, 2, 3, 4, 5},
            {9, 1, 2, 3, 4, 5, 6, 7, 8}
        };*/
        if (check_solution(sudoku)) {
            for (int h = 0; h < 9; h++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(sudoku[h][j]);
                }
                System.out.println("");
            }
            System.out.println("Valid solution");
        } else {
            for (int h = 0; h < 9; h++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(sudoku[h][j]);
                }
                System.out.println("");
            }
            System.out.println("Not a valid solution");
        }
    }

    public static boolean check_solution(int[][] sudoku) {
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if (sudoku[row][column] < 1 || sudoku[row][column] > 9 || !check_valid(row, column, sudoku)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean check_valid(int row, int col, int[][] sudoku) {
        //Check if sudoku[row][col] is unique in the coulmn
        for (int i = 0; i < 9; i++) {
            if (i != col && sudoku[row][i] == sudoku[row][col]) {
                return false;
            }
        }
        //Check if sudoku[row][col] is unique in the row
        for (int i = 0; i < 9; i++) {
            if (i != row && sudoku[i][col] == sudoku[row][col]) {
                return false;
            }
        }
        //Check if sudoku[row][col] is valid in the 3*3 square
        for (int i = (row / 3) * 3; i < (row / 3) * 3 + 3; i++) {
            for (int j = (col / 3) * 3; j < (col / 3) * 3 + 3; j++) {
                if (!(i == row && j == col) && sudoku[row][col] == sudoku[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
