/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0073;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Manager {
    public static void addExpense(ArrayList<Expense> expenseList){
        System.out.println("-------- Add an expense--------");
        Date date = Validator.inputDate("Enter Date:");
        double amount = Validator.inputAmount("Enter Amount:");
        String content = Validator.inputContent("Enter Content:");
        expenseList.add(new Expense(date,amount,content));
        System.out.println("Add successfully!");
    }
    
    public static void displayExpense(ArrayList<Expense> expenseList){
        if (expenseList.isEmpty()) {
            System.out.println("Expense list is empty!");
            return;
        }        
        //"%-5s%-20s%-10.2f%-15s"
        double sum = 0;
        System.out.println("---------Display all expenses------------");
        System.out.println("ID   Date                Amount    Content        ");
        for (Expense e: expenseList){
            e.display();
            sum = sum + e.getMoney();
        }
        System.out.println("        Total :     " + sum);
    }
    
    public static void deleteExpense(ArrayList<Expense> expenseList) {
        if (expenseList.isEmpty()) {
            System.out.println("Expense list is empty!");
            return;
        }
        System.out.println("---------Del Task------");
        int ID = Validator.inputInteger("ID:");
        for (Expense e : expenseList) {
            if (ID == e.getID()) {
                expenseList.remove(e);
                System.out.println("Delete successfully!");
                return;
            }
        }
        System.out.println("ID not existed!");
    }    
}
