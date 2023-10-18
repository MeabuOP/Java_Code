/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sorting;

/**
 *
 * @author ASUS
 */
public class RadixSort {
    // Function to perform Radix Sort on an array
    static void radixSort(int[] array) {
        int max = getMax(array);

        // Perform counting sort for every digit
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(array, exp);
        }
    }

    // Function to find the maximum value in an array
    static int getMax(int[] array) {
        int max = array[0];
        for (int value : array) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    // Function to perform counting sort on an array based on the digit represented by exp
    static void countingSort(int[] array, int exp) {
        int n = array.length;
        int[] output = new int[n];
        int[] count = new int[10]; // 10 possible digits (0 to 9)

        // Count the occurrences of each digit at the current place value
        for (int i = 0; i < n; i++) {
            count[(array[i] / exp) % 10]++;
        }

        // Update count[i] to store the position of the digit in the output
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array by placing elements in their sorted order
        for (int i = n - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }

        // Copy the sorted elements back to the original array
        System.arraycopy(output, 0, array, 0, n);
    }    
}
