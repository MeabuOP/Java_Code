package Assignment1;

import java.util.Random;
import java.util.Scanner;

public class P0004 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int n;
        do {
            System.out.println("Enter number of array:");
            n = sc.nextInt();
        } while (n <= 0);
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = rand.nextInt(100);
        }
        System.out.println("Unsorted array: " + displayArray(array));
        quickSort(array, 0, array.length - 1);
        System.out.println("Sorted array: " + displayArray(array));
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
