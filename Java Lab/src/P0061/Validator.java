/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0061;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Validator {
    private static final Scanner sc = new Scanner(System.in);
    public static double inputDouble(String enterMessage) {
        double num;
        while (true) {
            try {
                System.out.println(enterMessage);
                num = Double.parseDouble(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
            }
        }
        return num;
    }
    
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
    
    public static double inputPositiveDouble(String enterMessage){
        while (true){
            double value = inputDouble(enterMessage);
            if (value <= 0){
                System.out.println("Must be > 0");
            }
            else {
                return value;
            }
        }
    }
    
    public static boolean validTriangle(double sideA,double sideB,double sideC){
        if (sideA + sideB > sideC && sideA + sideC > sideB && sideB + sideC > sideA) return true;
        else {
            System.out.println("Invalid triangle!");
            return false;
        }
    }
}
