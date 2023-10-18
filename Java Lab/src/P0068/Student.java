/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0068;

/**
 *
 * @author ASUS
 */
public class Student implements Comparable<Student>{
    private String name;
    private String className;
    private double mark;    

    public Student() {
    }

    public Student(String name, String className, double mark) {
        this.name = name;
        this.className = className;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.getName());
    }
    
}
