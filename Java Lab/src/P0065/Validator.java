/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0065;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Validator {
    
    private static Scanner sc = new Scanner(System.in);
    
    public static double inputMark(String subject) {
        double num;
        while (true) {
            try {
                System.out.print(subject+":");
                num = Double.parseDouble(sc.nextLine());
                if (num > 10){
                    System.out.println(subject + " is less than equal ten");
                    continue;
                }
                if (num < 0){
                    System.out.println(subject + " is greater than equal zero");
                    continue;
                }                
                break;
            } catch (NumberFormatException e) {
                System.out.println(subject + " is digidt.");
            }
        }
        return num;
    }    
    
    public static String inputName() {
        while (true) {
            System.out.print("Name:");
            String name = sc.nextLine();
            if (name.isBlank()) {
                System.out.println("Please enter something!");
                continue;
            }
            if (!containsOnlyWord(name)){
                System.out.println("Name can not contains number!");
                continue;
            }
            return name;
        }
    } 
    
    public static boolean containsOnlyWord(String string) {
        for (char c : string.toCharArray()) {
            if (!Character.isAlphabetic(c) && c!=' ') {
                return false;
            }
        }
        return true;
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

    public static boolean inputYesOrNo(){
        while (true){
            String value = inputString("Do you want to enter more student information?(Y/N):");
            if (value.equalsIgnoreCase("Y")) return true;
            else if (value.equalsIgnoreCase("N")) return false;
            else{
                System.out.println("Please enter Y or N!");
            }
        }
    }      
}
