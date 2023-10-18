/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0075;

/**
 *
 * @author ASUS
 */
public class Main {
    public static void main(String[] args) {
        while (true) {            
            System.out.println("====== File Processing ======");
            System.out.println("1. Check path");  
            System.out.println("2. Get file name with type java");
            System.out.println("3. Get file with size greater than input");
            System.out.println("4. Write more content to file");
            System.out.println("5. Read file and count characters");
            System.out.println("6. Exit");
            int choice = Validator.inputInteger("Enter choice: ");
            switch (choice){
                case 1 -> {
                    Manager.checkInputPath();
                }
                case 2 ->{
                    Manager.getAllFileNameJavaInDirectory();
                }
                case 3 ->{
                    Manager.getFileWithSizeGreaterThanInput();
                }
                case 4 ->{
                    Manager.appendContentToFile();
                }
                case 5 -> {
                    Manager.countCharacter();   
                }
                case 6 ->{
                    System.out.println("Thanks for using!");
                    System.exit(0);
                }
            }
        }
    }
}
