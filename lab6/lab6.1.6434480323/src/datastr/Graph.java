package datastr;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class Graph {

    Vertex[] vertices;
    Edge[] edges;
    HashMap<Edge, Integer> weight;


    public Graph(int nVertex, int nEdge) {
        Random random = new Random();

        vertices = new Vertex[nVertex];
        edges = new Edge[nEdge];
        weight = new HashMap<>();

        for (int i = 0; i < nVertex; i++) vertices[i] = new Vertex(i);  // Loop create Vertex
        for (int i = 0; i < nEdge; i++) {
            Vertex srcVertex = vertices[random.nextInt(nVertex)];       // Random Source Vertex
            Vertex destVertex = vertices[random.nextInt(nVertex)];      // Random Destination Vertex

            edges[i] = new Edge(srcVertex, destVertex);
            weight.put(edges[i], random.nextInt(1,5));
        }
    }

    public Graph(int[][] adjMat) {
        int nEdge = 0;
        for (int i = 0; i < adjMat.length; i++) {
            for (int j = 0; j < adjMat[i].length; j++) {
                if (adjMat[i][j] != 0) {
                    nEdge++;
                }
            }
        }


        vertices = new Vertex[adjMat.length];
        edges = new Edge[nEdge];
        weight = new HashMap<>();

        for (int i = 0; i < adjMat.length; i++) vertices[i] = new Vertex(i);  // Loop create Vertex

        int c = 0;
        for (int i = 0; i < adjMat.length; i++) {
            for (int j = 0; j < adjMat[i].length; j++) {
                if (adjMat[i][j] != 0) {
                    edges[c] = new Edge(vertices[i], vertices[j]);
                    weight.put(edges[c], adjMat[i][j]);
                    c++;
                }
            }
        }
    }

    public int weight(Edge e) {
        for (Edge edge : edges) {
            if (edge.equals(e)) {
                return weight.get(e);
            }
        }

        return 0;
    }

    public int[][] toMatrix() {
        int[][] result = new int[vertices.length][vertices.length];

        for (Edge edge : edges) {
            int src = edge.getSource();
            int dest = edge.getDest();
            int w = weight.get(edge);

            result[src][dest] = w;
        }

        return result;
    }

    @Override
    public String toString() {
        return "Graph{" +
                "vertices=" + Arrays.toString(vertices) +
                ", edges=" + Arrays.toString(edges) +
                ", weight=" + weight +
                '}';
    }
}
