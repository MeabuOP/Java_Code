/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package SP23;

/**
 *
 * @author ASUS
 */
public class Worker implements Comparable<Worker>{
    protected int key;
    protected String name;
    protected int age;

    public Worker(int key, String name, int age) {
        this.key = key;
        this.name = name;
        this.age = age;
    }

    public Worker() {
    }

    @Override
    public int compareTo(Worker o) {
        return this.key - o.key;
    }
    
}
