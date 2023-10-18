/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0055;

import java.util.HashMap;
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
            System.out.print(enterMessage);
            integer = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input!");
        }
        return integer;
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
    
    
    public static Doctor checkCodeExist(HashMap<String,Doctor> doctorHash, String code) {
        return doctorHash.get(code);
    }
}