/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SP23;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author ASUS
 */
public class BinarySearchTree {
    protected Node root = new Node();

    public BinarySearchTree() {
    }

    public BinarySearchTree(Node root) {
        this.root = root;
    }
    
    // Cau 1
    private boolean findKey(int key,Node root){
        if (root == null) return false;
        int compare = key - root.data.key;
        if (compare == 0) return true;
        else if (compare < 0) return findKey(key, root.left);
        else return findKey(key, root.right);
    }
    
    public boolean findKey(int key){
        return findKey(key,root);
    }
    
    // Cau 2
    private Node addNode(Worker worker,Node root){
        if (root == null){
            root = new Node(worker, null, null);
        }
        int compare = worker.compareTo(root.data);
        if (compare < 0){
            root.left = addNode(worker, root.left);
        }
        else {
            root.right = addNode(worker, root.right);
        }
        return root;
    }
    
    public boolean addNode(Worker worker){
        if (findKey(worker.key) == true) return false;
        root = addNode(worker, root);
        return true;
    }
    
    // Cau 3 
    public void printDescOrder(Node root){
        if (root == null) return;
        printDescOrder(root.right);
        System.out.println(root.data + " ");
        printDescOrder(root.left);
    }
    
    // Cau 4
    public int BFS(Node root){
        Queue<Node> queue = new LinkedList<>();
        int count = 0;
        queue.add(root);
        while (!queue.isEmpty()){
                Node temp = queue.poll();
                if (temp.data.age < 25) count += 1;
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
        }
        return count;
    }    
    
    // Cau 5
    public Worker deleteRightMost(Node root){
        if (root == null) return null;
        if (root.right == null){
            Worker data = root.data;
            root.data = null;
            root.left = null;
            return data;
        }
        return deleteRightMost(root.right);
    }
    
    // Cau 6
    public int levelOrderHeight(Node root){
        Queue<Node> queue = new LinkedList<>();
        int level = 0;
        queue.add(root);
        while (!queue.isEmpty()){
            int count = queue.size();
            for (int i = 0;i < count;i++){
                Node temp = queue.poll();
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
            level += 1;
        }
        return level;
    }
    
    //Cau 7
    private void sort(Worker[] workerArray){
        for (int i = 0; i < workerArray.length - 1;i++){
            for (int y = 0; y < workerArray.length - 1 ;y++){
                if (workerArray[y].key < workerArray[y+1].key){
                    Worker temp = workerArray[y];
                    workerArray[y] = workerArray[y + 1];
                    workerArray[y+1] = temp;
                }
            }
        }
    }
    
    public void createHighestTree(Worker[] workerArray){
        sort(workerArray);
        root = null;
        for (Worker w:workerArray){
            addNode(w);
        }
    }
}
