package com.ajaymourya.graph;

import java.util.ArrayList;

public class AdjListGraph {

    static void addEdge(ArrayList<ArrayList<Integer>> graph, int s, int d) {
        graph.get(s).add(d);
        graph.get(d).add(s);
    }

    // Print the graph
    static void printGraph(ArrayList<ArrayList<Integer>> graph) {
        for (int i = 0; i < graph.size(); i++) {
            System.out.println("\nVertex " + i + ":");
            for (int j = 0; j < graph.get(i).size(); j++) {
                System.out.print(" -> " + graph.get(i).get(j));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 5; i++)
            graph.add(new ArrayList<Integer>());

        // Add edges
        addEdge(graph, 0, 1);
        addEdge(graph, 0, 2);
        addEdge(graph, 0, 3);
        addEdge(graph, 1, 2);

        printGraph(graph);
    }
}
