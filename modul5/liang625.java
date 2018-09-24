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
public class liang625 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter milliseconds to convert: ");
        long millis = input.nextLong();
        System.out.println(millis + " milliseconds converts to " + convertMillis(millis));
    }

    public static String convertMillis(long millis) {
        int digits = liang62.numberOfDigits(millis);
        int seconds = 0, minutes = 0, hours = 0;
        String time;
        if (digits >= 7) {
            seconds = (int)millis/1000;
            minutes = (int)seconds/60;
            hours = (int)minutes/60;
            minutes -= hours*60;
            seconds -= (hours*3600+minutes*60);
        } else if(digits >= 5) {
            seconds = (int)millis/1000;
            minutes = (int)seconds/60;
            seconds -= minutes*60;
        } else if(digits <= 4) {
            seconds = (int)millis / 1000;
        }
        
        time = hours + ":" + minutes + ":" + seconds;
        return time;
    }
}
