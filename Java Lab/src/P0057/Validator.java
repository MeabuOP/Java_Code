/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0057;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Validator {
    private static Scanner sc = new Scanner(System.in);
    public static int inputInt(String enterMessage){
        int integerValue = 0;
        while (true){
            try{
                String value = inputString(enterMessage);
                integerValue = Integer.parseInt(value);
            }
            catch (NumberFormatException e){
                System.out.println("Not a valid integer!");
                continue;
            }
            return integerValue;
        }
    }
    
    public static String inputString(String enterMessage){
        while (true){
            System.out.print(enterMessage);
            String value = sc.nextLine();
            if (value.isEmpty()){
                System.out.println("Please enter something!");
            }
            else{
                return value;
            }
        }
    }
    
    public static int inputPositiveInt(String enterMessage){
        while (true){
            int salary = inputInt(enterMessage);
            if (salary <= 0){
                System.out.println("Must be >= 0");
            }
            else {
                return salary;
            }
        }
    }
    
    public static String inputUserName(){
        while (true){
            String userName = inputString("Enter username: ");
            if (userName.length() < 5 || userName.contains("\\s+")){
                System.out.println("You must enter least at 5 character, and no space!");
            }
            else return userName;
        }
    }
    
    public static String inputPassWord(){
        while (true){
            String passWord = inputString("Enter password: ");
            if (passWord.length() < 6 || passWord.contains("\\s+")){
                System.out.println("You must enter least at 6 character, and no space!");
            }
            else return passWord;
        }
    }

    public static Account existedUserName(ArrayList<Account> accountList,String userName){
        for (Account account: accountList){
            if (account.getUserName().equals(userName)){
                return account;
            }
        }
        return null;
    }
}
