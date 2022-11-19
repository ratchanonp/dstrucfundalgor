package lab;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        double[][] pM = {{2.3, 5.1, 0, 0, 0, 0},
                        {0, -9.1, 0, 0, 0, -7},
                        {0, 0, 0, 0, 0, 0}};

        double[][] qM = {{2.3, 5.1, 0, 0, 0, 0},
                        {0, -9.1, 0, 0, 0, -7},
                        {0, 0, 0, 0, 0, 0}};

        SparseMtx p = new SparseMtx(pM);
        SparseMtx q = new SparseMtx(qM);
        SparseMtx pq = p.add(q);

        double[][] pqM = pq.to2Darray();
        for (int i = 0; i < pqM.length; i++) {
            for (int j = 0; j < pqM[i].length; j++)
                System.out.printf("%6.1f", pqM[i][j]);
            System.out.println();
        }
    }
}
