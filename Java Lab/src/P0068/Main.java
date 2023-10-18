/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0068;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author ASUS
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("====== Collection Sort Program ======");
        ArrayList<Student> studentList = new ArrayList<>();
        Manager.addStudent(studentList);
        Collections.sort(studentList);
        Manager.displayArray(studentList);
    }
}
