/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SU23_Lecture;


/**
 *
 * @author ASUS
 */
public class Node {
    protected Lecturer data;
    protected Node left;
    protected Node right;

    public Node() {
    }
    
    public Node(Lecturer data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
