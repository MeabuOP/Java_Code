/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0065;

import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<>();
        System.out.println("====== Management Student Program ======");
        Manager.addStudent(studentList);
        Manager.displayArray(studentList);
        Manager.classification(studentList);
    }
}
