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
public class liang622 {

    //nextGuess = (lastGuess + n / lastGuess)/2;
    public static void main(String[] args) {
        System.out.print("Enter an integer: ");
        Scanner input = new Scanner(System.in);
        int integer = input.nextInt();
        System.out.println("The squareroot of " + integer + " is approximately " + sqrt(integer));
    }

    public static double sqrt(long n) {
        double nextGuess = 0, lastGuess = 1, acceptDiff = 0.0000001, diff = 0.1;
        if ((lastGuess - nextGuess) > acceptDiff) {
            while (diff > acceptDiff) {
                nextGuess = (lastGuess + n / lastGuess) / 2;
                diff = Math.abs(lastGuess - nextGuess);
                if (diff > acceptDiff) {
                    lastGuess = nextGuess;
                }
            }
        }
        return nextGuess;
    }
}
