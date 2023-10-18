/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0075;

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
    
    public static int inputSize() {
        int integerValue = 0;
        while (true) {
            try {
                String value = inputString("Enter size(Bytes):");
                integerValue = Integer.parseInt(value);
                if (integerValue < 0){
                    System.out.println("Size must > 0!");
                    continue;
                }
                return integerValue;
            } catch (NumberFormatException e) {
                System.out.println("Not a valid number!");
            }
        }
    }       
}
