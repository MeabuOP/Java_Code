/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0054;

import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Contact> contactList = new ArrayList<>();
        contactList.add(new Contact("Star", "Spain", "123-456-7890", "Iker", "Casillas"));
        contactList.add(new Contact("Star", "England", "123.456.7890", "John", "Terry"));
        contactList.add(new Contact("Star", "Spain", "123 456 7890", "Raul", "Gonzalez"));        
        Menu menu = new Menu("========= Contact program =========", new String[]{"Add a Contact","Display all Contact","Delete a Contact","Exit"}) {
            @Override
            public void execute(int choice) {
                switch (choice){
                    case 1 -> {
                        ManageContact.inputContact(contactList);
                    }
                    case 2 -> {
                        ManageContact.displayContactList(contactList);
                    }
                    case 3 -> {
                        ManageContact.deleteContact(contactList);
                    }
                    case 4 -> {
                        System.out.println("Thanks for using!");
                        System.exit(0);
                    }
                }
            }
        };  
        menu.run();
    }
}
