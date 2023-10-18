/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursion;

/**
 *
 * @author ASUS
 */
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(Fibonacci(10));
        String s = "\"Book title\"";
        System.out.println(s);
        System.out.println(s.substring(0, s.length()).substring(s.length()));
    }
    
    public static int Fibonacci(int n){
        if (n==0 || n==1) return n;
        return Fibonacci(n-1) + Fibonacci(n-2);
    }
}
