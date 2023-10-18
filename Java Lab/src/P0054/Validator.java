/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0054;

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

    public static String inputString(String enterMessage) {
        while (true) {
            System.out.print(enterMessage);
            String result = sc.nextLine().trim();
            result = result.replaceAll("\\s+"," ");
            if (result.isEmpty()) {
                System.err.println("Not empty!");
            } else {
                return result;
            }
        }    
    }
    
    public static String inputPhoneNumber(String enterMessage){
        while (true){
            String phoneNumber = inputString(enterMessage);
            if (phoneNumber.matches("\\d{3}[-. ]?\\d{3}[-. ]?\\d{4}")){
                return phoneNumber;
            }
            else {
                System.out.println("Please input Phone follow");
                System.out.println("• 1234567890");
                System.out.println("• 123-456-7890 ");
                System.out.println("• 123-456-7890 x1234");
                System.out.println("• 123-456-7890 ext1234");
                System.out.println("• 123.456.7890");
                System.out.println("• 123 456 7890");
            }
        }
    }
}