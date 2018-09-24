/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modul5;

import java.util.stream.Stream;

/**
 * Conway's Game of Life
 *
 * @author Mathias
 */
public class opgD7 {

    // Length and width of the gameboard (first array, second array)
    final int length, width;

    public opgD7(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public static void main(String[] args) {
        opgD7 now = new opgD7(13, 33);
        now.startGame();
    }

    void startGame() {
        double life = 0.2;
        String[][] generationX = new String[this.length][this.width];
        init(generationX, life);
        while (true) {
            for (String[] dim : generationX) {
                for (String s : dim) {
                    System.out.print(s);
                }
                System.out.println("");
            }
            generationX = life(generationX);
            pause();
        }

    }

    public String[][] checkLife(int col, int row, String[][] currentGen) {
        String[][] neighbours = {
            {"","",""},
            {"",""},
            {"","",""}
        };
        // Left side
        if (col == 0) {
            /* Top row, nothing above so wrap around for neighbours
                       else get the neighbour above */
            if (row == 0) {
                /*
                        above[0] = null;
                        above[1] = null;
                        above[2] = null;
                 */
                neighbours[0][0] = "";
                neighbours[0][1] = currentGen[this.length - 1][col];
                neighbours[0][2] = currentGen[this.length - 1][col + 1];
            } else {
                neighbours[0][0] = "";
                neighbours[0][1] = currentGen[row - 1][col];
                neighbours[0][2] = currentGen[row - 1][col + 1];
            }
            // Neighbour in the same row
            neighbours[1][0] = "";
            neighbours[1][1] = currentGen[row][col + 1];
            /* Bottom row, nothing below so wrap around for neighbours
                       else get the neighbour below */
            if (row == this.length - 1) {
                /*
                        below[0] = null;
                        below[1] = null;
                        below[2] = null;
                 */
                neighbours[2][0] = "";
                neighbours[2][1] = currentGen[0][col];
                neighbours[2][2] = currentGen[0][col + 1];
            } else {
                neighbours[2][0] = "";
                neighbours[2][1] = currentGen[row + 1][col];
                neighbours[2][2] = currentGen[row + 1][col + 1];
            }
        } else if (col == this.width - 1) { // Right Side
            /* Top row, nothing above so wrap around for neighbours
                       else get the neighbour above */
            if (row == 0) {
                /*
                        above[0] = null;
                        above[1] = null;
                        above[2] = null;
                 */
                neighbours[0][0] = currentGen[this.length - 1][col];
                neighbours[0][1] = currentGen[this.length - 1][col - 1];
                neighbours[0][2] = "";
            } else {
                neighbours[0][0] = currentGen[row - 1][col];
                neighbours[0][1] = currentGen[row - 1][col - 1];
                neighbours[0][2] = "";
            }
            // Neighbour in the same row
            neighbours[1][0] = currentGen[row][col - 1];
            neighbours[1][1] = "";
            /* Bottom row, nothing below so wrap around for neighbours
                       else get the neighbour below */
            if (row == this.length - 1) {
                /*
                        below[0] = null;
                        below[1] = null;
                        below[2] = null;
                 */
                neighbours[2][0] = currentGen[0][col];
                neighbours[2][1] = currentGen[0][col - 1];
                neighbours[2][2] = "";
            } else {
                neighbours[2][0] = currentGen[row + 1][col];
                neighbours[2][1] = currentGen[row + 1][col - 1];
                neighbours[2][2] = "";
            }
        } else { // Everywhere else
            /* Top row, nothing above so wrap around for neighbours
                       else get the neighbour above */
            if (row == 0) {
                /*
                        above[0] = null;
                        above[1] = null;
                        above[2] = null;
                 */
                neighbours[0][0] = currentGen[this.length - 1][col - 1];
                neighbours[0][1] = currentGen[this.length - 1][col];
                neighbours[0][2] = currentGen[this.length - 1][col + 1];

            } else {
                neighbours[0][0] = currentGen[row - 1][col - 1];
                neighbours[0][1] = currentGen[row - 1][col];
                neighbours[0][2] = currentGen[row - 1][col + 1];
            }
            // Neighbour in the same row
            neighbours[1][0] = currentGen[row][col - 1];
            neighbours[1][1] = currentGen[row][col + 1];
            /* Bottom row, nothing below so wrap around for neighbours
                       else get the neighbour below */
            if (row == this.length - 1) {
                /*
                        below[0] = null;
                        below[1] = null;
                        below[2] = null;
                 */
                neighbours[2][0] = currentGen[0][col - 1];
                neighbours[2][1] = currentGen[0][col];
                neighbours[2][2] = currentGen[0][col + 1];
            } else {
                neighbours[2][0] = currentGen[row + 1][col - 1];
                neighbours[2][1] = currentGen[row + 1][col];
                neighbours[2][2] = currentGen[row + 1][col + 1];
            }
        }
        return neighbours;
    }

    public String[][] life(String[][] currentGen) {
        String[][] nextGen = new String[this.length][this.width];
        for (int row = 0; row < this.length; row++) {
            for (int col = 0; col < this.width; col++) {
                String[][] neighbourhood = checkLife(col, row, currentGen);
                int neighbours = getNeighbours(neighbourhood);
                if (neighbours < 2 || neighbours > 3) {
                    nextGen[row][col] = "_"; // dead
                } else if (neighbours == 3) {
                    nextGen[row][col] = "#"; // life
                } else {
                    nextGen[row][col] = currentGen[row][col]; // no change
                }
            }
        }
        return nextGen;
    }

    public static int getNeighbours(String[][] neighbourhood) {
        int neighbours = 0;
        for(String[] neighbour: neighbourhood) {
            // Each neighbour
            for (String x : neighbour) {
                if (x == "#") {
                    neighbours++; // Count if there is a neighbour
                }
            }
        }
        return neighbours;
    }

    void init(String[][] start, double fill) {
        for (int i = 0; i < start.length; i++) {
            populate(start[i], fill);
        }
        /*
        String[][] start = {
            {"_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "#", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_"},
            {"_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "#", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_"},
            {"_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "#", "#", "#", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_"},
            {"_", "_", "_", "_", "_", "_", "_", "_", "#", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_"},
            {"_", "_", "_", "_", "_", "_", "_", "_", "#", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_"},
            {"_", "_", "#", "#", "#", "_", "_", "_", "#", "#", "#", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_"},
            {"_", "#", "#", "#", "_", "_", "_", "_", "_", "#", "#", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_"},
            {"_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "#", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_"},
            {"_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "#", "_", "_", "_"},
            {"_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "#", "_", "#", "_", "_"},
            {"_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "#", "_", "_", "_"},
            {"_", "_", "#", "#", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "#", "#", "_", "_", "_", "_", "_", "_", "#", "_", "_", "_"},
            {"_", "_", "#", "_", "#", "_", "_", "_", "_", "_", "_", "_", "_", "_", "#", "_", "_", "_", "_", "_", "_", "#", "#", "_", "_", "_", "_", "_", "_", "#", "_", "_", "_"},
            {"_", "_", "_", "#", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "#", "_", "_", "_", "_", "_", "_", "_", "_", "#", "#", "_", "_", "_", "#", "_", "#", "_", "_"},
            {"_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "#", "_", "_", "_", "_", "_", "_", "_", "_", "#", "#", "_", "_", "_", "_", "#", "_", "_", "_"},
            {"_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_"}
        };
         */
        //return start;
    }

    void populate(String[] w, double fill) {
        for (int i = 0; i < w.length; i++) {
            if (Math.random() < fill) {
                w[i] = "#";
            } else {
                w[i] = "_";
            }
        }
    }

    public static void pause() {
        for (long i = 0; i < 1000000000; i++) {
        }
    }
}
