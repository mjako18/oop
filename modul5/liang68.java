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
public class liang68 {

    public static void main(String[] args) {
        System.out.printf("%-10s %10s | %-10s %10s \n","Miles", "Kilometer", "Kilometer", "Miles");
        for (int i = 1, j = 20; i <= 10; i++, j += 5) {
            System.out.printf("%-10d %10f | %-10d %10f \n",i,convertDistances.mileToKilometer(i),j, convertDistances.kilometerToMile(j));
        }
    }
}
