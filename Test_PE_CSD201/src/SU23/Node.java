/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SU23;


/**
 *
 * @author ASUS
 */
public class Node {
    protected Teacher data;
    protected Node left;
    protected Node right;
    protected int bal;

    public Node() {
    }
    
    

    public Node(Teacher data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
