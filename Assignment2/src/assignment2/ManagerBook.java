package assignment2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ManagerBook {

    public static ArrayList<Book> bookArrayList = new ArrayList<>();
//=============================================================================

    public static void readFile() {
        bookArrayList.clear();
        File file = new File("Book.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                if (count == 0) {
                    count++;
                    continue;
                }
                String[] information = line.split(";");
                String ISBN = information[0];
                String bookTitel = information[1];
                if (information.length >= 3) {
                    bookTitel = bookTitel.substring(1, bookTitel.length() - 1);
                }
                String bookAuthor = information[2];
                if (bookAuthor.length() >= 3) {
                    bookAuthor = bookAuthor.substring(1, bookAuthor.length() - 1);
                }
                String yearOfPublication = information[3];
                if (yearOfPublication.length() >= 3) {
                    yearOfPublication = yearOfPublication.substring(1, yearOfPublication.length() - 1);
                }
                String publisher = information[4];
                if (publisher.length() >= 3) {
                    publisher = publisher.substring(1, publisher.length() - 1);
                }
                String imageURLM = information[5];
                if (imageURLM.length() >= 3) {
                    imageURLM = imageURLM.substring(1, imageURLM.length() - 1);
                }
                String imageURLL = information[6];
                if (imageURLL.length() >= 3) {
                    imageURLL = imageURLL.substring(1, imageURLL.length() - 1);
                }
                bookArrayList.add(new Book(ISBN, bookTitel, bookAuthor, yearOfPublication, publisher, imageURLM, imageURLL));
            }
        } catch (IOException ioException) {
            System.out.println("Error.");
        }
    }
//=============================================================================

    public static void bubbleSort() {
    int n = bookArrayList.size();
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            String title1 = bookArrayList.get(j).bookTitle;
            String title2 = bookArrayList.get(j + 1).bookTitle;
            int min = Math.min(title1.length(), title2.length());
            int k = 0;
            do {
                if (title1.charAt(k) != title2.charAt(k)) {
                    if (title1.charAt(k) > title2.charAt(k)) {
                        Book temp = bookArrayList.get(j);
                        bookArrayList.set(j, bookArrayList.get(j + 1));
                        bookArrayList.set(j + 1, temp);
                    }
                    break;
                }
                k++;
            } while (k < min);
        }
    }
}
//=============================================================================

    public static void insertionSort() {
        int n = bookArrayList.size();
        for (int i = 0; i < n - 1; i++) {
            Book key = bookArrayList.get(i);
            int j = i - 1;
            while (j >= 0 && bookArrayList.get(j).getBookTitle().compareTo(key.getBookTitle()) > 0) {
                bookArrayList.set(j + 1, bookArrayList.get(j));
                j--;
            }
            bookArrayList.set(j + 1, key);
        }
    }
//=============================================================================

    public static void selectionSort() {
        int n = bookArrayList.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n - 1; j++) {
                if (bookArrayList.get(j).getBookTitle().compareTo(bookArrayList.get(minIndex).getBookTitle()) < 0) {
                    minIndex = j;
                }
            }
            Book temp = bookArrayList.get(minIndex);
            bookArrayList.set(minIndex, bookArrayList.get(i));
            bookArrayList.set(i, temp);

        }
    }
//=============================================================================
    public static void quick_sort_run(){
        quick_sort(bookArrayList, 0, bookArrayList.size()-1);
    }
    
    private static void quick_sort(ArrayList<Book> arrayList, int left, int right) {
        if (left < right) {
            int pivotPoint = partition(arrayList, left, right);
            quick_sort(arrayList, left, pivotPoint - 1);
            quick_sort(arrayList, pivotPoint + 1, right);
        }
    }

    private static int partition(ArrayList<Book> arrayList, int left, int right) {
        Book pivot = arrayList.get(right);
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arrayList.get(j).getBookTitle().compareTo(pivot.getBookTitle()) < 0) {
                i++;
                swap(arrayList, i, j);
            }
        }
        swap(arrayList, i + 1, right);

        return i + 1;
    }

    public static void swap(ArrayList<Book> arrayList, int i, int j) {
        Book temp = arrayList.get(i);
        arrayList.set(i, arrayList.get(j));
        arrayList.set(j, temp);

    }
//============================================================================
    public static void heapSort(){
        int n = bookArrayList.size();
        for(int i = n/2-1;i>=0;i--){
            heapify(bookArrayList,n,i);
        }
        for(int i = n-1;i>0;i--){
            Book temp = bookArrayList.get(0);
            bookArrayList.set(0, bookArrayList.get(i));
            bookArrayList.set(i, temp);
            heapify(bookArrayList, i, 0);
        }
        
    }
    public static void heapify(ArrayList<Book> arrrayList,int n,int i){
        int largest = i;
        int l = 2*i +1;
        int r = 2*i +2;
        if( l < n && arrrayList.get(l).getBookTitle().compareTo(arrrayList.get(largest).getBookTitle())>0){
            largest=l;
        }
        if( r < n && arrrayList.get(r).getBookTitle().compareTo(arrrayList.get(largest).getBookTitle())>0){
            largest=r;
        }
        if(largest!=i){
            Book temp = bookArrayList.get(i);
            bookArrayList.set(i, bookArrayList.get(largest));
            bookArrayList.set(largest, temp);
            heapify(arrrayList, n, largest);
        }
    }
//============================================================================
    public static void mergeSort_run(){
        mergeSortByTitle(bookArrayList);
    }
    
    private static void mergeSortByTitle(ArrayList<Book> books) {
        if (books.size() < 2) {
            return;
        }
        int middle = books.size() / 2;

        ArrayList<Book> leftHalf = new ArrayList<>(books.subList(0, middle)); //tạo danh sách con là nửa bên trái
        ArrayList<Book> rightHalf = new ArrayList<>(books.subList(middle, books.size())); //tạo danh sách con là nửa bên phải

        mergeSortByTitle(leftHalf);
        mergeSortByTitle(rightHalf);

        mergeSort(books, leftHalf, rightHalf);
    }
    private static void mergeSort(ArrayList<Book> books, ArrayList<Book> left, ArrayList<Book> right) {
        int leftIndex = 0;
        int rightIndex = 0;
        int booksIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex).getBookTitle().compareTo(right.get(rightIndex).getBookTitle()) < 0) {
                books.set(booksIndex++, left.get(leftIndex++));
            } else {
                books.set(booksIndex++, right.get(rightIndex++));
            }
        }

        while (leftIndex < left.size()) {
            books.set(booksIndex++, left.get(leftIndex++));
        }

        while (rightIndex < right.size()) {
            books.set(booksIndex++, right.get(rightIndex++));
        }
    }
    public static void printAll() {
        for (Book book : bookArrayList) {
            System.out.println(book);
        }
    }
    public static void printTop10(){
        for(int i =0;i < 10;i++){
            System.out.println(bookArrayList.get(i));
        }
    }
    
    public static Book binarySearch(Book target,int left,int right){
        if (left > right) return null;
        int mid = (left + right)/2;
        if (bookArrayList.get(mid).compareTo(target) == 0) return bookArrayList.get(mid);
        else if (bookArrayList.get(mid).compareTo(target) < 0) return binarySearch(target, mid + 1, right);
        else return binarySearch(target, left, mid - 1);
    }
}
