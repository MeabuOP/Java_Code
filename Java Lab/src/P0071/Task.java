/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0071;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Task {
    private static int generalID = 0;
    private int ID;
    private String name;
    private int TaskTypeID;
    private Date date;
    private double planFrom;
    private double planTo; 
    private String assignee;
    private String reviewer;

    public Task() {
        this.ID = generalID + 1;
    }
    
    

    public Task(int TaskTypeID, String name,Date date, double planFrom, double planTo, String assignee, String reviewer) {
        this.ID = generalID + 1;
        this.name = name;
        this.TaskTypeID = TaskTypeID;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }
    
    

    public static int getGeneralID() {
        return generalID;
    }

    public static void setGeneralID(int generalID) {
        Task.generalID = generalID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getTaskTypeID() {
        return TaskTypeID;
    }

    public void setTaskTypeID(int TaskTypeID) {
        this.TaskTypeID = TaskTypeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPlanFrom() {
        return planFrom;
    }

    public void setPlanFrom(double planFrom) {
        this.planFrom = planFrom;
    }

    public double getPlanTo() {
        return planTo;
    }

    public void setPlanTo(double planTo) {
        this.planTo = planTo;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }
    
    public double getTime(){
        return planTo - planFrom;
    }
    
    public String getTaskTypeString(){
        if (TaskTypeID == 1) return "Code";
        if (TaskTypeID == 2) return "Analyse";
        if (TaskTypeID == 3) return "Clean";
        if (TaskTypeID == 4) return "Sleep";
        return null;
    }
    
    public String getDateString(){
        DateFormat pattern = new SimpleDateFormat("dd-MM-yyyy");
        String dateString = pattern.format(date);
        return dateString;
    }
    public void display(){
        System.out.printf("%-5s%-15s%-15s%-15s%-10s%-15s%-15s\n",ID,name,getTaskTypeString(),getDateString(),getTime(),assignee,reviewer);
    }
}
