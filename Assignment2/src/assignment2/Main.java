/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment2;

import java.util.HashMap;



/**
 *
 * @author ASUS
 */
public class Main {

    public static void main(String[] args) {

        ManagerBook b = new ManagerBook();
        b.readFile();
        b.mergeSort_run();
        //Binary search
        Book book1 = new Book("Break Point (Point Crime S.)");
        long binarySearchStart = System.nanoTime();
        System.out.println(b.binarySearch(book1, 0, b.bookArrayList.size()-1)); 
        long binarySearchEnd = System.nanoTime();
        System.out.println("Binary search took " + (binarySearchEnd - binarySearchStart) + " nanoseconds");
        
        //Add HashMap
        HashMap<String,Book> bookHashMap = new HashMap<>();
        for(Book book: b.bookArrayList){
            bookHashMap.put(book.getBookTitle(), book);
        }        
        
        //Find with HashMap
        long mapStart = System.nanoTime();
        System.out.println(bookHashMap.get("Break Point (Point Crime S.)"));
        long mapEnd = System.nanoTime();
        System.out.println("Hash Map search took " + (mapEnd - mapStart) + " nanoseconds");
    }
    
    
}
