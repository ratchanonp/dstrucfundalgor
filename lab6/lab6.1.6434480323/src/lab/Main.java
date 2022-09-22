package lab;

import datastr.Graph;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        int nVertex = random.nextInt(5, 10); // Random nVertex
        int[][] adjMat = new int[nVertex][nVertex];
        for (int i = 0; i < nVertex; i++) {
            for (int j = 0; j < nVertex; j++) {
                adjMat[i][j] = random.nextInt() % 2 == 1 ? random.nextInt(1, 5) : 0;
            }
        }

        Graph graph_1 = new Graph(adjMat);
        Graph graph_2 = new Graph(nVertex, nVertex * nVertex / 4);
        System.out.println("Random adjacency matrix of graph 1");
        printMatrix(adjMat);
        System.out.println("-----------------");
        System.out.println("Adjacency matrix created from graph 1");
        printMatrix(graph_1.toMatrix());
        System.out.println("-----------------");
        System.out.println("Adjacency matrix created from graph 2");
        printMatrix(graph_2.toMatrix());
    }


    public static void printMatrix(int[][] adjMat){
        for (int i = 0; i < adjMat.length; i++) {
            for (int j = 0; j < adjMat[i].length; j++) {
                System.out.printf("%3d", adjMat[i][j]);
            }
            System.out.println("");
        }
    }
}
