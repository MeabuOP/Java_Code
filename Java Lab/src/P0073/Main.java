/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0073;

import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Expense> expenseList = new ArrayList<>();
        while (true) {
            System.out.println("=======Handy Expense program======");
            System.out.println("1. Add an expense");
            System.out.println("2. Display all expenses");
            System.out.println("3. Delete an expense");
            System.out.println("4. Quit");
            int choice = Validator.inputInteger("Your choice: ");
            switch (choice) {
                case 1 -> {
                    Manager.addExpense(expenseList);
                }
                case 2 -> {
                    Manager.displayExpense(expenseList);
                }
                case 3 -> {
                    Manager.deleteExpense(expenseList);
                }
                case 4 -> {
                    System.out.println("Thanks for using");
                    System.exit(0);
                }
            }
        }
    }
}
