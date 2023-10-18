/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0074;

/**
 *
 * @author ASUS
 */
public class Main {
    public static void main(String[] args) {
        while (true){
            System.out.println("=======Calculator Program=======");
            System.out.println("1. Addition Matrix");
            System.out.println("2. Subtraction Matrix");
            System.out.println("3. Multiplication Matrix");
            System.out.println("4. Quit");
            int choice = Validator.inputInteger("Enter choice:");
            switch (choice){
                case 1 -> {
                    Manager.matrix_Addition_Or_Subtraction(true);
                }
                case 2 -> {
                    Manager.matrix_Addition_Or_Subtraction(false);
                }
                case 3 -> {
                    Manager.matrix_Multiplication();
                }
                case 4 -> {
                    System.out.println("Thansk for using!");
                    System.exit(0);
                }
            }
        }
    }
}
