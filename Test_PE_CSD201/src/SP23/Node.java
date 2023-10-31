/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SP23;

/**
 *
 * @author ASUS
 */
public class Node {
    protected Worker data;
    protected Node left;
    protected Node right;

    public Node() {
    }

    public Node(Worker data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
    
}
