/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SU23;

import java.util.LinkedList;
import java.util.Queue;

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
    private Node addNode(Teacher teacher, Node root) {
        if (root == null) {
            return new Node(teacher, null, null);
        }
        int compare = teacher.compareTo(root.data);
        if (compare < 0) {
            root.left = addNode(teacher, root.left);
        } else {
            root.right = addNode(teacher, root.right);
        }
        return root;
    }

    public void addNode(Teacher teacher) {
        root = addNode(teacher, root);
    }

    //Cau 2
    private double findMaxCoeff(Node root) {
        if (root == null) {
            return 0;
        }
        while (root.right != null) {
            root = root.right;
        }
        return root.data.coeff;
    }

    public void updateCoeff(Node root) {
        double updateValue = findMaxCoeff(root)/2;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            temp.data.coeff = temp.data.coeff + updateValue;
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }
    
    //Cau 3
    public void printNodeWithLevel(Node root,int level){
        if (root == null) return;
        System.out.println("<" + root.data.code + "," + level + "> ");
        printNodeWithLevel(root.left, level + 1);
        printNodeWithLevel(root.right, level + 1);
    }
    
    //Cau 4
    
    //Return the height
    public int updateBal(Node root){
        if (root == null) return 0;
        int leftHeight = updateBal(root.left);
        int rightHeight = updateBal(root.right);
        root.bal = leftHeight - rightHeight;
        return 1 + Math.max(leftHeight, rightHeight);
    }
    
    
    //Cau 5 
    public void preOrder(Node root){
        if (root == null) return;
        System.out.println("<" + root.data.code  +"> ");
        preOrder(root.left);
        preOrder(root.right);
    }    
    
}
