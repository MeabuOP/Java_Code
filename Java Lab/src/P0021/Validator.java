/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0021;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Validator {

    static Scanner sc = new Scanner(System.in);

    public static String inputString(String enterMessage) {
        System.out.print(enterMessage);
        return sc.nextLine();
    }

    public static int inputInteger(String enterMessage, int min, int max) {
        while (true) {
            try {
                int value = Integer.parseInt(inputString(enterMessage));
                if (value < min || value > max) {
                    System.out.println("Must >= " + min + " and <= " + max + "!");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
            }
        }
    }

    public static boolean existedID(ArrayList<Student> studentList, String ID) {
        for (Student s : studentList) {
            if (s.getID().equalsIgnoreCase(ID)) {
                return true;
            }
        }
        return false;
    }

    public static boolean validCourse(String course) {
        return course.equalsIgnoreCase("Java")
                || course.equalsIgnoreCase(".Net")
                || course.equalsIgnoreCase("C/C++");
    }
}
