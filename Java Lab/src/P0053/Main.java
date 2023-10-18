/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0053;

/**
 *
 * @author ASUS
 */
public class Main {



    public static void main(String[] args) {
        int array[] = null;
        while (true){
            System.out.println("========= Bubble Sort program =========");
            System.out.println("1. Input Element");
            System.out.println("2. Sort Ascending");
            System.out.println("3. Sort Descending");
            System.out.println("4. Exit");
            int choice = Validator.inputInteger("Enter choice: ");
            switch (choice){
                case 1 -> {
                    array = inputArray();
                }
                case 2 -> {
                    ascendingBubbleSort(array);
                }
                case 3 -> {
                    descendingBubbleSort(array);
                }
                case 4 -> {
                    System.out.println("Thanks for using!");
                    System.exit(0);
                }
            }
        }
    }


    public static int[] inputArray() {
        int n = Validator.inputArrayLength("Enter array length: ");
        int[] newArray = new int[n];
        for (int i = 0; i < n; i++) {
            newArray[i] = Validator.inputInteger("Enter array[" + i + "]: ");
        }
        return newArray;
    }

    public static void ascendingBubbleSort(int[] array) {
        if (array == null) {
            System.out.println("Empty array!");
            return;
        }
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swap = false;
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
        }
        System.out.println("----- Ascending -----");
        for (int i = 0; i < n; i++) {
            System.out.print("[" + array[i] + "]");
            if (i < n - 1) {
                System.out.print("->");
            }
        }
        System.out.println();
    }

    public static void descendingBubbleSort(int[] array) {
        if (array == null) {
            System.out.println("Empty array!");
            return;
        }
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swap = false;
            for (int y = 0; y < n - 1; y++) {
                if (array[y] < array[y + 1]) {
                    int temp = array[y];
                    array[y] = array[y + 1];
                    array[y + 1] = temp;
                    swap = true;
                }
            }
            if (swap == false) {
                break;
            }
        }
        System.out.println("----- Descending -----");
        for (int i = 0; i < n; i++) {
            System.out.print("[" + array[i] + "]");
            if (i < n - 1) {
                System.out.print("<-");
            }
        }
        System.out.println();        
    }
}
