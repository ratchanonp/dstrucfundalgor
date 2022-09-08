package lab;

import datastr.DenseMatrix;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        DenseMatrix m1 = new DenseMatrix(5, 10);
        DenseMatrix m2 = new DenseMatrix(10, 2);
        DenseMatrix m3 = new DenseMatrix(5, 10);

        randomMatrix(5, 10, 9, m1);
        randomMatrix(10, 2, 9, m2);
        randomMatrix(5, 10, 9, m3);

        System.out.println("matrix m1 = ");
        System.out.print(m1);
        System.out.println("===========================");
        System.out.println("matrix m2 = ");
        System.out.print(m2);
        System.out.println("===========================");
        System.out.println("matrix m3 = ");
        System.out.print(m3);
        System.out.println("===========================");
        try {
            System.out.println("m1*m2 = ");
            System.out.print(m1.multiply(m2));
            System.out.println("===========================");
            System.out.println("m1+m3 = ");
            System.out.print(m1.add(m3));
            System.out.println("===========================");
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private static void randomMatrix(int row, int col, int bound, DenseMatrix matrix) {
        Random rand = new Random();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix.set(i, j, rand.nextInt(bound));
            }
        }
    }
}
