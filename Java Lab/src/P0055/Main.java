/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0055;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        DoctorHash doctorHash = new DoctorHash();
        doctorHash.getDoctorHashMap().put("DOC 1", new Doctor("DOC 1", "Nghia", "Orthopedics", 3));
        doctorHash.getDoctorHashMap().put("DOC 2", new Doctor("DOC 2", "Phuong", "Obstetrics", 2));
        doctorHash.getDoctorHashMap().put("DOC 3", new Doctor("DOC 3", "Lien", "Orthodontic", 1));
        Menu menu = new Menu("========= Doctor Management ==========", new String[]{"Add Doctor","Update Doctor","Delete Doctor","Search Doctor","Exit"}) {
            @Override
            public void execute(int choice) {
                switch (choice){
                    case 1 -> {
                        doctorHash.addDoctor();
                    }
                    case 2 -> {
                        doctorHash.updateDoctor();
                    }
                    case 3 -> {
                        doctorHash.deleteDoctor();
                    }
                    case 4 -> {
                        doctorHash.searchDoctor();
                    }
                    case 5 -> {
                        System.out.println("Thanks for using!");
                        System.exit(0);
                    }
                }
            }
        };
        menu.run();
    }
    

}
