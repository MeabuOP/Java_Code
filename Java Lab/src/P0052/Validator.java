/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0052;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Validator {

    static Scanner sc = new Scanner(System.in);

    public static int inputInteger(String enterMessage) {
        int integer = 0;
        try {
            System.out.println(enterMessage);
            integer = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input!");
        }
        return integer;
    }

    public static double inputDouble(String enterMessage) {
        double num;
        while (true) {
            try {
                System.out.print(enterMessage);
                num = Double.parseDouble(sc.nextLine().trim());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
            }
        }
        return num;
    }

    public static double inputTotalArea(String enterMessage){
        double totalArea;
        while (true){
            totalArea = inputDouble(enterMessage);
            if (totalArea <= 0) System.out.println("Total area must > 0!");
            else return totalArea;
         }
    }    
    public static String inputString() {
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }    
    }
    
    public static boolean checkCountryExist(ArrayList<EastAsiaCountries> countryList,String countryCode){
        for (EastAsiaCountries eac: countryList){
            if (eac.getCountryCode().equals(countryCode)){
                return false;
            }
        }
        return true;
    }
}