package lab;

import datastr.Graph;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        int nVertex = random.nextInt(5, 11);                    // Random nVertex (5 - 10)
        int nEdge = (nVertex * nVertex) / 4;

        // Generate adjacency matrix for graph 1
        int[][] adjMat = new int[nVertex][nVertex];
        for (int i = 0; i < nVertex; i++) {
            for (int j = 0; j < nVertex; j++) {
                boolean isCreateEdges = random.nextBoolean();               // สุ่มว่าจะเกิด Edge จาก i ไป j ไหม (50/50)

                if (isCreateEdges) {
                    int weight = random.nextInt(1, 6);          // เกิด Edge สุ่มว่า edge มีน้ำหนักเท่าไร (1-5)
                    adjMat[i][j] = weight;
                }
            }
        }

        Graph graph_1 = new Graph(adjMat);                                    // Create Graph from adjMat
        Graph graph_2 = new Graph(nVertex, nEdge);                            // Create Graph by size
        // System.out.println("nVertex : " + nVertex);
        // System.out.println("nEdge : " + nVertex * nVertex / 4);

        System.out.println("Random adjacency matrix of graph 1");
        printMatrix(adjMat);
        System.out.println("-----------------");

        System.out.println("Adjacency matrix created from graph 1");
        printMatrix(graph_1.toMatrix());
        System.out.println("-----------------");

        System.out.println("Adjacency matrix created from graph 2");
        printMatrix(graph_2.toMatrix());
    }


    public static void printMatrix(int[][] adjMat) {
        for (int i = 0; i < adjMat.length; i++) {
            for (int j = 0; j < adjMat[i].length; j++) {
                System.out.printf("%3d", adjMat[i][j]);
            }
            System.out.println(); // new line for row
        }
    }
}
