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
public class ManageContact {
    public static void inputContact(ArrayList<Contact> contactList){
        System.out.println("-------- Add a Contact --------");
        String firstName = Validator.inputString("Enter First Name: ");
        String lastName = Validator.inputString("Enter Last Name: ");
        String group = Validator.inputString("Enter Group: ");
        String address = Validator.inputString("Enter Address: ");
        String phone = Validator.inputPhoneNumber("Enter Phone: ");
        Contact c = new Contact(group,address,phone,lastName,firstName);
        contactList.add(c);
        System.out.println("Successful");
        c.display();
        
        
    }
    
    public static void displayContactList(ArrayList<Contact> contactList){
        System.out.println("ID             Name           First Name     Last Name      Group          Address          Phone          ");
        for (Contact c: contactList){
            c.display();
        }
    }
    
    public static void deleteContact(ArrayList<Contact> contactList){
        int ID = Validator.inputInteger("Enter ID: ");
        for (Contact c: contactList){
            if (c.getID() == ID) {
                System.out.println("ID             Name           First Name     Last Name      Group          Address          Phone          ");
                c.display();
                contactList.remove(c);
                System.out.println("Successful");
                return;
            }
        }
        System.out.println("No Contact found!");
    }
}
