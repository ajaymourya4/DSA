package com.ajaymourya.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class DFS {
    private LinkedList<Integer> adjList[];
    private boolean visited[];

    DFS(int vertices) {
       adjList = new LinkedList[vertices];
       visited = new boolean[vertices];

       for (int i = 0; i < vertices; i++) {
           adjList[i] = new LinkedList<Integer>();
       }
    }

    public void addEdge(int src, int dst) {
        adjList[src].add(dst);
    }

    public void dfsTraversal(int vertex) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        Iterator<Integer> ite = adjList[vertex].listIterator();
        while (ite.hasNext()) {
            int adj = ite.next();
            if (!visited[adj])
                dfsTraversal(adj);
        }
    }

    public static void main(String args[]) {
        DFS dfs = new DFS(4);

        dfs.addEdge(0, 1);
        dfs.addEdge(0, 2);
        dfs.addEdge(1, 2);
        dfs.addEdge(2, 3);

        System.out.println("Following is Depth First Traversal");

        dfs.dfsTraversal(2);
    }
}
