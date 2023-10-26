/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0059;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author ASUS
 */
public class Manager {
    public static void findInfo(){

        System.out.println("--------- Person info ---------");
        String path = Validator.inputString("Enter Path: ");
        double money = Validator.inputNonNegativeDouble("Enter Money: ");
        
        //Read file + Sort
        ArrayList<Person> personList = readFile(path);
        
        
        //Path not found
        if (personList == null) return ;
        
        
        //File found but no data
        if (personList.isEmpty()){
            System.out.println("Empty data!");
            return ;
        }
        
        
        System.out.println("------------- Result ----------");
        System.out.printf("%-20s%-20s%-20s\n", "Name", "Address", "Money");
        //Copy to a new result array
        ArrayList<Person> resultList = new ArrayList<>();
        for (Person p:personList){
            if (p.getSalary() >= money) {
                resultList.add(p);
                p.display();
            }
        }
        
        //Đã được sort nên min nằm đầu, max nằm cuối
        System.out.println();
        System.out.println("Max: " + resultList.get(resultList.size() - 1).getName());
        System.out.println("Min: " + resultList.get(0).getName());
        
    }
    
    
    
    public static ArrayList<Person> readFile(String path){
        
        try { 
            ArrayList<Person> personList = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;    
            while ((line = reader.readLine()) != null){
                String[] array = line.split(";");
                //Thiếu thành phần || dư thành phần || tên bị trống || address bị trống
                if (array.length <= 1 || array.length > 3) continue;
                if (array[0].isBlank() || array[1].isBlank()) continue;
                String name = array[0];
                String address = array[1];
                //Check tiền
                double money = 0;
                if (array.length == 3){
                   try{
                       money = Double.parseDouble(array[2]);
                       if (money < 0) money = 0;
                   } catch (NumberFormatException e){
                       money = 0;
                   }
                }
                personList.add(new Person(name,address,money));
            }
            reader.close();
            Collections.sort(personList);
            return personList;
        } catch (FileNotFoundException ex) {
            System.out.println("File " + path + " Not Found!");
            return null;
        } catch (IOException ioe){
            System.out.println("Read file " + path + " Error!");
            return null;
        }       
    }
    
    public static void writeFile(String path,ArrayList<Person> personList){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            for (Person p:personList){
                writer.write(p.getName()+";"+p.getAddress()+";"+p.getSalary()+"\n");
            }
            writer.close();
            System.out.println("Write successfully!");
        } catch (IOException ex) {
            System.out.println("Can not write file");
            return;
        }
    }
    
    public static void copyWordOneTimes(){
        String source = Validator.inputString("Enter Source: ");
        ArrayList<Person> personList = readFile(source);
        
        //File not found or empty data
        if (personList == null) return;
        if (personList.isEmpty()){
            System.out.println("Empty data!");
            return;
        }
        double money = Validator.inputNonNegativeDouble("Enter Money: ");
        ArrayList<Person> resultList = new ArrayList<>();
        for (Person p:personList){
            if (p.getSalary() >= money) {
                resultList.add(p);
            }
        }
        String newFile = Validator.inputString("Enter new file name: ");
        writeFile(newFile, resultList);
    }
}
