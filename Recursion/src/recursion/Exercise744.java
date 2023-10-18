/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursion;

/**
 *
 * @author ASUS
 */
public class Exercise744 {
    public static double sum(int n){
        double result = 0;
        for (double i = 1;i<=n;i++){
            result = result + i;
        }
        if (n == 1) return 1;
        return sum(n-1) + 1/result;
    }
    
    public static void main(String[] args) {
        System.out.println(sum(5));
    }
}
