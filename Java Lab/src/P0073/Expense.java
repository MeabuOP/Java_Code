/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0073;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Expense {

    private static int generalID = 0;
    private int ID;
    private Date date;
    private double money;
    private String content;

    public Expense(Date date, double money, String content) {
        this.ID = generalID++;
        this.date = date;
        this.money = money;
        this.content = content;
    }

    public Expense() {
        this.ID = generalID++;
    }

    public static int getGeneralID() {
        return generalID;
    }

    public static void setGeneralID(int generalID) {
        Expense.generalID = generalID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDateString(){
        DateFormat pattern = new SimpleDateFormat("dd-MMM-yyyy");
        return pattern.format(date);
    }
    public void display(){
        System.out.printf("%-5s%-20s%-10.2f%-15s\n",ID,getDateString(),money,content);
    }
}
