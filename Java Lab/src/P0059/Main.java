/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0059;

/**
 *
 * @author ASUS
 */
public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu("========== File Processing =========", new String[]{"Find person info","Copy Text to a new file","Exit"}) {
            @Override
            public void execute(int choice) {
                switch (choice){
                    case 1 -> {
                        Manager.findInfo();
                    }
                    case 2 -> {
                        Manager.copyWordOneTimes();
                    }
                    case 3 -> {
                        System.out.println("Thanks for using!");
                        System.exit(0);
                    }
                }
            }
        };
        menu.run();
    }
}
