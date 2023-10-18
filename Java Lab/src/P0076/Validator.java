/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0076;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Validator {

    private static final Scanner sc = new Scanner(System.in);

    public static String inputString(String enterMessage) {
        while (true) {
            System.out.print(enterMessage);
            String value = sc.nextLine();
            if (value.isEmpty()) {
                System.out.println("Please enter something!");
            } else {
                return value;
            }
        }
    }
    
    public static int inputInteger(String enterMessage) {
        int integerValue = 0;
        while (true) {
            try {
                String value = inputString(enterMessage);
                integerValue = Integer.parseInt(value);
                return integerValue;
            } catch (NumberFormatException e) {
                System.out.println("Not a valid integer!");
            }
        }
    }         
}
