/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sorting;

/**
 *
 * @author ASUS
 */
public class MergeSort {
    // Function to perform Merge Sort on an array
    static void mergeSort(int[] array) {
        int n = array.length;
        if (n > 1) {
            int mid = n / 2;
            
            // Split the array into two halves
            int[] leftArray = new int[mid];
            int[] rightArray = new int[n - mid];

            System.arraycopy(array, 0, leftArray, 0, mid);
            System.arraycopy(array, mid, rightArray, 0, n - mid);

            // Recursive calls to sort the two halves
            mergeSort(leftArray);
            mergeSort(rightArray);

            // Merge the sorted halves
            merge(array, leftArray, rightArray);
        }
    }

    // Function to merge two sorted arrays into a single sorted array
    static void merge(int[] array, int[] leftArray, int[] rightArray) {
        int i = 0, j = 0, k = 0;

        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        // Copy remaining elements of leftArray, if any
        while (i < leftArray.length) {
            array[k++] = leftArray[i++];
        }

        // Copy remaining elements of rightArray, if any
        while (j < rightArray.length) {
            array[k++] = rightArray[j++];
        }
    }    
}
