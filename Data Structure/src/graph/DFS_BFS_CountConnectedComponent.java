package graph;

// Java program to print DFS traversal
// from a given graph
import java.util.*;

// This class represents a
// directed graph using adjacency
// list representation
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

    // A function used by DFS
    void DFSUtil(int v, boolean visited[]) {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");   

        // Recur for all the vertices adjacent to this
        // vertex
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }
    
    void DFS(int v) {      
        boolean visited[] = new boolean[V];
        DFSUtil(v, visited);
        System.out.println("");
    }    
    
    //Duoc add vao queue thi set true, pop ra roi add vao neighbour cua thang vua pop
    void BFSUtil(int source,int destination,boolean visited[],int[] prev){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;
        while (!queue.isEmpty()){
            int current = queue.poll();
            Iterator<Integer> i = adj[current].listIterator();
            while (i.hasNext()){
                int n = i.next();
                if (!visited[n]){
                    queue.add(n);
                    visited[n] = true;
                    prev[n] = current;
                    if (n == destination) break;
                }
            }
        }
    }
    
    void BFS(int source,int destination){
        boolean visited[] = new boolean[V];
        int prev[] = new int[V];
        BFSUtil(source,destination ,visited,prev);
        reconstructPath(source, destination, prev);
    }
    
    //Chay nguoc lai duong vua di -> In nguoc lai
    void reconstructPath(int source, int destination, int prev[]) {
        int[] path = new int[V];
        int count = 0;
        System.out.print("Path: ");
        System.out.print(source + " ");
        int current = destination;
        while (current != source) {
            path[count++] = current;
            current = prev[current];
        }
        for (int i = count - 1;i >= 0; i --){
            System.out.print(path[i] + " ");
        }
    }    


    
    int countConnectedComponentUtil(boolean visited[]){
        int count = 0;
        for (int i = 0; i < V ; i++){
            if (!visited[i]){
                count++;
                DFSUtil(i,visited);
            }
        }
        return count;
    }
    
    
    //Nếu muốn đánh số, truyền thêm biến count vào dfs và gán components[index] = count, mọi node nối với nó đều được set = count
    int countConnectedComponent(){
         return countConnectedComponentUtil(new boolean[V]);
    }
 
    

    // Driver Code
    public static void main(String args[]) {
        Graph g = new Graph(5);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 0);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 0);
        g.addEdge(2, 1);
        g.addEdge(2, 4);
        g.addEdge(3, 1);
        g.addEdge(3, 4);
        g.addEdge(4, 2);
        g.addEdge(4, 3);
        int source = 3;
        int destination = 0;
        System.out.println("BFS from " + source + " to " + destination);
        // Function call
        g.BFS(source,destination);
    }
}
