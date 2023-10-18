/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0053;

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

    public static int inputArrayLength(String enterMessage){
        int length;
        while (true){
            length = inputInteger(enterMessage);
            if (length <= 0) System.out.println("Array length must > 0!");
            else return length;
         }
    }

}