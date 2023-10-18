/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graph;

/**
 *
 * @author ASUS
 */
public class Prims {

    static final int V = 6;

    private static int minDistance(int dist[], boolean sptSet[]) {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++) {
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
        }
        return min_index;
    }
     
    private static void printSolution(int dist[],int pr[],int source){
        int totalWeight = 0;
        System.out.println("Minimum Spanning Tree:");
        System.out.println("Edge\t\tWeight");
        for (int i = 0; i < V; i++){
            if (i == source) continue;
            System.out.println(pr[i] + "-" + i + "\t\t" + dist[i]);
            totalWeight += dist[i];
        }
        System.out.println("Total weight of MST: " + totalWeight);
    }
    
    public static void Prims(int graph[][],int source){
        int dist[] = new int[V];
        boolean sptSet[] = new boolean[V];
        int pr[] = new int[V];
        for (int i = 0;i < V;i++){
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
            pr[i] = 0;
        }
        dist[source] = 0;
        pr[source] = -1;
        for (int i = 0; i < V - 1; i++){
            int u = minDistance(dist, sptSet);
            sptSet[u] = true;
            for (int y = 0; y < V;y++){
                if (graph[u][y] != 0 && graph[u][y] < dist[y] && !sptSet[y]){
                    dist[y] = graph[u][y];
                    pr[y] = u;
                }
            }
        }
        printSolution(dist, pr,source);
    }
    
    public static void main(String[] args) {
        int[][] graph = { {0,4,6,0,0,0},
            {4,0,6,3,4,0},
            {6,6,0,1,0,0},
            {0,3,1,0,2,3},
            {0,4,0,2,0,7},
            {0,0,0,3,7,0},
        };
        Prims(graph, 0);
    }
}
