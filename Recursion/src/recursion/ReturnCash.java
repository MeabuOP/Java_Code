/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursion;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class ReturnCash {
    public static void returnCash(int n){
        if (n==0) return;
        if (n/25 != 0) {
            System.out.println(n/25 + " quarter");
            returnCash(n%25);
        }
        else if (n/10 != 0) {
            System.out.println(n/10 + " dime");
            returnCash(n%10);
        }
        else if (n/5 != 0) {
            System.out.println(n/5 + " nickel");
            returnCash(n%5);
        }
        else if (n/1 != 0) {
            System.out.println(n/1 + " penny");
            returnCash(n%1);
        }        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Money: ");
        int n = sc.nextInt();
        returnCash(n);
    }
}
