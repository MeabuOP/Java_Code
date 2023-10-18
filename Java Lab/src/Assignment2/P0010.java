package Assignment2;

import java.util.Random;
import java.util.Scanner;

public class P0010 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int n, k;
        System.out.println("Enter number of array:");
        n = sc.nextInt();

        System.out.println("Enter search value:");
        k = sc.nextInt();

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = rand.nextInt(100);
        }

        System.out.println("The array: " + displayArray(array));
        int result = linearSearch(array, k);
        if (result == -1) {
            System.out.println("Can not found " + k);
        } else {
            System.out.println("Found " + k + " at index: " + result);
        }
        
    }

    public static String displayArray(int[] array) {
        int n = array.length;
        if (n == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();

        sb.append('[');
        for (int i = 0; i < n - 1; i++) {
            sb.append(array[i]).append(',');
        }
        sb.append(array[n - 1]).append(']');
        return sb.toString();
    }

    public static int linearSearch(int[] array, int k) {
        for (int i=0;i<array.length;i++){
            if (array[i] == k) return i;
        }
        return -1;
    }
}
