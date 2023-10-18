/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0076;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class Manager {

    public static void readFile(ArrayList<CSV> csvList) {
        try {
            csvList.clear();
            String path = Validator.inputString("Enter Path: ");
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] array = line.split(",");
                csvList.add(new CSV(Integer.parseInt(array[0]), array[1], array[2], array[3], array[4]));
            }
            reader.close();
            if (csvList.isEmpty()) {
                System.out.println("No data found!");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found!");
        } catch (IOException ioe) {
            System.out.println("Input Output Error!");
        }
    }

    public static void writeFile(ArrayList<CSV> csvList) {
        if (csvList.isEmpty()) {
            System.out.println("List is empty!");
        }
        try {
            String path = Validator.inputString("Enter Path: ");
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            for (CSV csv : csvList) {
                writer.write(csv.toString() + "\n");
            }
            writer.close();
        } catch (IOException ex) {
            System.out.println("Input Output Error!");
        }
    }
    
    public static void formatAddress(ArrayList<CSV> csvList){
        for (CSV csv:csvList){
            String address = csv.getAddress();
            address = address.trim();
            address = address.replaceAll("\\s+", " ");
            csv.setAddress(address);
        }
        System.out.println("Format: Done");
    }
    
    public static void formatName(ArrayList<CSV> csvList){
        for (CSV csv:csvList){
            String name = csv.getName();
            name = name.trim();
            name = name.replaceAll("\\s+", " ");
            name = Character.toUpperCase(name.charAt(0)) + name.substring(1); 
            csv.setAddress(name);
        }
        System.out.println("Format: Done");
    }    
 
}
