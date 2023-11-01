/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SU23_Lecture;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author ASUS
 */
public class BinarySearchTree {

    protected Node root = null;

    public BinarySearchTree() {
    }

    public BinarySearchTree(Node root) {
        this.root = root;
    }

    //Cau 1
    private Node addNode(Lecturer lecturer, Node root) {
        if (root == null) {
            return new Node(lecturer, null, null);
        }
        int compare = lecturer.compareTo(root.data);
        if (compare < 0) {
            root.left = addNode(lecturer, root.left);
        } else {
            root.right = addNode(lecturer, root.right);
        }
        return root;
    }

    public void addNode(Lecturer lecturer) {
        root = addNode(lecturer, root);
    }
    
    public void buildTreeFromArray(ArrayList<Lecturer> A){
        for (Lecturer lecturer: A){
            addNode(lecturer);
        }
    }

    //Cau 2
    public int levelOrderHeight(Node root) {
        Queue<Node> queue = new LinkedList<>();
        int level = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                Node temp = queue.poll();
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            level += 1;
        }
        return level;
    }
    
    //Cau 3
    public Lecturer peek_max_mark(Node root){
        if (root == null) return null;
        while (root.right != null){
            root = root.right;
        }
        return root.data;
    }
    
    //Cau 4
    public void inorder(Node root,ArrayList<Lecturer> Ain){
        if (root == null){
            return;
        }
        inorder(root.left, Ain);
        Ain.add(root.data);
        inorder(root.right, Ain);
    }
    
    //Cau 5
    public void preorder(Node root,ArrayList<Lecturer> Apre){
        if (root == null) return;
        LinkedList<Node> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node top = stack.pop();
            if (top.right != null) stack.push(top.right);
            if (top.left != null) stack.push(top.left);
            Apre.add(top.data);
        }
    }
    
    //Cau 6
    public static BinarySearchTree buildTree(ArrayList<Lecturer> Apre){
           BinarySearchTree t2 = new BinarySearchTree();
           for (Lecturer t: Apre){
               t2.addNode(t);
           }
           return t2;
    }
}
