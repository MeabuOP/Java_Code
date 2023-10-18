/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0068;

import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class Manager {

    public static Student createStudent() {
        System.out.println("====== Collection Sort Program ======");
        String name = Validator.inputName();
        String classes = Validator.inputString("Classes:");
        double mark = Validator.inputMark("Mark");
        return new Student(name, classes, mark);
    }

    public static void displayArray(ArrayList<Student> studentList) {
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println("------ Student" + i + " Info ------");
            System.out.println("Name: " + studentList.get(i).getName());
            System.out.println("Classes: " + studentList.get(i).getClassName());
            System.out.printf("Mark: %.2f\n", studentList.get(i).getMark());
        }
    }

    public static void addStudent(ArrayList<Student> studentList) {
        boolean flag;
        do {
            studentList.add(createStudent());
            flag = Validator.inputYesOrNo();
        } while (flag);
    }
}
