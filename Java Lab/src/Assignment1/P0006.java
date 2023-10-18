package Assignment1;

import java.util.Random;
import java.util.Scanner;

public class P0006 {

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

        bubbleSort(array);
        System.out.println("Sorted array: " + displayArray(array));

        int result = binarySearch(array, k, 0, n - 1);
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

    public static void bubbleSort(int[] array) {
        int n = array.length;
        boolean swap = false;
        for (int i = 0; i < n - 1; i++) {
            for (int y = 0; y < n - 1; y++) {
                if (array[y] > array[y + 1]) {
                    int temp = array[y];
                    array[y] = array[y + 1];
                    array[y + 1] = temp;
                    swap = true;
                }
            }
            if (swap == false) {
                break;
            }
            swap = false;
        }
    }

    public static int binarySearch(int[] array, int k, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (array[mid] == k) {
            return mid;
        } else if (array[mid] > k) {
            return binarySearch(array, k, left, mid - 1);
        } else {
            return binarySearch(array, k, mid + 1, right);
        }
    }
}
