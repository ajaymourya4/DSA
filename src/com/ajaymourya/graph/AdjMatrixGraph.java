package com.ajaymourya.graph;

public class AdjMatrixGraph {
    private int adjMatrix[][];
    private int numVertices;

    public AdjMatrixGraph(int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new int[numVertices][numVertices];
    }

    public void addEdge(int i, int j) {
        adjMatrix[i][j] = 1;
        adjMatrix[j][i] = 1;
    }

    public void removeEdge(int i, int j) {
        adjMatrix[i][j] = 0;
        adjMatrix[j][i] = 0;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < numVertices; i++) {
            s.append(i + ": ");
            for (int j = 0; j < adjMatrix[i].length; j++)
                s.append(adjMatrix[i][j] + " ");
        }
        return s.toString();
    }

    public static void main(String[] args) {
        AdjMatrixGraph graph = new AdjMatrixGraph(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);

        System.out.print(graph.toString());
    }
}
