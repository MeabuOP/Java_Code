/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0051;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class P0051 {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Menu mainMenu = new Menu("========= Calculator Program =========", new String[]{"Normal Calculator", "BMI Calculator", "Exit"}) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1 -> {
                        normalCalculator();
                    }
                    case 2 -> {
                        bmiCalculator();
                    }
                    case 3 -> {
                        exit();
                    }
                    default -> {
                        System.out.println("Invalid choice!");
                    }
                }
            }
        };
        mainMenu.run();
    }

    public static void exit() {
        System.out.println("Thanks for using!");
        System.exit(0);
    }

    public static void normalCalculator() {
        System.out.println("----- Normal Calculator -----");
        double b;
        double memory = 0;
        String operator = null;
        memory = Validator.inputDouble("Enter number: ", "Invalid input");
        do {
            do {
                System.out.print("Enter Operator: ");
                operator = sc.nextLine();
            } while (!Validator.checkOperator(operator));
            if (!operator.equals("=")) {
                b = Validator.inputDouble("Enter number: ", "Invalid input");
                memory = calculate(memory, operator, b);
                System.out.println("Memory:" + memory);
            } else {
                System.out.println("Result:" + memory);
            }
        } while (!operator.equals("="));
    }

    public static double calculate(double a, String operator, double b) {
        switch (operator) {
            case "+" -> {
                return a + b;
            }
            case "-" -> {
                return a - b;
            }
            case "*" -> {
                return a * b;
            }
            case "^" -> {
                return Math.pow(a, b);
            }
            case "/" -> {
                if (b == 0) {
                    System.out.println("Divisor can not be 0!");
                    return a;
                }
                return a / b;
            }
            default -> {
                return a;
            }
        }
    }

    public static void bmiCalculator() {
        System.out.println("----- BMI Calculator -----");
        double weight, height;
        double BMI;
        do {
            weight = Validator.inputDouble("Enter Weight(kg): ", "BMI is digit");
            if (weight <= 0) {
                System.out.println("Weight can not < 0");
            }
        } while (weight <= 0);
        do {
            height = Validator.inputDouble("Enter Height(cm): ", "BMI is digit");
            if (height <= 0) {
                System.out.println("Weight can not < 0");
            }
        } while (height <= 0);
        BMI = weight * 10000 / (height * height);
        System.out.printf("BMI number: %.2f\n", BMI);
        System.out.println("BMI status: " + bodyStatus(BMI));
    }

    public static String bodyStatus(double BMI) {
        if (BMI < 19) {
            return "Under-standard";
        } else if (BMI < 25) {
            return "Standard";
        } else if (BMI < 30) {
            return "Overweight";
        } else if (BMI < 40) {
            return "Fat - should lose weight";
        } else {
            return "Very fat - should lose weight immediately";
        }
    }
}
