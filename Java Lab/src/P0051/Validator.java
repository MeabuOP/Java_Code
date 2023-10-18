/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0051;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Validator {

    static Scanner sc = new Scanner(System.in);

    public static boolean checkOperator(String Operator) {
        if (Operator.equals("+") || Operator.equals("-") || Operator.equals("*") || Operator.equals("/") || Operator.equals("^") || Operator.equals("=")) {
            return true;
        } else {
            System.out.println("Please input (+, -, *, /, ^)");
            return false;
        }
    }

    public static int inputInteger(String enterMessage,String errorMessage) {
        Scanner scanner = new Scanner(System.in);
        int input = 0;
        try {
            System.out.println(enterMessage);
            input = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(errorMessage);
            scanner.nextLine();  // Clear the input
        }
        return input;
    }

    public static double inputDouble(String enterMessage,String errorMessage) {
        double num;
        while (true) {
            try {
                System.out.print(enterMessage);
                num = Double.parseDouble(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println(errorMessage);
            }
        }
        return num;
    }
}
