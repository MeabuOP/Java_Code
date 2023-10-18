/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0058;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author ASUS
 */
public class Manager {
    public static void addWord(HashMap<String,String> dictionary){
        String english = Validator.inputString("Enter English: ");
        if (Validator.existedWord(dictionary, english)) {
            System.out.println("Existed word!");
            return;
        }
        String vietnamese = Validator.inputString("Enter Vietnamese: ");
        dictionary.put(english, vietnamese);
        System.out.println("Successful");
    }
    
    public static void deleteWord(HashMap<String,String> dictionary) {
        String english = Validator.inputString("Enter English: ");
        if (!Validator.existedWord(dictionary, english)){
            System.out.println("Word not existed!");
        } else {
            System.out.println("Vietnamese: " + dictionary.get(english));
            if (Validator.inputYesOrNo()){
                dictionary.remove(english);
                System.out.println("Delete successful!");
            }
            else {
                System.out.println("Delete failed!");
            }
        }
    }
    
    
    public static void translate(HashMap<String,String> dictionary) {
        String english = Validator.inputString("Enter English: ");
        String vietnamese = dictionary.get(english);
        if (vietnamese == null){
            System.out.println("No word found!");
        }
        else {
            System.out.println("Vietnamese: " + vietnamese);
        }
    }
    
    public static void writeFile(HashMap<String,String> dictionary){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Dictionary.dat"));
            for (String key:dictionary.keySet()){
                writer.write(key + "-" + dictionary.get(key) + "\n");
            }
            writer.close();
        } catch (IOException ex) {
            System.out.println("Input Output Error!");
        }
    }
    
    public static void readFile(HashMap<String,String> dictionary){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Dictionary.dat"));
            String line;    
            while ((line = reader.readLine()) != null){
                String[] array = line.split("-");
                if (array.length<2) continue;
                dictionary.put(array[0], array[1]);
            }
            reader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("No available dictionary!");
        } catch (IOException ioe){
            System.out.println("Input Output Error!");
        }
    }
}
