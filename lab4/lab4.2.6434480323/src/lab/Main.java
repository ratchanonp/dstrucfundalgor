package lab;

import datastr.DenseMatrix;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random rand = new Random();
        
        int row , column_1, column_2;
        row = rand.nextInt(1, 10);
        column_1 = rand.nextInt(1, 10);
        column_2 = rand.nextInt(1, 10);

        DenseMatrix m1 = new DenseMatrix(row, column_1);
        DenseMatrix m2 = new DenseMatrix(column_1, column_2);
        DenseMatrix m3 = new DenseMatrix(row, column_1);

        randomMatrix(row, column_1, 9, m1);
        randomMatrix(column_1, column_2, 9, m2);
        randomMatrix(row, column_1, 9, m3);

        System.out.println("matrix m1 = ");
        System.out.print(m1);
        System.out.println("===========================");
        System.out.println("matrix m2 = ");
        System.out.print(m2);
        System.out.println("===========================");
        System.out.println("matrix m3 = ");
        System.out.print(m3);
        try {
            System.out.println("===========================");
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
