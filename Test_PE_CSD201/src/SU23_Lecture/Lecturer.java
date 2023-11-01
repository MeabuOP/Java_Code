/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SU23_Lecture;

/**
 *
 * @author ASUS
 */
public class Lecturer implements Comparable<Lecturer>{
    protected int lecturer_code;
    protected int teaching_hours;

    public Lecturer() {
    }

    public Lecturer(int lecturer_code, int teaching_hours) {
        this.lecturer_code = lecturer_code;
        this.teaching_hours = teaching_hours;
    }

    @Override
    public int compareTo(Lecturer o) {
        return teaching_hours - o.teaching_hours;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.lecturer_code;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Lecturer other = (Lecturer) obj;
        return this.lecturer_code == other.lecturer_code;
    }

    @Override
    public String toString() {
        return "<" + lecturer_code + "," + teaching_hours + "> ";
    }
    
}
