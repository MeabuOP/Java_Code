/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0059;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Validator {
    private static Scanner sc = new Scanner(System.in);
    
    
    public static String inputString(String enterMessage){
        while (true){
            System.out.print(enterMessage);
            String value = sc.nextLine();
            if (value.isEmpty()){
                System.out.println("Please enter something!");
            }
            else{
                return value;
            }
        }
    }
        
    public static int inputInt(String enterMessage){
        int integerValue = 0;
        while (true){
            try{
                String value = inputString(enterMessage);
                integerValue = Integer.parseInt(value);
            }
            catch (NumberFormatException e){
                System.out.println("Not a valid integer!");
                continue;
            }
            return integerValue;
        }
    }

    public static int inputPositiveInt(String enterMessage){
        while (true){
            int salary = inputInt(enterMessage);
            if (salary <= 0){
                System.out.println("Must be >= 0");
            }
            else {
                return salary;
            }
        }
    }
    
    public static double inputDouble(String enterMessage) {
        while (true) {
            try {
                System.out.print(enterMessage);
                double num = Double.parseDouble(sc.nextLine());
                return num;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
            }
        }
    }
    
    public static double inputNonNegativeDouble(String enterMessage) {
        while (true) {
            double num = inputDouble(enterMessage);
            if (num < 0){
                System.out.println("Must >= 0!");
                continue;
            }
            return num;
        }
    }    
}
