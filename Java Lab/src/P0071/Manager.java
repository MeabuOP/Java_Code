/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0071;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Manager {

    public static void addTask(ArrayList<Task> taskList) {
        System.out.println("------------Add Task---------------");
        String name = Validator.inputName("Requirement Name:");
        int type = Validator.inputTaskType("Task Type:");
        Date date = Validator.inputDate("Date:");
        double planFrom = Validator.inputTime("From:");
        double planTo;
        while (true) {
            planTo = Validator.inputTime("To:");
            if (planTo >= planFrom) {
                break;
            }
            System.out.println("Plan From must be less than Plan To");
        }
        String assignee = Validator.inputName("Assignee:");
        String reviewer = Validator.inputName("Reviewer:");
        taskList.add(new Task(type, name, date, planFrom, planTo, assignee, reviewer));
        System.out.println("Add successfully!");
    }

    public static void deleteTask(ArrayList<Task> taskList) {
        if (taskList.isEmpty()) {
            System.out.println("Task list is empty!");
            return;
        }
        System.out.println("---------Del Task------");
        int ID = Validator.inputInteger("ID:");
        for (Task t : taskList) {
            if (ID == t.getID()) {
                taskList.remove(t);
                System.out.println("Delete successfully!");
                return;
            }
        }
        System.out.println("ID not existed!");
    }

    public static void displayTask(ArrayList<Task> taskList) {
        if (taskList.isEmpty()) {
            System.out.println("Task list is empty!");
            return;
        }
        System.out.println("----------------------------------------- Task ---------------------------------------");
        //"%-5s%-15s%-15s%-15s%-10s%-15s%-15s"
        System.out.println("ID   Name           Task Type      Date           Time      Assignee       Reviewer       ");
        for (Task t : taskList) {
            t.display();
        }
    }
}
