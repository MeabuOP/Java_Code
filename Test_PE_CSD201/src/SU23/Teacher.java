/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SU23;

/**
 *
 * @author ASUS
 */
public class Teacher implements Comparable<Teacher>{
    protected int code;
    protected double coeff;

    public Teacher() {
    }

    public Teacher(int code, double coeff) {
        this.code = code;
        this.coeff = coeff;
    }

    @Override
    public int compareTo(Teacher o) {
        return Double.compare(coeff, o.coeff);
    }
}
