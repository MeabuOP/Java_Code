/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0067;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {            
            System.out.println("===== Analysis String program ====");
            System.out.print("Input String: ");
            String line = sc.nextLine();
            Manager.stringAnalyse(line);
        }
    }
}
