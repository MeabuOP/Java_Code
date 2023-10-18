/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0063;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Validator {

    private static Scanner sc = new Scanner(System.in);

    public static String inputName() {
        while (true) {
            System.out.print("Please input name:");
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

    public static String inputAddress() {
        while (true) {
            System.out.print("Please input address:");
            String address = sc.nextLine();
            if (address.isBlank()) {
                System.out.println("Please enter something!");
                continue;
            }
            if (!containsOnlyWord(address)){
                System.out.println("Address can not contains number!");
                continue;
            }
            return address;
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
    
    public static double inputDouble(String enterMessage) {
        double num;
        while (true) {
            try {
                System.out.print(enterMessage);
                num = Double.parseDouble(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("You must input digidt.");
            }
        }
        return num;
    }

    public static double inputSalary(){
        while (true){
            double value = inputDouble("Please input salary:");
            if (value <= 0){
                System.out.println("Salary is greater than zero");
            }
            else {
                return value;
            }
        }
    }    
}
