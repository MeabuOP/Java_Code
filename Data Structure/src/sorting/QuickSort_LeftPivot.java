/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sorting;

/**
 *
 * @author ASUS
 */
public class QuickSort_LeftPivot {
    
    public static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = partition(array, left, right);
            quickSort(array, left, mid - 1);
            quickSort(array, mid + 1, right);
        }
    }    
    
    public static int partition(int[] array, int left, int right) {
        int pivot = array[left];
        int temp;
        int i = left;
        int j = right;
        while (i <= j) {
            while (array[i] <= pivot) {
                i++;
                if (i == right + 1) {
                    break;
                }
            }
            while (array[j] > pivot) {
                j--;
                if (j == left - 1) {
                    break;
                }
            }
            if (i < j) {
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        temp = array[left];
        array[left] = array[j];
        array[j] = temp;
        return j;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }    
}
