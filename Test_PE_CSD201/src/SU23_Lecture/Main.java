/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SU23_Lecture;

import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Lecturer> A = new ArrayList<>();
        A.add(new Lecturer(5,55));
        A.add(new Lecturer(3,33));
        A.add(new Lecturer(2,2));
        A.add(new Lecturer(4,44));
        A.add(new Lecturer(7,77));
        A.add(new Lecturer(6,66));
        A.add(new Lecturer(8,88));
        A.add(new Lecturer(1,11));
        A.add(new Lecturer(9,99));
        BinarySearchTree bst = new BinarySearchTree();
        bst.buildTreeFromArray(A);
        bst.levelOrderHeight(bst.root);
        System.out.println(bst.peek_max_mark(bst.root));
        ArrayList<Lecturer> Ain = new ArrayList<>();
        bst.inorder(bst.root, Ain);
        System.out.println(Ain.toString());
        ArrayList<Lecturer> Apre = new ArrayList<>();
        bst.preorder(bst.root, Apre);  
        System.out.println(Apre.toString());
        BinarySearchTree bst2 = BinarySearchTree.buildTree(Apre);
        insertionSort(A);
        System.out.println(compareArray(A, Ain));
    }
    
    public static void insertionSort(ArrayList<Lecturer> array) {
        int n = array.size();
        for (int i = 1; i < n; ++i) {
            Lecturer key = array.get(i);
            int j = i - 1;

            // Move elements of array[0..i-1] that are greater than key
            // to one position ahead of their current position
            
            while (j >= 0 && array.get(j).compareTo(key) > 0) {
                array.set(j+1, array.get(j)) ;
                j = j - 1;
            }
            array.set(j+1, key);
        }
    }  
    
    public static boolean compareArray(ArrayList<Lecturer> A,ArrayList<Lecturer> Ain){
        for (int i = 0;i < A.size(); i ++){
            if (!A.get(i).equals(Ain.get(i))) return false;
        }
        return true;
    }
}
