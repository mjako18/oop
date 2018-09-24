/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modul5;

/**
 * udregn omkredsen (2*π*r) af 2 cirkler med radius 3 hhv. 7, og udskriver summen af disse
 * @author Mathias
 */
public class opgD2 {
    public static void main(String[] args) {
        int[] radius = {3,7};
        double total=0;
        for(int i =0;i<radius.length;i++) {
            total+=calculate(radius[i]);
        }
        System.out.println("Samlet omkreds: "+total);
    }
    
    public static double calculate(int r) {
        return 2*Math.PI*r;
    }
}
