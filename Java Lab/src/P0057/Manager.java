/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0057;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class Manager {
    private ArrayList<Account> accountList = new ArrayList<>();
    
    public void writeFile(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Account.dat"));
            for (Account account:accountList){
                writer.write( account.getUserName() + "-" + account.getPassWord() + "\n");
            }
            writer.close();
        } catch (IOException ex) {
            System.out.println("Input Output Error!");
        }
    }
    
    public void readFile(){
        accountList.clear();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Account.dat"));
            String line;    
            while ((line = reader.readLine()) != null){
                String[] array = line.split("-");
                if (array.length<2) continue;
                accountList.add(new Account(array[0],array[1]));
            }
            reader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("No available account list!");
        } catch (IOException ioe){
            System.out.println("Input Output Error!");
        }
    } 
    
    public String addAccount(String username,String password){
        if (Validator.existedUserName(accountList, username) != null){
            return "Existed username!";
        }
        accountList.add(new Account(username,password));
        return "Create successfully!";
    }
    
    public String findAccount(Account ac){
        if (accountList.isEmpty()){
           return "Empty database!";
        }
        if (accountList.contains(ac)){
           return "Login successful!";
        }
        return "Login failed!";
    }
}
