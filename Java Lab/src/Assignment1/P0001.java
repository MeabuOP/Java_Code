
package Assignment1;

import java.util.Random;
import java.util.Scanner;

public class P0001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int n;
        do{
            System.out.println("Enter number of array:");
            n = sc.nextInt();
        }while(n<=0);
        int[] array = new int[n];
        for (int i = 0;i<n;i++){
            array[i] = rand.nextInt(100);
        }
        System.out.println("Unsorted array: " + displayArray(array));
        bubbleSort(array);
        System.out.println("Sorted array: " + displayArray(array));
    }
    
    public static String displayArray(int[] array){
        int n = array.length;
        if (n == 0) return "[]";
        StringBuilder sb = new StringBuilder();
        
        sb.append('[');
        for (int i=0;i<n-1;i++){
            sb.append(array[i]).append(',');
        }
        sb.append(array[n-1]).append(']');
        return sb.toString();
    }
    
    public static void bubbleSort(int[] array){
        int n = array.length;
        for (int i = 0;i < n-1;i++){
            boolean swap = false;
            for (int y = 0;y <n-1;y++){
                if (array[y] > array[y+1]){
                    int temp = array[y];
                    array[y] = array[y+1];
                    array[y+1] = temp;
                    swap = true;
                }
            }
            if (swap == false) break;
        }
    }
}
