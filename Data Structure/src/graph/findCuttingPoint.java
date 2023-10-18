/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author ASUS
 */
class Graph {

    private int V;

    // Array  of lists for
    // Adjacency List Representation
    private LinkedList<Integer> adj[];

    // Constructor
    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList();
        }
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        // Add w to v's list.
        adj[v].add(w);
    }

    void DFSUtil(int v, boolean visited[], int deletedVertex) {
        // Mark the current node as visited and print it
        visited[v] = true;

        // Recur for all the vertices adjacent to this
        // vertex
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n] && n != deletedVertex) {
                DFSUtil(n, visited, deletedVertex);
            }
        }
    }

    void DFS(int v, int deletedVertex) {
        boolean visited[] = new boolean[V];
        DFSUtil(v, visited, deletedVertex);
    }

    int countConnectedComponentUtil(boolean visited[], int deletedVertice) {
        int count = 0;
        for (int i = 0; i < V; i++) {
            if (!visited[i] && i!= deletedVertice) {
                count++;
                DFSUtil(i, visited, deletedVertice);
            }
        }
        return count;
    }

    //Nếu muốn đánh số, truyền thêm biến count vào dfs và gán components[index] = count, mọi node nối với nó đều được set = count
    int countConnectedComponent(int deletedVertice) {
        return countConnectedComponentUtil(new boolean[V], deletedVertice);
    }

    void findCuttingPoint() {
        for (int i = 0; i < V; i++) {
            if (countConnectedComponent(i) > 1) {
                System.out.println(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        // Create graphs given in above diagrams
        System.out.println("Articulation points in the graph ");
        int V = 5;
        Graph g = new Graph(V);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(0, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.findCuttingPoint();
    }
}
