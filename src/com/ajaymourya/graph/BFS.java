package com.ajaymourya.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class BFS {
    private LinkedList<Integer> adjList[];
    private boolean visited[];

    BFS(int numVertices) {
        adjList = new LinkedList[numVertices];
        visited = new boolean[numVertices];

        for (int i = 0; i < numVertices; i++) {
            adjList[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int v, int w) {
        adjList[v].add(w);
    }

    public void bfsTraversal(int vertex) {
        LinkedList<Integer> queue = new LinkedList<>();
        visited[vertex] = true;
        queue.add(vertex);

        while (queue.size() != 0) {
            int s = queue.poll();
            System.out.println(s + " ");

            Iterator<Integer> ite = adjList[s].listIterator();
            while (ite.hasNext()) {
                int n = ite.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFS g = new BFS(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal " +
                "(starting from vertex 2)");

        g.bfsTraversal(2);
    }
}
