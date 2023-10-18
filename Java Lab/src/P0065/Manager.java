/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0065;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author ASUS
 */
public class Manager {
    public static Student createStudent() {
        String name = Validator.inputName();
        String classes = Validator.inputString("Classes:");
        double math = Validator.inputMark("Maths");
        double chemistry = Validator.inputMark("Chemistry");
        double physic = Validator.inputMark("Physics");
        return new Student(name, classes, math, physic, chemistry);
    }
    
    public static void addStudent(ArrayList<Student> studentList){
        boolean flag;
        do{
            studentList.add(createStudent());
            flag = Validator.inputYesOrNo();
        } while (flag);
    }
    
    public static void displayArray(ArrayList<Student> studentList){
        for (int i = 0;i<studentList.size();i++){
            System.out.println("------ Student" + i + " Info ------");
            System.out.println("Name: " + studentList.get(i).getName());
            System.out.println("Classes: " + studentList.get(i).getClassName());
            System.out.printf("AVG: %.2f\n", studentList.get(i).getAverage());
            System.out.println("Type: " + studentList.get(i).getType());
        }
    }
    
    public static void classification(ArrayList<Student> studentList){
        int total = studentList.size();
        HashMap<String,Integer> classifiedList = new HashMap<>();
        classifiedList.put("A", 0);
        classifiedList.put("B", 0);
        classifiedList.put("C", 0);
        classifiedList.put("D", 0);
        for (Student s:studentList){
            int count = classifiedList.get(s.getType());
            classifiedList.put(s.getType(), ++count);
        } 
        System.out.println("--------Classification Info ----");
        System.out.printf("A: %.2f%%\n", (double)(classifiedList.get("A"))*100/total);
        System.out.printf("B: %.2f%%\n", (double)(classifiedList.get("B"))*100/total);
        System.out.printf("C: %.2f%%\n", (double)(classifiedList.get("C"))*100/total);
        System.out.printf("D: %.2f%%\n", (double)(classifiedList.get("D"))*100/total);
    }
}
