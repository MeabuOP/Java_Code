/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0056;

import java.util.ArrayList;
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
    
    public static int inputAge(){
        while (true){
            int age = inputInt("Enter age: ");
            if (age < 18 || age > 50){
                System.out.println("Age must be in the range of 18 and 50!");
            }
            else {
                return age;
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
    
    public static boolean validWorkerCode(String code){
        return code.matches("W \\d+");
    }
    
    public static String inputCode(){
        while (true){
            String code = inputString("Enter code:");
            if (validWorkerCode(code)) return code;
            System.out.println("Please follow the right format! (W numbers)");
        }
    }
    
    public static Worker checkCodeExisted(ArrayList<Worker> workerList,String code){
        for (Worker w:workerList){
            if (w.getCode().equalsIgnoreCase(code)){
                return w;
            }
        }
        return null;
    }
}
