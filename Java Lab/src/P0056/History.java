/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0056;

/**
 *
 * @author ASUS
 */
public class History extends Worker{
    private String status;
    private String date;

    public History() {
    }

    public History(String status, String date, String code, String name, int age, int salary, String workLocation) {
        super(code, name, age, salary, workLocation);
        this.status = status;
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
 
    public void display(){
        System.out.printf("%-5s%-15s%-5d%-10d%-10s%-20s\n", getCode(),getName(),getAge(),getSalary(),status, date);        
    }
}
