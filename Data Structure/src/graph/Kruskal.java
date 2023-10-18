/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Kruskal {
    // Defines edge structure 

    static class Edge {

        int src, dest, weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    static class Subset {

        int parent, rank;

        public Subset(int parent, int rank) {
            this.parent = parent;
            this.rank = rank;
        }
    }

    public static void join(Subset[] subsetArray, int x, int y) {
        int rootX = findRoot(subsetArray, x);
        int rootY = findRoot(subsetArray, y);
        if (subsetArray[rootY].rank < subsetArray[rootX].rank) {
            subsetArray[rootY].parent = rootX;
        } else if (subsetArray[rootY].rank > subsetArray[rootX].rank) {
            subsetArray[rootX].parent = rootY;
        } else {
            subsetArray[rootY].parent = rootX;
            subsetArray[rootX].rank += 1;
        }
    }

    public static int findRoot(Subset[] subsetArray, int x) {
        if (subsetArray[x].parent == x) {
            return subsetArray[x].parent;
        }
        return findRoot(subsetArray, subsetArray[x].parent);
    }

    public static void kruskals(int V,List<Edge> edges) {
        Subset[] subsetArray = new Subset[V];
        Edge[] results = new Edge[V];
        for (int i = 0; i < V; i++) {
            subsetArray[i] = new Subset(i, 0);
        }

        edges.sort(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });

        int j = 0;
        int numberOfEdges = 0;
        while (numberOfEdges < V - 1) {
            Edge currentEdge = edges.get(j);
            int rootX = findRoot(subsetArray, currentEdge.src);
            int rootY = findRoot(subsetArray, currentEdge.dest);
            if (rootX != rootY) {
                results[numberOfEdges++] = currentEdge;
                join(subsetArray, rootX, rootY);
            }
            j++;
        }
        System.out.println(
                "Following are the edges of the constructed MST:");
        int minCost = 0;
        for (int i = 0; i < numberOfEdges; i++) {
            System.out.println(results[i].src + " -- "
                    + results[i].dest + " == "
                    + results[i].weight);
            minCost += results[i].weight;
        }
        System.out.println("Total cost of MST: " + minCost);
    }

    public static void main(String[] args) 
    { 
        int V = 4; 
        List<Edge> graphEdges = new ArrayList<Edge>( 
            List.of(new Edge(0, 1, 10), new Edge(0, 2, 6), 
                    new Edge(0, 3, 5), new Edge(1, 3, 15), 
                    new Edge(2, 3, 4))); 
 
        kruskals(V, graphEdges); 
    }     
}
