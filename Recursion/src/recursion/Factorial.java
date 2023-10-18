/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package recursion;

/**
 *
 * @author ASUS
 */
public class Factorial {

    public static void main(String[] args) {
        System.out.println(factorial(5));
    }
    
    
    public static int factorial(int n){
        if (n<=1) return 1;
        return n*factorial(n-1);
    }
}
