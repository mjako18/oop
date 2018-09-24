/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modul5;

/**
 *
 * @author Mathias
 */
public class liang628 {
    public static void main(String[] args) {
        int number;
        System.out.printf("%-5s %10s\n","p", "2^p-1");
        for(int p=2;p<=31;p++) {
            number = (int)Math.pow(2, p)-1;
            if(opgD5.isPrime(number)) {
                System.out.printf("%-5d %10d\n", p, number);
            }
        }
    }
}
