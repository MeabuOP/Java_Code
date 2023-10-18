/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0064;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class Validator {

    private static Scanner sc = new Scanner(System.in);

    public static String inputPhone() {
        while (true) {
            System.out.print("Phone number:");
            String phone = sc.nextLine();
            if (!containsOnlyNumber(phone)){
                System.out.println("Phone number must contains only number");
                continue;
            }
            if (!phone.matches("\\d{10}")){
                System.out.println("Phone number must be 10 digits");
                continue;
            }
            return phone;
        }
    }


    public static boolean containsOnlyNumber(String string) {
        for (char c : string.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
    
    public static String inputEmail() {
        while (true) {
            System.out.print("Email:");
            String email = sc.nextLine();
            if (!email.matches("\\w+@\\w+.com")){
                System.out.println("Email must in correct format: abc@xyz.com");
                continue;
            }
            return email;
        }
    }    
    
    public static String inputDate() {
        while (true) {
            System.out.print("Date:");
            String date = sc.nextLine();
            SimpleDateFormat format = new SimpleDateFormat("dd/mm/YYYY");
            try {
                format.setLenient(false);
                format.parse(date);
            } catch (ParseException ex) {
                System.out.println("Date must have correct format(dd/MM/yyyy) and existed!");
                continue;
            }
            return date;
        }
    }     
}
