/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0059;

/**
 *
 * @author ASUS
 */
public class Person implements Comparable<Person> {

    private String name;
    private String address;
    private double salary;

    public Person() {
    }

    public Person(String name, String address, double salary) {
        this.name = name;
        this.address = address;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void display() {
        System.out.printf("%-20s%-20s%-20.1f\n", name,address, salary);
    }

    @Override
    public int compareTo(Person o) {
        return Double.valueOf(salary).compareTo(Double.valueOf(o.getSalary()));
    }
}
