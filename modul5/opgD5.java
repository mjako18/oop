/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modul5;

/**
 * find alle primtal mellem 100 og 200
 * @author Mathias
 */
public class opgD5 {
    private static boolean[] primes;
    public static void main(String[] args) {
        opgD5.init();
        for(int i =100;i<200;i++) {
            primes[i]=isPrime(i);
        }
        System.out.println("Primes between 100 and 200:");
        for(int i=100;i<200;i++){
            if(primes[i]) {
                System.out.println(i);
            }
        }
    }
    
    public static void init () {
        primes = new boolean[200];
        for(int i=100;i<200;i++) {
            primes[i]=false;
        }
    }
    public static boolean isPrime(int potential) {
        if(potential%2==0) return false;
        int squareroot = (int)Math.sqrt(potential);
        boolean isPrime = true;
        for(int i=2;i<squareroot;i++) {
            if(potential%i==0) {
                isPrime=false;
                break;
            }
        }
        return isPrime;
    }

}
