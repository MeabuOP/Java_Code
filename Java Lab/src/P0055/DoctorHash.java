/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0055;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author ASUS
 */
public class DoctorHash {

    private HashMap<String, Doctor> doctorHashMap;

    public DoctorHash() {
        doctorHashMap = new HashMap<>();
    }

    public DoctorHash(HashMap<String, Doctor> doctorHashMap) {
        this.doctorHashMap = doctorHashMap;
    }

    public HashMap<String, Doctor> getDoctorHashMap() {
        return doctorHashMap;
    }

    public void setDoctorHashMap(HashMap<String, Doctor> doctorHashMap) {
        this.doctorHashMap = doctorHashMap;
    }

    public void addDoctor() {
        System.out.println("--------- Add Doctor ----------");
        String code = Validator.inputString("Enter ID: ");
        if (Validator.checkCodeExist(doctorHashMap, code) != null) {
            System.out.println("Code existed!");
            return;
        }
        String name = Validator.inputString("Enter name: ");
        String specialization = Validator.inputString("Enter specialization: ");
        int availability = Validator.inputInteger("Enter availability: ");
        Doctor doctor = new Doctor(code, name, specialization, availability);
        doctorHashMap.put(code, doctor);
        System.err.println("Add successful.");
        System.out.printf("%-10s%-15s%-25s%-20s\n", "Code", "Name","Specialization", "Availability");
        doctor.display();
        
    }

    public void updateDoctor() {
        System.out.println("--------- Update Doctor -------");
        String code = Validator.inputString("Enter ID: ");
        Doctor doctor = Validator.checkCodeExist(doctorHashMap, code);
        if (doctor == null) {
            System.err.println("No Doctor found.");
            return;
        }  
        doctor.display();
        String name = Validator.inputString("Enter name: ");
        String specialization = Validator.inputString("Enter specialization: ");
        int availability = Validator.inputInteger("Enter availability: ");        
        doctor.setName(name);
        doctor.setSpecialization(specialization);
        doctor.setAvailability(availability);
        System.out.println("Update successfully.");
        System.out.printf("%-10s%-15s%-25s%-20s\n", "Code", "Name","Specialization", "Availability");
        doctor.display();
    }

    public void deleteDoctor() {
        System.out.println("--------- Delete Doctor -------");
        String code = Validator.inputString("Enter ID: ");
        Doctor doctor = Validator.checkCodeExist(doctorHashMap, code);
        if (doctor == null) {
            System.err.println("No Doctor found.");
            return;
        }
        System.out.printf("%-10s%-15s%-25s%-20s\n", "Code", "Name","Specialization", "Availability");
        doctor.display();
        doctorHashMap.remove(code);
        System.out.println("Delete successfully.");
    }    

    public void searchDoctor() {
        System.out.println("---------- Search Doctor --------");
        ArrayList<Doctor> result = new ArrayList<>();
        String name = Validator.inputString("Enter name: ");
        for (Doctor d:doctorHashMap.values()){
            if (d.getName().contains(name)){
                result.add(d);
            }
        }
        if (result.isEmpty()){
            System.out.println("No Doctor found.");
        }
        else{
            System.out.printf("%-10s%-15s%-25s%-20s\n", "Code", "Name","Specialization", "Availability");            
            for (Doctor d:result){
                d.display();
            }
        }
    }
}
