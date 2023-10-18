/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0056;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

/**
 *
 * @author ASUS
 */
public class Manager {
    public static void addWorker(ArrayList<Worker> workerList){
        if (workerList == null){
            System.out.println("Null list!");
            return;
        }        
        System.out.println("--------- Add Worker ----------");
        String code = Validator.inputCode();
        if (Validator.checkCodeExisted(workerList, code) != null){
            System.out.println("Code existed!");
            return;
        }
        String name = Validator.inputString("Enter name: ");
        int age = Validator.inputAge();
        int salary = Validator.inputPositiveInt("Enter salary: ");
        String workLocation = Validator.inputString("Enter work location: ");
        Worker worker = new Worker(code,name,age,salary,workLocation);
        workerList.add(worker);
        System.out.println("Add successfully");
    }
    
    public static void adjustSalary(ArrayList<Worker> workerList,ArrayList<History> historyList, boolean salaryStatus) {
        if (workerList.isEmpty() || workerList == null){
            System.out.println("List empty!");
            return;
        }
        System.out.println("------- Up/Down Salary --------");
        String code = Validator.inputCode();
        Worker worker = Validator.checkCodeExisted(workerList, code);
        if (worker == null){
            System.out.println("No worker found!");
            return;
        }
        int adjustment = Validator.inputPositiveInt("Enter salary: ");
        //True : UP , False : DOWN
        if (salaryStatus){
            worker.setSalary(worker.getSalary() + adjustment);
            historyList.add(new History("UP",getCurrentDate(),worker.getCode(),worker.getName(),worker.getAge(),worker.getSalary(),worker.getWorkLocation()));
        }
        else {
            worker.setSalary(worker.getSalary() - adjustment);
            historyList.add(new History("DOWN",getCurrentDate(),worker.getCode(),worker.getName(),worker.getAge(),worker.getSalary(),worker.getWorkLocation()));
        }
    }
    
    //get current date 
    public static String getCurrentDate() {
        String date = LocalDate.now().toString();
        return date;
    }    
    
    public static void displayHistory(ArrayList<History> historyList){
        if (historyList.isEmpty() || historyList == null){
            System.out.println("Empty List!");
            return;
        }
        System.out.println("--------------------Display Information Salary-----------------------");
        System.out.printf("%-5s%-15s%-5s%-10s%-10s%-20s\n", "Code", "Name", "Age","Salary", "Status", "Date"); 
        for (History h:historyList){
            h.display();
        }
    }
}
