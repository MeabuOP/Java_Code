/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0077;

/**
 *
 * @author ASUS
 */
public class Main {

    public static void main(String[] args) {
        while (true) {            
            System.out.println("============ Word Program =========");
            System.out.println("1. Count Word In File\n" + "2. Find File By Word\n" + "3. Exit");
            int choice = Validator.inputInteger("Enter choice:");
            switch (choice) {
                case 1 -> {
                    System.out.println("-------- Count Word --------");
                    String path = Validator.inputString("Enter path:");
                    String word = Validator.inputString("Enter word:");
                    System.out.println("Bout: " + Manager.countWordInFile(path, word));
                }
                case 2 -> {
                    System.out.println("-------- Find File By Word --------");
                    String path = Validator.inputString("Enter path:");
                    String word = Validator.inputString("Enter word:");                    
                    Manager.getFileNameContainsWordInDirectory(path, word);
                }
                case 3 ->{
                    System.out.println("Thanks for using!");
                    System.exit(0);
                }
            }
        }
    }
}
