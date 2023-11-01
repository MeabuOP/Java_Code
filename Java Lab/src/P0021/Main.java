/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0021;

/**
 *
 * @author ASUS
 */
public class Main {
    public static void main(String[] args) {
        while (true) {            
            Manager.menu();
            int choice = Validator.inputInteger("Enter choice: ",1,5);
            switch (choice){
                case 1 ->{
                    
                }
                case 2 ->{
                    
                }
                case 3 ->{
                    
                }
                case 4 ->{
                    
                }
                case 5 ->{
                    System.out.println("Thanks for using!");
                    System.exit(0);
                }
            }
        }
    }
}
