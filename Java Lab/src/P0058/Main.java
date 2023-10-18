/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0058;

import java.util.HashMap;

/**
 *
 * @author ASUS
 */
public class Main {
    public static void main(String[] args) {
        HashMap<String,String> dictionary = new HashMap<>();
        Manager.readFile(dictionary);
        Menu menu = new Menu("======== Dictionary program ========", new String[]{"Add word","Delete word","Translate","Exit"}) {
            @Override
            public void execute(int choice) {
                switch (choice){
                    case 1 -> {
                        Manager.addWord(dictionary);
                    }
                    case 2 -> {
                        Manager.deleteWord(dictionary);
                    }
                    case 3 -> {
                        Manager.translate(dictionary);
                    }
                    case 4 -> {
                        Manager.writeFile(dictionary);
                        System.out.println("Thanks for using!");
                        System.exit(0);
                    }
                }
            }
        };
        menu.run();
    }
}
