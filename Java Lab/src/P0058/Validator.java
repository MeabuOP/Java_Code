/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0058;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Validator {
    private static Scanner sc = new Scanner(System.in);
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
    
    public static boolean existedWord(HashMap<String,String> dictionary, String english){
        return dictionary.containsKey(english);
    }
    
    public static boolean inputYesOrNo(){
        while (true){
            String value = inputString("Are you sure (Yes/No)?");
            if (value.equalsIgnoreCase("YES")) return true;
            else if (value.equalsIgnoreCase("NO")) return false;
            else{
                System.out.println("Please enter Yes or No!");
            }
        }
    }    
}
